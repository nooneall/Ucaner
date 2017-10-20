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
package cn.ucaner.common.exception;

/**
* @Package：cn.ucaner.common.exception   
* @ClassName：OrderException   
* @Description：   <p> 订单异常</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:50:29   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderException(String message, Throwable e) {
		super(message, e);
	}
	public OrderException(String message) {
		super(message);
	}
}
