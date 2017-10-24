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

	public List<Dept> findByProperties(Map<String, Object> paramMap);

	public Integer countByParentId(String parentId);

	public List<String> findAllSubDeptIds(List<String> deptIds);
}