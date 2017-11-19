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
package cn.ucaner.common.vo;

/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
import java.io.Serializable;

/**
* @Package：cn.ucaner.common.vo   
* @ClassName：Response   
* @Description：   <p> 对外接口出参</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月19日 下午7:31:35   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2526607896162883219L;

	/**
	 * 响应结果代码
	 */
	private String resultCode;

	/**
	 * 响应信息 ,当交易结果代码不成功时，该字段返回错误信息，否则返回空字符串
	 */
	private String resultMessage;

	/**
	 * 返回数据
	 */
	private String result;

	public Response() {
		super();
	}

	/**
	 * @param resultCode
	 */
	public Response(String resultCode) {
		super();
		this.resultCode = resultCode;
	}

	public Response(String resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public Response(String resultCode, String resultMessage, String result) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.result = result;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
