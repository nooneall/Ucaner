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

import cn.ucaner.framework.mvc.service.BaseService;
import cn.ucaner.security.entity.Dept;


/**
* @Package：cn.ucaner.security.service   
* @ClassName：DeptService   
* @Description：   <p> 部门管理</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:08:28   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface DeptService extends BaseService<Dept, String> {
	/**
	 * @Description 验证部门名称是否唯一
	 * @param dept
	 * @return
	 * @date 2017年7月10日
	 */
	public Boolean isUniqueDeptName(Dept dept);

	/**
	 * @Description 验证部门编码是否唯一
	 * @param dept
	 * @return
	 * @date 2017年7月10日
	 */
	public Boolean isUniqueDeptCode(Dept dept);


}
