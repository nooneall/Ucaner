package cn.ucaner.security.dao;

import java.util.List;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.RoleResource;

public interface RoleResourceDao extends BaseDao<RoleResource, String> {

	/**
	 * @param roleid
	 * @return
	 */
	public List<RoleResource> findRoleResource(String roleid);

	/**
	 * @param resourceId
	 * @return
	 */
	public List<RoleResource> findResourceRole(String resourceId);

	/**
	 * @Description 根据资源列表查找
	 * @param resourceIds
	 * @return
	 * @date 2017年7月3日
	 */
	public List<RoleResource> findResourceRoleList(List<String> resourceIds);

	/**
	 * @Description 根据角色列表查找
	 * @param roleIds
	 * @return
	 * @date 2017年7月3日
	 */
	public List<RoleResource> findRoleResourceList(List<String> roleIds);

	/**
	 * @Description 根据资源列表删除
	 * @param resourceIds
	 * @date 2017年7月3日
	 */
	public void deleteByResourceIds(List<String> resourceIds);

	/**
	 * @Description 根据角色id删除资源
	 * @param roleIds
	 * @date 2017年7月4日
	 */
	public void deleteByRoleIds(List<String> roleIds);

}
