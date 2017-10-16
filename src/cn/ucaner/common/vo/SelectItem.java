/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2016年9月25日</p>
 *  <p> Created by 申姜</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.vo;

import java.io.Serializable;

/**
 * @Project: easy_health 
 * @Package: com.sunshine.common.vo
 * @ClassName: SelectItem
 * @Description: <p>下拉列表框传值对象</p>
 * @JDK version used: 
 * @Author: 申姜
 * @Create Date: 2016年9月25日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class SelectItem implements Serializable {

	private static final long serialVersionUID = -3944158645315248766L;
	/**
	 * 值
	 */
	private String value;
	/**
	 * 文本
	 */
	private String text;

	public SelectItem() {
		super();
	}

	/**
	 * @param value
	 * @param text
	 */
	public SelectItem(String value, String text) {
		super();
		this.value = value;
		this.text = text;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
