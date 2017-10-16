/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2016年4月14日</p>
 *  <p> Created by 申姜</p>
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
