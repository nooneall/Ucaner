package cn.ucaner.security.dao;

import java.util.List;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.UserRole;


public interface UserRoleDao extends BaseDao<UserRole, String> {

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
	 * @param roleIds
	 * @return
	 */
	List<UserRole> findUserRoleByRoleList(List<String> roleIds);

	/**
	 * @param userIds
	 * @return
	 */
	List<UserRole> findUserRoleByUserList(List<String> userIds);

	public void deleteByRoleIds(List<String> roleIds);

	public void deleteByUserId(String userId);

}
