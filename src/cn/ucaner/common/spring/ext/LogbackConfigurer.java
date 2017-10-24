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
package cn.ucaner.common.spring.ext;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.joran.spi.JoranException;

/**
* @Package：cn.ucaner.common.spring.ext   
* @ClassName：LogbackConfigurer   
* @Description：   <p> logBack 配置器</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 上午11:45:34   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class LogbackConfigurer {

	private LogbackConfigurer() {
		
	}
	
    /**
     *  初始化 logback by Jason
     * @param location
     * @throws FileNotFoundException
     * @throws JoranException
     */
	public static void initLogging(String location) throws FileNotFoundException, JoranException {
		String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(location);
		URL url = ResourceUtils.getURL(resolvedLocation);
		LoggerContext loggerContext = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
		//在当前的版本中,logback自动配置启动上下文,因此我们必须重置它
		loggerContext.reset();
		//重新启动记录器上下文 调用此方法允许通过groovy或xml进行配置
		new ContextInitializer(loggerContext).configureByResource(url);
	}

	/**
	 * 将指定的系统属性设置为当前工作目录
	 * @param key
	 */
	public static void setWorkingDirSystemProperty(String key) {
		System.setProperty(key, new File("").getAbsolutePath());
	}

	/**
	 * 关闭 Logback   by Jason
	 * <p/>
	 * 这不是严格必要的，但建议关闭
	 * 返回主机VM仍然存在的场景
	 * 关闭J2EE环境中的应用程序
	 */
	public static void shutdownLogging() {
		ContextSelector selector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
		LoggerContext loggerContext = selector.getLoggerContext();
		String loggerContextName = loggerContext.getName();
		LoggerContext context = selector.detachLoggerContext(loggerContextName);
		context.reset();
	}
}
