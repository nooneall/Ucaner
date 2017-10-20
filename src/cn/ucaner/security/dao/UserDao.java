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
import cn.ucaner.security.entity.User;


public interface UserDao extends BaseDao<User, String> {

	/**
	 * @param account
	 * @return
	 */
	public User findUserByAccount(String account);

	public void updateRoleIds(String userId, String roleIds);

	/**
	 * @Description 根据部门ID 更新部门名称
	 * @param deptId
	 * @date 2017年7月11日
	 */
	public void updateDeptNameByDeptId(String deptId, String deptName);

	/**
	 * @Description 去除人员的部门信息
	 * @param deptIds
	 * @date 2017年7月11日
	 */
	public Long removeDeptInfo(List<String> deptIds);
}
