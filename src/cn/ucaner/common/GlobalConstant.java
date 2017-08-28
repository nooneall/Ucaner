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
package cn.ucaner.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import cn.ucaner.framework.config.SystemConfig;

/**
*    
* @Package：cn.ucaner.common   
* @ClassName：GlobalConstant   
* @Description：   <p> 全局常量配置类</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月28日 下午5:48:15   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class GlobalConstant {
	/************************ 文件存放的常量 start **************************/
	/** 文件上传根目录 **/
	public static String filePath = SystemConfig.getStringValue("file_path");
	/** 当前域名 **/
	public static String domainName = SystemConfig.getStringValue("domain_name");
	/************************ 文件存放的常量 end **************************/

	/************************ 日期转换常量定义 start **************************/
	/**
	 * 中文日期 yyyy-MM-dd E
	 */
	public static DateFormat YYYYMMDDE = new SimpleDateFormat("yyyy-MM-dd E", Locale.CHINESE);

	/**
	 * yyyy-MM-dd
	 */
	public static DateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static DateFormat YYYYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * HH:mm
	 */
	public static DateFormat HHMM = new SimpleDateFormat("HH:mm");
	/**
	 * HHmm
	 */
	public static DateFormat hhmm = new SimpleDateFormat("HHmm");

	/**
	 * css 版本
	 */
	public static final String CSS_VERSION = "css_version";
	
	/**
	 * js版本
	 */
	public static final String JS_VERSION = "js_version";

}
