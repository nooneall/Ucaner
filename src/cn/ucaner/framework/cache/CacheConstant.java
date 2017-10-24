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
package cn.ucaner.framework.cache;

/**
 * @Package com.sunshine.platform.datas.cache
 * @ClassName CacheConstant
 * @Statement
 * 			<p>
 *            缓存组件常量
 *            </p>
 * @JDK version used
 * @Author Yuce
 * @Create Date 2016-3-30
 * @modify-Author
 * @modify-Date
 * @modify-Why/What
 * @Version 1.0
 */
public class CacheConstant {

	/**
	 * 缓存key的分割符
	 */
	public static final String CACHE_KEY_SPLIT_CHAR = ":";

	/**
	 * key模糊匹配通配符
	 */
	public static final String CACHE_KEY_PATTERN_CHAR = "*";
	/**
	 * 缓存新增
	 */
	public static final String CACHE_OP_ADD = "cache_add";

	/**
	 * 缓存删除
	 */
	public static final String CACHE_OP_DEL = "cache_del";

	/**
	 * 缓存更新
	 */
	public static final String CACHE_OP_UPDATE = "cache_update";

	/**
	 * 标记为null的值
	 */
	public static final String CACHE_NULL_STRING = "null";

	/**
	 * redis 缓存key不存在返回的标志
	 */
	public static final String CACHE_KEY_NOT_EXIST = "nil";

	/**
	 * 一天共计的秒数
	 */
	public static final int ONE_DAY_SECONDS = 86400;

	/**
	 * 7天共计的秒数
	 */
	public static final int SEVEN_DAY_SECONDS = 604800;

	/**
	 * 30天共计的秒数
	 */
	public static final int SEVEN_MONTH_SECONDS = 2592000;

	/**
	 * 银行卡卡表缓存
	 */
	public static final String CACHE_BANK_CARD_BIN_INFO_KEY_PREFIX = "bank.card.bin.infos";

	/**
	 * 医院省、市、区县缓存前缀
	 */
	public static final String CACHE_HOSPITAL_AREA_KEY_PREFIX = "hospital.area.infos";

	/**
	 * 医生用户信息缓存前缀
	 */
	public static final String CACHE_DOCTOR_USER_KEY_PREFIX = "doctor.user.infos";

	/**
	 * getDoctorPatientRecordCacheKey
	 */
	public static final String CACHE_DOCTOR_PATIENT_RECORD_KEY_PREFIX = "doctor.patient.record.infos";

	/**
	 * 医生用户认证申请时信息缓存前缀
	 */
	public static final String CACHE_DOCTOR_USER_APPLY_KEY_PREFIX = "doctorapply:";
	/**
	 * 电话咨询服务设置缓存
	 */
	public static final String CACHE_DOCTOR_SERVICE_SETTING_CONSULT_KEY_PREFIX = "doctor.service.consult.setting";

	/**
	 * 医生服务列表缓存
	 */
	public static final String CACHE_DOCTOR_SERVICE_LIST_KEY_PREFIX = "doctor.service.list.infos";
	/**
	 * 医院信息缓存前缀
	 */
	public static final String CACHE_HOSPITAL_KEY_PREFIX = "hospital.infos";
	/**
	 * 一级科室信息缓存前缀
	 */
	public static final String CACHE_HOSPITAL_DEPT_LEVELONE_KEY_PREFIX = "hospital.dept.levelOne";
	/**
	 * 二级科室信息缓存前缀
	 */
	public static final String CACHE_HOSPITAL_DEPT_LEVELTWO_KEY_PREFIX = "hospital.dept.levelTwo";

	/**
	 * 医生职称缓存前缀
	 */
	public static final String CACHE_DOCTOR_TITLE_KEY_PREFIX = "doctor.title.infos";

	/**
	 * 医生执业点
	 */
	public static final String CACHE_DOCTOR_PRACTICE_POINT_KEY_PREFIX = "doctor.practice.point.infos";

