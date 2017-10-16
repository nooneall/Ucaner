package cn.ucaner.security.vo;

public class Permission {
	private Integer id;
	private String permissionname;
	private RoleVo role;// 一个权限对应一个角色

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionname() {
		return permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

	public RoleVo getRole() {
		return role;
	}

	public void setRole(RoleVo role) {
		this.role = role;
	}
}
