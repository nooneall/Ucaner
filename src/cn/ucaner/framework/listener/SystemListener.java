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
package cn.ucaner.framework.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.framework.config.SystemConfig;

/**
* @Package：cn.ucaner.framework.listener   
* @ClassName：SystemListener   
* @Description：   <p> 系统初始化</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午1:52:43   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SystemListener implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger(SystemListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("System Configuration load start......");
		SystemConfig.loadSystemConfig();
		loadBusinessesXml();
		logger.info("System Configuration load end......");
	}

	/**
	 * 加载业务配置文件
	 */
	public void loadBusinessesXml() {
		// List<File> files = FileUtils.searchFiles(this.getClass().getClassLoader().getResource("/rules").getPath(),
		// new String[] { "xml" }, false);
		// for (File file : files) {
		// Businesses businesses = RuleConvertUtil.xml2Businesses(file);
		// SystemConfig.businessesMap.put(businesses.getCode(), businesses);
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
}
