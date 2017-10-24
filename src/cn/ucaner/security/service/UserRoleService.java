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
package cn.ucaner.security.service;

import java.util.List;

import cn.ucaner.framework.mvc.service.BaseService;
import cn.ucaner.security.entity.UserRole;

/**
* @Package：cn.ucaner.security.service   
* @ClassName：UserRoleService   
* @Description：   <p> 用户角色管理</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:09:12   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface UserRoleService extends BaseService<UserRole, String> {

	/**
	 * @param userId
	 * @return
	 */
	List<UserRole> findUserRoleByUser(String userId);

	/**
	 * @param roleId
	 * @return
	 */
	List<UserRole> findUserRoleByRole(String roleId);

	/**
	 * @param userId
	 * @return
	 */
	List<UserRole> findUserRoleByUserList(List<String> userIds);

	/**
	 * @param roleId
	 * @return
	 */
	List<UserRole> findUserRoleByRoleList(List<String> roleIds);

}
