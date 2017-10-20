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
* @ClassName：AppointmentTimeConfigException   
* @Description：   <p> 可以预约时间异常</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:49:09   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class AppointmentTimeConfigException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AppointmentTimeConfigException(String message, Throwable e) {
		super(message, e);
	}
	public AppointmentTimeConfigException(String message) {
		super(message);
	}
}
