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

/**
* @Package：cn.ucaner.common.utils   
* @ClassName：TradeCommonHoder   
* @Description：   <p> 交易公共处理类 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 上午10:55:14   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class TradeCommonHoder {

	/**
	 * 数据请求成功
	 */
	public static final String MOTHED_INVOKE_RES_SUCCESS = "SUCCESS";

	/**
	 * 数据请求失败
	 */
	public static final String MOTHED_INVOKE_RES_FAIL = "FAIL";

	/**
	  * 1:待支付
	  */
	public final static int TRADE_STATUS_NO_PAYMENT = 1;

	/**
	 * 1:待支付
	 */
	public final static String TRADE_STATUS_NO_PAYMENT_MARK = "NO_PAYMENT";

	/**
	 * 1:待支付
	 */
	public final static String TRADE_STATUS_NO_PAYMENT_VIEW = "待支付";

	/**
	 * 2:已支付
	 */
	public final static int TRADE_STATUS_PAYMENT = 2;

	/**
	 * 2:已支付
	 */
	public final static String TRADE_STATUS_PAYMENT_MARK = "PAYMENT";

	/**
	 * 2:已支付
	 */
	public final static String TRADE_STATUS_PAYMENT_VIEW = "支付成功";

	/**
	 * 3:已退款
	 */
	public final static int TRADE_STATUS_REFUND = 3;

	/**
	 * 3:已退款
	 */
	public final static String TRADE_STATUS_REFUND_MARK = "REFUND";

	/**
	 * 3:已退款
	 */
	public final static String TRADE_STATUS_REFUND_VIEW = "退款成功";

	/**
	 * 4:支付中
	 */
	public final static int TRADE_STATUS_PAYMENTING = 4;

	/**
	 * 4:支付中
	 */
	public final static String TRADE_STATUS_PAYMENTING_MARK = "PAYMENTING";

	/**
	 * 4:支付中
	 */
	public final static String TRADE_STATUS_PAYMENTING_VIEW = "支付中";

	/**
	 * 5:退费中
	 */
	public final static int TRADE_STATUS_REFUNDING = 5;

	/**
	 * 5:退费中
	 */
	public final static String TRADE_STATUS_REFUNDING_MARK = "REFUNDING";

	/**
	 * 5:退费中
	 */
	public final static String TRADE_STATUS_REFUNDING_VIEW = "退款中";

	/**
	 * 6:关闭
	 */
	public final static int TRADE_STATUS_CLOSE = 6;

	/**
	 * 6:关闭
	 */
	public final static String TRADE_STATUS_CLOSE_MARK = "CLOSE";

}
