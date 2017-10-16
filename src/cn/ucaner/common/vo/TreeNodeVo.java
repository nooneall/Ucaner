/**
 * <html>
 * <body>
 *  <P> Copyright 2017 阳光康众</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017年7月5日</p>
 *  <p> Created by 于策/yu.ce@foxmail.com</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.vo;

import java.io.Serializable;

/**
 * @Project ChuFangLiuZhuan_PlatForm
 * @Package com.sunshine.platform.security.vo
 * @ClassName TreeVo.java
 * @Description
 * @JDK version used 1.8
 * @Author 于策/yu.ce@foxmail.com
 * @Create Date 2017年7月5日
 * @modify By
 * @modify Date
 * @Why&What is modify
 * @Version 1.0
 */
public class TreeNodeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2130022165000890967L;

	private String id;

	private String pId;

	private String name;

	private String isParent;

	private String checked;

	private String open;

	public TreeNodeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeNodeVo(String id, String pId, String name, String isParent, String checked, String open) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.isParent = isParent;
		this.checked = checked;
		this.open = open;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
}
