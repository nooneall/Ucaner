package cn.ucaner.security.dao;

import java.util.List;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.Resource;


public interface ResourceDao extends BaseDao<Resource, String> {

	/**
	 * @param resourceId
	 * @return
	 */
	List<Resource> findMenuListByParentId(String resourceId);

	/**
	 * @return
	 */
	List<Resource> findMenuList();

	/**
	 * @param userAccount
	 * @return
	 */
	List<Resource> findResourcesByUserAccount(String userAccount);

	/**
	 * @param resourceName
	 * @return
	 */
	Resource findResourceByName(Resource resource);

	/**
	 * @param resourceCode
	 * @return
	 */
	Resource findResourceByCode(Resource resource);

	/**
	 * @return
	 */
	List<Resource> findAllResource();

	/**
	 * @param resourceId
	 * @return
	 */
	List<Resource> findResourceByParentId(String resourceId);

	/**
	 * @return
	 */
	List<Resource> findAllMenuList();

	/**
	 * @param code
	 * @return
	 */
	List<Resource> findResourceByParentCode(String code,String type);

	/**
	 * @param rslist
	 * @return
	 */
	List<Resource> findButtonListByParentCode(List<String> rslist);

	/**
	 * 查询所有需要进行数据权限过滤的资源 add by yuce
	 * 
	 * @return
	 */
	List<Resource> findDataAuthorityResources();

	/**
	 * @Description 删除资源下的下级子资源
	 * @param parentId
	 * @param resourceType
	 *            要删除的子资源类型 null为全部删除
	 * @date 2017年7月3日
	 */
	public void deleteResourceByParentId(String parentId, String resourceType);

	/**
	 * @Description 查询父资源的下级子资源
	 * @param resourceParentIds
	 * @return
	 * @date 2017年7月4日
	 */
	public List<Resource> findAllSubResourceByParentId(List<String> resourceParentIds);

	/**
	 * @Description 根据角色Id列表查询
	 * @param roleIds
	 * @return
	 * @date 2017年7月4日
	 */
	public List<Resource> queryResourceByRoleIds(List<String> roleIds);

	public String findAllSubIdByParentId(String roleIds);

	/**
	 * @Description 查找所有根节点资源
	 * @return
	 * @date 2017年7月5日
	 */
	public List<Resource> findAllRootReource();

}
