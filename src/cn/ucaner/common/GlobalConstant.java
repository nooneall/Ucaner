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
* @Package：cn.ucaner.common   
* @ClassName：GlobalConstant   
* @Description：   <p> 全局变量</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午2:33:12   
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
	public static Integer STATUS_VALID;

	/************************ 日期转换常量定义 end **************************/

	/************************ 前后台传递参数常量定义 start **************************/
	/**
	 * 保存在session中的后台管理 用户登录信息键值常量
	 */
	public final static String SESSION_PLATFORM_USER_KEY = "platformUser";

	/**
	 * 保存在session中的医生端管理 用户登录信息键值常量
	 */
	public final static String SESSION_DOCTOR_USER_KEY = "doctorUser";
	/**
	 * 保存在session中的患者端管理 用户登录信息键值常量
	 */
	public final static String SESSION_PATIENT_USER_KEY = "patientUser";

	/**
	 * 保存在cookies中的登录信息键值常量
	 */
	public final static String COOKIES_USER_KEY = "cookiesUser";

	/**
	 * 保存在cookies中的登录账号信息键值常量
	 */
	public final static String COOKIES_LOGINACCOUNT_KEY = "cookiesLoginAccount";

	/**
	 * 保存在cookies中的登录密码信息键值常量
	 */
	public final static String COOKIES_LOGINPASSWORD_KEY = "cookiesLoginPassword";

	/************************ 前后台传递参数常量定义 end **************************/

	/************************ 字符常量定义 start ****************************/
	/**
	 * 全局分隔符
	 */
	public final static String GLOBAL_SEPARATOR = "_";
	/**
	 * 脱敏信息脱敏后的显示字符
	 */
	public static final String VIEW_SENSITIVE_CHAR = "*";

	/**
	 * session中key需要组合时的连接字符
	 */
	public static final String SESSION_KEY_CONCAT_CHAR = "-";
	/************************ 字符常量定义 end ****************************/

	/************************ 文件上传参数常量定义 start **************************/
	/**
	 * 患者头像上传路径
	 */
	public static final String PATIENT_LOG_PATH = SystemConfig.getStringValue("patient_log_path");

	/**
	 * 二维码上传路径
	 */
	public static final String QRCODE_PATH = SystemConfig.getStringValue("qrcode_path");

	/**
	 * DES加解密key
	 */
	public static final String DES_KEY_PATH = SystemConfig.getStringValue("des_key");

	/************************ 文件上传参数常量定义 end **************************/
	
	/************************ 订单流水号缓存类型key start **************************/
	
	public static final String EH_COMMON_ORDER_SERIAL_NUMBER = "easyhealth_common_order_serial_number";

	public static final String EH_MEDICARE_ORDER_SERIAL_NUMBER = "easyhealth_medicare_order_serial_number";
	
	/************************ 订单流水号缓存类型key end **************************/

	/************************
	 * 注册用户 家人 就诊人 等人员信息相关常量定义 start
	 **********************/
	/**
	 * 男
	 */
	public static final int SEX_MAN = 1;
	/**
	 * 女
	 */
	public static final int SEX_WOMEN = 2;
	/************************
	 * 注册用户 家人 就诊人 等人员信息相关常量定义 end
	 **********************/

	public static final int NO = 0;
	public static final int YES = 1;
	/**
	 * 部分
	 */
	public static final int PART_YES = 2;

	public static final String CSS_VERSION = "css_version";
	public static final String JS_VERSION = "js_version";

	/************************ 支付相关常量定义 start **************************/
	/**
	 * 支付方式编码:医程通钱包
	 */
	public static final String TRADE_TYPE_YCT_WALLET = "yctWallet";

	/**
	 * 支付方式编码:银联支付
	 */
	public static final String TRADE_TYPE_UNIONPAY = "unionpay";

	/**
	 * 支付方式编码:微信支付
	 */
	public static final String TRADE_TYPE_WECHAT = "wechat";

	/**
	 * 支付方式编码:支付宝支付
	 */
	public static final String TRADE_TYPE_ALIPAY = "alipay";

	/**
	 * 支付方式编码:医保支付
	 */
	public static final String TRADE_TYPE_MEDICARE_PAYMENT = "medicarePayment";

	/**
	 * 支付方式编码:银联先诊后付（代收）
	 */
	public static final String TRADE_TYPE_DS_UNIONPAY = "dsunionpay";

	/**
	 * 支付方式值:医程通钱包
	 */
	public static final int TRADE_TYPE_YCT_WALLET_VALUE = 1;

	/**
	 * 支付方式值:银联支付
	 */
	public static final int TRADE_TYPE_UNIONPAY_VALUE = 2;

	/**
	 * 支付方式值:微信支付
	 */
	public static final int TRADE_TYPE_WECHAT_VALUE = 3;

	/**
	 * 支付方式值:支付宝支付
	 */
	public static final int TRADE_TYPE_ALIPAY_VALUE = 4;

	/**
	 * 支付方式值:医保支付
	 */
	public static final int TRADE_TYPE_MEDICARE_PAYMENT_VALUE = 5;

	/**
	 * 支付方式编码:银联先诊后付（代收）
	 */
	public static final int TRADE_TYPE_DS_UNIONPAY_VALUE = 6;

	/**
	 * 支付方式编码:医程通钱包
	 */
	public static final String TRADE_TYPE_YCT_WALLET_NAME = "医程通钱包";
	public static final String TRADE_TYPE_YCT_WALLET_ICON_NAME = "";

	/**
	 * 支付方式名称:银联支付
	 */
	public static final String TRADE_TYPE_UNIONPAY_NAME = "银联支付";
	public static final String TRADE_TYPE_UNIONPAY_ICON_NAME = "icon-upay";

	/**
	 * 支付方式名称:微信支付
	 */
	public static final String TRADE_TYPE_WECHAT_NAME = "微信支付";
	public static final String TRADE_TYPE_WECHAT_ICON_NAME = "icon-wpay";

	/**
	 * 支付方式名称:支付宝支付
	 */
	public static final String TRADE_TYPE_ALIPAY_NAME = "支付宝支付";
	public static final String TRADE_TYPE_ALIPAY_ICON_NAME = "icon-alipay";

	/**
	 * 支付方式名称:医保支付
	 */
	public static final String TRADE_TYPE_MEDICARE_PAYMENT_NAME = "医保支付";
	public static final String TRADE_TYPE_MEDICARE_ICON_NAME = "icon-si";

	/**
	 * 支付方式名称:银联先诊后付（代收）
	 */
	public static final String TRADE_TYPE_DS_UNIONPAY_NAME = "先诊后付";

	/************************ 支付相关常量定义 end **************************/

	/************************ 消息相关常量定义 start **************************/
	/** 消息模板类型--短信 **/
	public static final int MSG_LIBRARY_TYPE_SMS = 1;
	/** 消息模板类型--app端 **/
	public static final int MSG_LIBRARY_TYPE_CENTER = 2;

	/** 消息发送状态--待发送 **/
	public static final int MSG_UNSEND = 0;
	/** 消息发送状态--发送中 **/
	public static final int MSG_SENDING = 1;
	/** 消息发送状态--发送完成 **/
	public static final int MSG_SEND_SUCCESS = 2;
	/** 消息发送状态--发送失败 **/
	public static final int MSG_SEND_FAILURE = 3;

	/** 接收消息用户--医生 **/
	public static final int MSG_RECEIVE_USER_Doctor = 1;
	/** 接收消息用户--患者 **/
	public static final int MSG_RECEIVE_USER_PATIENT = 2;
	/************************ 消息相关常量定义 end **************************/
	
	/********************** 服务类型 *************************************/
	/** 图文咨询  **/
	public static final int SERVICE_TYPE_TEXT_IMAGE = 1;
	/** 电话咨询  **/
	public static final int SERVICE_TYPE_PHONE_CALL = 2;
	/** 视频咨询  **/
	public static final int SERVICE_TYPE_VEDIO_CALL = 3;
	public static final String STRING_SPLIT_CHAR = null;
	public static final Object SESSION_PLATFORM_USER_ACCOUNT_KEY = null;

}
