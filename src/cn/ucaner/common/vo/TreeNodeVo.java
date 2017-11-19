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
* @ClassName：TreeNodeVo   
* @Description：   <p> 树节点数据</p>
* @Author： - DaoDou 
* @CreatTime：2017年11月19日 下午7:32:02   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
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
