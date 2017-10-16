package cn.ucaner.security.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import cn.ucaner.framework.mvc.entity.BaseEntity;
import com.alibaba.fastjson.JSON;

public class User extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 帐号
	 */
	protected String account;

	/**
	 * 姓名
	 */
	protected String name;

	/**
	 * 手机号码
	 */
	protected String mobile;

	/**
	 * 密码
	 */
	protected String password;

	/**
	 * 备注
	 */
	protected String remark;

	/**
	 * 状态
	 */
	protected Integer status;

	/**
	 * 角色
	 */
	protected String roleIds;

	protected List<String> roleIdList;

	/**
	 * 原密码
	 */
	protected String oldPassword;

	/**
	 * 新密码
	 */
	protected String newPassword;

	protected String deptId;

	protected String deptName;

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the confirmNewPassword
	 */
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	/**
	 * @param confirmNewPassword
	 *            the confirmNewPassword to set
	 */
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	/**
	 * 确认新密码
	 */
	private String confirmNewPassword;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoleIdList() {
		if (roleIdList == null) {
			if (StringUtils.isNotBlank(roleIds)) {
				roleIdList = JSON.parseArray(roleIds, String.class);
			} else {
				roleIdList = new ArrayList<>();
			}
		}
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}