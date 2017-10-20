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
package cn.ucaner.framework.mvc.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.framework.mvc.controller   
* @ClassName：FormParams   
* @Description：   <p> FormParams</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月30日 下午1:54:36   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class FormParams implements Serializable {

	private static final long serialVersionUID = -5819554419875365914L;
	/**
	 * 参数
	 */
	private Map<String, Object> params = new HashMap<String, Object>();

	public FormParams() {
		super();
	}

	/**
	 * @param params
	 */
	public FormParams(Map<String, Object> params) {
		super();
		this.params = params;
	}

	/**
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