	/**
	 * 短信模板
	 */
	public static final String CACHE_MSG_SMS_LIBRARY_KEY_PREFIX = "msg.sms.library.info";
	/**
	 * 信息中心模板
	 */
	public static final String CACHE_MSG_CENTER_LIBRARY_KEY_PREFIX = "msg.center.library.info";

	/**
	 * 电话绑定关系缓存前缀
	 */
	public static final String PHONE_CALL_BIND_KEY_PREFIX = "phone.call.bind.infos";

	/**
	 * 电话管理订单缓存前缀
	 */
	public static final String PHONE_CALL_ASSOCIATED_ORDER_KEY_PREFIX = "phone.call.associated.orderno";

	/**
	 * 网易云信登录信息缓存
	 */
	public static final String NETEASE_USER_LOGIN_INFO_KEY_PREFIX = "netease.user.login.info";

	/**
	 * 短信提醒的订单信息缓存
	 */
	public static final String MSG_PROMPT_ORDER_KEY_PREFIX = "order.msg.prompt";

	/**
	 * 医生消息
	 */
	public static final String DOCTOR_MSG_COUNT_KEY_PREFIX = "doctor.msg.count";

	/**
	 * 用户消息
	 */
	public static final String PATIENT_MSG_COUNT_KEY_PREFIX = "patient.msg.count";

	/**
	 * 新订单提示缓存
	 */
	public static final String PROMPT_NEW_ORDER_KEY_PREFIX = "order.new.prompt";

	/**
	 * 医生可用排班时间缓存
	 */
	public static final String DOCTOR_AVAILABLE_TIME_KEY_PREFIX = "doctor.availabletime.infos";

	/**
	 * 医生剩余预约时间缓存
	 */
	public static final String DOCTOR_APPOINTMENT_TIME_KEY_PREFIX = "doctor.appointment.time.info";

	/**
	 * 系统服务列表项缓存
	 */
	public static final String SYS_SERVICE_LIST_KEY_PREFIX = "sys.service.infos";

	/**
	 * 系统服务规格列表项缓存
	 */
	public static final String SYS_SERVICE_SPEC_LIST_KEY_PREFIX = "sys.service.spec.infos";

	/**
	 * C端用户的备注名称
	 */
	public static final String DOCTOR_USER_ALIAS_NAME_KEY_PREFIX = "doctor.user.alias.name.infos";

	/**
	 * 咨询统计  
	 */
	public static final String PATIENT_INQUIRY_STATISTIC_PREFIX = "patient.inquiry.statistic";

	/**
	 * 用户最后登陆时间
	 */
	public static final String PATIENT_LAST_LOGINTIME = "patient.last.logintime";

	/**
	 * 订单计数
	 */
	public static final String PATIENT_ORDER_COUNT = "patient.order.count";

	/**
	 * 医生订单计数
	 */
	public static final String DOCTOR_ORDER_COUNT = "doctor.order.count";
	
	
	/**
	 * 医生收入
	 */
	public static final String DOCTOR_INCOME = "doctor.income";
	
	/**
	 * 电话咨询订单缓存
	 */
	public static final String CACHE_PHONE_ORDER_INFO_PREFIX = "phoneorder:";

	/**
	 * 电话咨询预约中未支付
	 */
	public static final String CACHE_PHONE_ORDER_HAVING_HASH = "phoneorder.having.hash:";

	/**
	 * 图文咨询订单缓存
	 */
	public static final String CACHE_TEXTIMG_ORDER_INFO_PREFIX = "textimgorder:";

	/**
	 * 图文咨询预约中未支付
	 */
	public static final String CACHE_TEXTIMG_ORDER_HAVING_HASH = "textimg.having.hash:";

	/**
	 * 退费失败订单缓存
	 */
	public static final String CACHE_ORDER_REFUND_FAIL_INFO_PREFIX = "orderrefundfail:";

	/**
	 * 支付中订单缓存
	 */
	public static final String CACHE_ORDER_PADDING_INFO_PREFIX = "orderpadding:";
}
