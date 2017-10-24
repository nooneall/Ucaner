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

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Package：cn.ucaner.common.spring.ext.web   
* @ClassName：LogbackConfigServlet   
* @Description：   <p> 在一个web环境中为自定义Logback初始化的引导servlet。
*					委派到LogbackWebConfigurer(请参阅其javadoc的配置细节)。</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 下午1:58:50   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class LogbackConfigServlet extends HttpServlet {

	private static final long serialVersionUID = 3181533221135461498L;

	/**
	* 描述: 初始化
	 */
	@Override
	public void init() {
		WebLogbackConfigurer.initLogging(getServletContext());
	}

	/**
	* 描述: 销毁
	 */
	@Override
	public void destroy() {
		WebLogbackConfigurer.shutdownLogging(getServletContext());
	}

	/**
	* 描述:获取servlet信息
	 */
	@Override
	public String getServletInfo() {
		return "LogbackConfigServlet for Servlet API 2.2/2.3 " + "(deprecated in favor of LogbackConfigListener for Servlet API 2.4+)";
	}

	/**
	 * 这甚至不应该被调用，因为没有映射到这个servlet应该在web.xml中创建。
	 * 这就是正确调用Servlet 2.3的原因侦听器更适合初始化工作
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		getServletContext().log("Attempt to call service method on LogbackConfigServlet as [" + request.getRequestURI() + "] was ignored");
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
}
