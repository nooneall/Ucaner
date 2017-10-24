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
package cn.ucaner.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import cn.ucaner.framework.config.SystemConfig;

/**
 * @Package com.sunshine.common.utils
 * @ClassName CommonUtil
 * @Statement
 * 			<p>
 *            </p>
 * @JDK version used: 1.7
 * @Author: 无名子
 * @Create Date: 2016-4-8
 * @modify-Author:
 * @modify-Date:
 * @modify-Why/What:
 * @Version 1.0
 */
public class CommonUtil {
	private static String SYSTEM_REQUEST_PATH = "";

	/**
	 * 获取系统request Scheme
	 * 
	 * @return
	 */
	public static String getRequestContextPath(HttpServletRequest request) {
		if (StringUtils.isBlank(SYSTEM_REQUEST_PATH)) {
			String requestScheme = SystemConfig.getStringValue("system.request.scheme", "https://");
			SYSTEM_REQUEST_PATH = requestScheme + request.getServerName()
					+ (80 == request.getServerPort() ? "" : ":" + request.getServerPort());
		}
		return SYSTEM_REQUEST_PATH.concat(request.getContextPath());
	}
}
