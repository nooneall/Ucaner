package cn.ucaner.security.entity;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import cn.ucaner.framework.mvc.entity.BaseEntity;
import com.alibaba.fastjson.JSON;

public class Role extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleCode;

	private String roleName;

	private String roleDesc;

	private Integer status;

	private String resourceIds;

	/**
	 * 前端判断user是否有该角色的标志位,不入库
	 */
	private String hasUser;

	private List<String> resourceIdList;

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	private int hasFlag; // 0表示用户不拥有此角色 1 表示拥有此角色

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public int getHasFlag() {
		return hasFlag;
	}

	public void setHasFlag(int hasFlag) {
		this.hasFlag = hasFlag;
	}

	public List<String> getResourceIdList() {
		if (resourceIdList == null) {
			if (StringUtils.isNotBlank(resourceIds)) {
				resourceIdList = JSON.parseArray(resourceIds, String.class);
			} else {
				resourceIdList = new ArrayList<String>();
			}
		}
		return resourceIdList;
	}

	public void setResourceIdList(List<String> resourceIdList) {
		this.resourceIdList = resourceIdList;
	}

	public String getHasUser() {
		return hasUser;
	}

	public void setHasUser(String hasUser) {
		this.hasUser = hasUser;
	}

}