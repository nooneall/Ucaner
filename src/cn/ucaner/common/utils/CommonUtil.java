/**
 * <html>
 * <body>
 *  <P> Copyright 2014 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 20170828</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import cn.ucaner.framework.config.SystemConfig;

public class CommonUtil {
	private static String SYSTEM_REQUEST_PATH = "";

	/**
	 * 获取系统request Scheme
	 * 
	 * @return
	 */
	public static String getRequestContextPath(HttpServletRequest request) {
		if (StringUtils.isBlank(SYSTEM_REQUEST_PATH)) {
			String requestScheme = SystemConfig.getStringValue("system.request.scheme", "http://");
			SYSTEM_REQUEST_PATH = requestScheme + request.getServerName()
					+ (80 == request.getServerPort() ? "" : ":" + request.getServerPort());
		}
		return SYSTEM_REQUEST_PATH.concat(request.getContextPath());
	}
}
