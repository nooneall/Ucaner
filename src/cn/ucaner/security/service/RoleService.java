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
import cn.ucaner.security.entity.Role;

/**
* @Package：cn.ucaner.security.service   
* @ClassName：RoleService   
* @Description：   <p> TODO</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:09:00   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
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
