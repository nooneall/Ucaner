package cn.ucaner.security.dao;

import java.util.List;
import java.util.Map;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.Role;

//import com.sunshine.framework.mvc.mysql.dao.BaseDao;
//import com.sunshine.platform.security.entity.Role;

public interface RoleDao extends BaseDao<Role, String> {

	/**
	 * @Description 根据角色属性查询角色
	 * @param paramMap
	 * @return
	 * @date 2017年7月5日
	 */
	public List<Role> findRoleByProperties(Map<String, Object> paramMap);

	/**
	 * @Description 根据角色编码查询角色
	 * @param roleCode
	 * @return
	 * @date 2017年7月5日
	 */
	public Role findRoleByCode(String roleCode);

	/**
	 * @return
	 */
	public List<Role> findAllRole();

	/**
	 * @param userId
	 * @return
	 */
	public List<Role> findRoleByUserId(String userId);

	/**
	 * @Description 查找所有角色信息,并为userId对应的role加入hasUser的判断信息
	 * @param userId
	 * @return
	 * @date 2017年7月6日
	 */
	public List<Role> findAllRoleWithUserInfo(String userId);
}
