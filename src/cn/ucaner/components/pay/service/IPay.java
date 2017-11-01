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
package cn.ucaner.components.pay.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public interface IPay {

	public final Logger logger = LogManager.getLogger(IPay.class);

	/**
	 * 创建订单
	 * @param t
	 */
	public <T> String createOrder(T t);
	/**
	 * 退款
	 * @param
	 */
	public <T> Object refund(T t) throws Exception;
	/**
	 * 生成客户端请求支付的参数
	 * @param t
	 * @return
	 */
	public <T> Object createPayParams(T t);

	/**
	 * 查询订单状态
	 * @param orderId
	 * @return
	 */
	public Object queryOrderStatus(String orderId);
}
