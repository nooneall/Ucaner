package cn.ucaner.security.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserVo {

	private Integer id;
	// @NotEmpty(message="用户名不能为空")
	private String username;
	// @NotEmpty(message="密码不能为空")
	private String password;
	private List<RoleVo> roleList;// 一个用户具有多个角色

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleVo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleVo> roleList) {
		this.roleList = roleList;
	}

	public Set<String> getRolesName() {
		List<RoleVo> roles = getRoleList();
		Set<String> set = new HashSet<String>();
		for (RoleVo role : roles) {
			set.add(role.getRolename());
		}
		return set;
	}
}
