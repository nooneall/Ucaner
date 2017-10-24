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
package cn.ucaner.security.vo;

import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.security.vo   
* @ClassName：RoleVo   
* @Description：   <p> 权限vo</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:09:53   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class RoleVo {
	private Integer id;
	// 权限名
	private String rolename;
	// 一个角色对应多个权限
	private List<Permission> permissionList;
	// 一个角色对应多个用户
	private List<UserVo> userList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<UserVo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVo> userList) {
		this.userList = userList;
	}

	public List<String> getPermissionsName() {
		List<String> list = new ArrayList<String>();
		List<Permission> perlist = getPermissionList();
		for (Permission per : perlist) {
			list.add(per.getPermissionname());
		}
		return list;
	}
}
