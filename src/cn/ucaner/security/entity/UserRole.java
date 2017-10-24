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
package cn.ucaner.security.entity;

import cn.ucaner.framework.mvc.entity.BaseEntity;

public class UserRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String roleId;

	/**
	 * 是否有效 1：有效 0：无效<br>
	 * GlobalConstant.STATUS_VALID = 1<br>
	 * GlobalConstant.STATUS_INVALID = 0
	 */
	private Integer status;

	public UserRole() {
		super();
	}

	public UserRole(String userId, String roleId, Integer status) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}