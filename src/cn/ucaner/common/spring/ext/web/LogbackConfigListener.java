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
 * Bootstrap listener for custom Logback initialization in a web environment.
 * Delegates to WebLogbackConfigurer (see its javadoc for configuration details).
 * <p/>
 * <b>WARNING: Assumes an expanded WAR file</b>, both for loading the configuration
 * file and for writing the log files. If you want to keep your WAR unexpanded or
 * don't need application-specific log files within the WAR directory, don't use
 * Logback setup within the application (thus, don't use Log4jConfigListener or
 * LogbackConfigServlet). Instead, use a global, VM-wide Log4J setup (for example,
 * in JBoss) or JDK 1.4's <code>java.util.logging</code> (which is global too).
 * <p/>
 * This listener should be registered before ContextLoaderListener in web.xml,
 * when using custom Logback initialization.
 * <p/>
 * For Servlet 2.2 containers and Servlet 2.3 ones that do not initialize listeners before servlets, use
 * LogbackConfigServlet. See the ContextLoaderServlet javadoc for details.
 *
 * @author Juergen Hoeller
 * @author Les Hazlewood
 * @see WebLogbackConfigurer
 * @see LogbackConfigListener
 * @see LogbackConfigServlet
 * @since 0.1
 */
public class LogbackConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		WebLogbackConfigurer.shutdownLogging(event.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		WebLogbackConfigurer.initLogging(event.getServletContext());
	}
}