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
import java.util.Map;

import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.security.entity.Dept;

public interface DeptDao extends BaseDao<Dept, String> {
	/**
	 * @Description 根据属性值查找部门
	 * @param paramMap
	 * @return
	 * @date 2017年7月10日
	 */
	public List<Dept> findByProperties(Map<String, Object> paramMap);

	/**
	 * @Description 统计父部门下子部门的个数
	 * @param parentId
	 * @return
	 * @date 2017年7月11日
	 */
	public Integer countByParentId(String parentId);

	/**
	 * @Description 查找所有子部门的ID 包含子部门的子部门
	 * @param deptIds
	 * @return
	 * @date 2017年7月11日
	 */
	public List<String> findAllSubDeptIds(List<String> deptIds);
}