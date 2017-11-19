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
import java.util.HashMap;
import java.util.Map;

/**
* @Package：com.sunshine.common.vo   
* @ClassName：FormParams   
* @Description：   <p> 查询参数</p>
* @Author： - DaoDou 
* @CreatTime：2017年9月12日 下午1:48:17   
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
