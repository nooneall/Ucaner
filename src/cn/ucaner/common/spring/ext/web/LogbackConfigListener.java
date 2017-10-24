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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* @Package：cn.ucaner.common.spring.ext.web   
* @ClassName：LogbackConfigListener   
* @Description：   <p> 在web环境中为自定义Logback初始化提供引导侦听器。
*					委托给WebLogbackConfigurer(请参阅其javadoc的配置细节)。</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 下午2:01:35   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class LogbackConfigListener implements ServletContextListener {

	/**
	* 描述: 容器销毁
	* @param event
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		WebLogbackConfigurer.shutdownLogging(event.getServletContext());
	}

	/** 
	* 描述: 容器初始化
	* @param event
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		WebLogbackConfigurer.initLogging(event.getServletContext());
	}
}