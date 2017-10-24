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
package cn.ucaner.security.dao;

import java.util.List;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.Resource;


public interface ResourceDao extends BaseDao<Resource, String> {

	List<Resource> findMenuListByParentId(String resourceId);

	List<Resource> findMenuList();

	List<Resource> findResourcesByUserAccount(String userAccount);

	Resource findResourceByName(Resource resource);

	Resource findResourceByCode(Resource resource);

	List<Resource> findAllResource();

	List<Resource> findResourceByParentId(String resourceId);

	List<Resource> findAllMenuList();

	List<Resource> findResourceByParentCode(String code,String type);

	List<Resource> findButtonListByParentCode(List<String> rslist);

	List<Resource> findDataAuthorityResources();

	public void deleteResourceByParentId(String parentId, String resourceType);

	public List<Resource> findAllSubResourceByParentId(List<String> resourceParentIds);

	public List<Resource> queryResourceByRoleIds(List<String> roleIds);

	public String findAllSubIdByParentId(String roleIds);

	public List<Resource> findAllRootReource();

}
