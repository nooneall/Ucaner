package cn.ucaner.security.service;

import java.util.List;

import cn.ucaner.framework.mvc.service.BaseService;
import cn.ucaner.security.entity.Role;


public interface RoleService extends BaseService<Role, String> {

	/**
	 * @param role
	 * @return
	 */
	public boolean isUniqueRoleName(Role role);

	/**
	 * @param role
	 * @return
	 */
	public boolean isUniqueRoleCode(Role role);

	/**
	 * @return
	 */
	public List<Role> findAllRole();

	/**
	 * @param userId
	 * @return
	 */
	public List<Role> findRoleByUserId(String userId);

	public String saveRole(Role role);

	public void updateRole(Role role);

	/**
	 * @Description 查找所有角色信息,并为userId对应的role加入hasUser的判断信息
	 * @param userId
	 * @return
	 * @date 2017年7月6日
	 */
	public List<Role> findAllRoleWithUserInfo(String userId);

}
