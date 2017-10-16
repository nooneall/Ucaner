/**
 * <html>
 * <body>
 *  <P> Copyright 2017 阳光康众</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2016年4月8日</p>
 *  <p> Created by x-lan</p>
 *  </body>
 * </html>
 */
package cn.ucaner.security.service;

import java.util.List;

import cn.ucaner.framework.mvc.service.BaseService;
import cn.ucaner.security.entity.UserRole;


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
