package cn.ucaner.security.service;

import java.util.List;

import cn.ucaner.framework.mvc.service.BaseService;
import cn.ucaner.security.entity.RoleResource;


public interface RoleResourceService extends BaseService<RoleResource, String> {

	/**
	 * @param id
	 * @return
	 */
	List<RoleResource> findRoleResource(String id);

	/**
	 * @param resourceId
	 * @return
	 */
	List<RoleResource> findResourceRole(String resourceId);

	/**
	 * @Description 根据资源列表查找
	 * @param resourceIds
	 * @return
	 * @date 2017年7月3日
	 */
	List<RoleResource> findResourceRoleList(List<String> resourceIds);

	/**
	 * @Description 根据角色列表查找
	 * @param roleIds
	 * @return
	 * @date 2017年7月3日
	 */
	List<RoleResource> findRoleResourceList(List<String> roleIds);

	/**
	 * @Description 根据角色id删除资源
	 * @param roleIds
	 * @date 2017年7月4日
	 */
	public void deleteByRoleIds(List<String> roleIds);
}
