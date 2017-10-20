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
* @ClassName：IllegalDateException   
* @Description：   <p> 非法的数据异常</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:50:08   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class IllegalDateException extends OrderException {
	
	private static final long serialVersionUID = 1L;
	private int code;

	public IllegalDateException(String message) {
		super(message);
	}
	
	public IllegalDateException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
