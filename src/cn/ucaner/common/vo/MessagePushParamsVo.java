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

import java.io.Serializable;
import java.util.Map;

/**
* @Package：cn.ucaner.common.vo   
* @ClassName：MessagePushParamsVo   
* @Description：   <p> 消息推送VO</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月19日 下午7:31:02   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class MessagePushParamsVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6923896390104180045L;

	/**
	 * 接收者类型 1-医生 2-患者
	 */
	private String receiveType;

	/**
	 * 推送类型 1-信息 2-手机通知
	 */
	private String msgLibraryType;

	/**
	 * 信息编码
	 */
	private String msgCode;

	/**
	 * 登录用户Id
	 */
	private String userId;

	/**
	 * 登录用户账号
	 */
	private String account;

	/**
	 * key 模板的关键字   值根据业务自己设置
	 */
	private Map<String, Serializable> paramMap;

	/**
	 * @param receiveType
	 * @param msgLibraryType
	 * @param msgCode
	 * @param userId
	 * @param account
	 * @param paramMap
	 */
	public MessagePushParamsVo(String receiveType, String msgLibraryType, String msgCode, String userId, String account,
			Map<String, Serializable> paramMap) {
		super();
		this.receiveType = receiveType;
		this.msgLibraryType = msgLibraryType;
		this.msgCode = msgCode;
		this.userId = userId;
		this.account = account;
		this.paramMap = paramMap;
	}

	public MessagePushParamsVo() {
		super();
	}

	/**
	 * @return the receiveType
	 */
	public String getReceiveType() {
		return receiveType;
	}

	/**
	 * @param receiveType the receiveType to set
	 */
	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}

	/**
	 * @return the msgLibraryType
	 */
	public String getMsgLibraryType() {
		return msgLibraryType;
	}

	/**
	 * @param msgLibraryType the msgLibraryType to set
	 */
	public void setMsgLibraryType(String msgLibraryType) {
		this.msgLibraryType = msgLibraryType;
	}

	/**
	 * @return the msgCode
	 */
	public String getMsgCode() {
		return msgCode;
	}

	/**
	 * @param msgCode the msgCode to set
	 */
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the paramMap
	 */
	public Map<String, Serializable> getParamMap() {
		return paramMap;
	}

	/**
	 * @param paramMap the paramMap to set
	 */
	public void setParamMap(Map<String, Serializable> paramMap) {
		this.paramMap = paramMap;
	}

}
