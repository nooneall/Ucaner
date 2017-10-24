/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.spring.ext.web;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;

import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.util.WebUtils;

import cn.ucaner.common.spring.ext.LogbackConfigurer;
import ch.qos.logback.core.joran.spi.JoranException;

/**
* @Package：cn.ucaner.common.spring.ext.web   
* @ClassName：WebLogbackConfigurer   
* @Description：   <p>为web环境执行自定义Logback初始化的方便类,允许在web应用程序中使用日志文件路径。</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 上午11:57:01   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class WebLogbackConfigurer {

	/**
	 * 参数指定logback配置文件的位置
	 */
	public static final String CONFIG_LOCATION_PARAM = "logbackConfigLocation";
	
	/**
	 * 参数指定是否公开web应用程序根系统属性
	 */
	public static final String EXPOSE_WEB_APP_ROOT_PARAM = "logbackExposeWebAppRoot";

	private WebLogbackConfigurer() {
	}

	/**
	 * 初始化Logback,包括设置web应用程序根系统属性。
	 * @param servletContext
	 */
	public static void initLogging(ServletContext servletContext) {
		// 公开web应用程序根系统属性。
		if (exposeWebAppRoot(servletContext)) {
			WebUtils.setWebAppRootSystemProperty(servletContext);
		}

		// 只在配置文件的情况下执行自定义的登录初始化。
		String location = servletContext.getInitParameter(CONFIG_LOCATION_PARAM);
		if (location != null) {
			// 执行实际Logback初始化;其他依赖于Logback的默认初始化。
			try {
				// 解析系统属性占位符，然后才有可能解决真正的路径。
				location = SystemPropertyUtils.resolvePlaceholders(location);
				// Return a URL (e.g. "classpath:" or "file:") as-is;
				// 考虑相对于web应用程序根目录的普通文件路径。
				if (!ResourceUtils.isUrl(location)) {
					location = WebUtils.getRealPath(servletContext, location);
				}
				//将日志消息写入服务器日志。
				servletContext.log("Initializing Logback from [" + location + "]");
				// Initialize
				LogbackConfigurer.initLogging(location);
			} catch (FileNotFoundException ex) {
				throw new IllegalArgumentException("Invalid 'logbackConfigLocation' parameter: " + ex.getMessage());
			} catch (JoranException e) {
				throw new RuntimeException("Unexpected error while configuring logback", e);
			}
		}

		//如果SLF4J java.util 在类路径中可以使用日志桥，安装它。这将指导任何消息
		//从Java日志框架到SLF4J 当日志被终止时，桥将需要卸载
		try {
			Class<?> julBridge = ClassUtils.forName("org.slf4j.bridge.SLF4JBridgeHandler", ClassUtils.getDefaultClassLoader());

			Method removeHandlers = ReflectionUtils.findMethod(julBridge, "removeHandlersForRootLogger");
			if (removeHandlers != null) {
				servletContext.log("Removing all previous handlers for JUL to SLF4J bridge");
				ReflectionUtils.invokeMethod(removeHandlers, null);
			}

			Method install = ReflectionUtils.findMethod(julBridge, "install");
			if (install != null) {
				servletContext.log("Installing JUL to SLF4J bridge");
				ReflectionUtils.invokeMethod(install, null);
			}
		} catch (ClassNotFoundException ignored) {
			//Indicates the java.util.logging bridge is not in the classpath. This is not an indication of a problem.
			servletContext.log("JUL to SLF4J bridge is not available on the classpath");
		}
	}

	/**
	 * 关闭Logback，适当地释放所有文件锁
	 * 重新设置web应用程序根系统属性.
	 * @param servletContext
	 */
	public static void shutdownLogging(ServletContext servletContext) {
		//卸载SLF4J java.util.日志记录桥*在*关闭Logback框架之前。
		try {
			Class<?> julBridge = ClassUtils.forName("org.slf4j.bridge.SLF4JBridgeHandler", ClassUtils.getDefaultClassLoader());
			Method uninstall = ReflectionUtils.findMethod(julBridge, "uninstall");
			if (uninstall != null) {
				servletContext.log("Uninstalling JUL to SLF4J bridge");
				ReflectionUtils.invokeMethod(uninstall, null);
			}
		} catch (ClassNotFoundException ignored) {
			//没有必要关闭java.util日志桥。 如果它不在类路径上,它也不会启动。
		}

		try {
			servletContext.log("Shutting down Logback");
			LogbackConfigurer.shutdownLogging();
		} finally {
			// 删除web应用程序根系统属性。
			if (exposeWebAppRoot(servletContext)) {
				WebUtils.removeWebAppRootSystemProperty(servletContext);
			}
		}
	}

	/**
	 * 返回是否公开web应用程序根系统属性，
	 * 检查相应的ServletContext init参数。
	 * @param servletContext
	 * @return
	 */
	private static boolean exposeWebAppRoot(ServletContext servletContext) {
		String exposeWebAppRootParam = servletContext.getInitParameter(EXPOSE_WEB_APP_ROOT_PARAM);
		return ( exposeWebAppRootParam == null || Boolean.valueOf(exposeWebAppRootParam) );
	}
}
