/**
 * <html>
 * <body>
 *  <P> Copyright 2017 阳光康众</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017年7月10日</p>
 *  <p> Created by 于策/yu.ce@foxmail.com</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.dao;

import java.util.List;
import cn.ucaner.common.vo.TreeNodeVo;

/**
 * @Project ChuFangLiuZhuan_PlatForm
 * @Package com.sunshine.common.dao
 * @ClassName CommonDao.java
 * @Description
 * @JDK version used 1.8
 * @Author 于策/yu.ce@foxmail.com
 * @Create Date 2017年7月10日
 * @modify By
 * @modify Date
 * @Why&What is modify
 * @Version 1.0
 */
public interface CommonDao {
	/**
	 * @Description 根据roleId and 父资源Id 查找 所有资源
	 * @param roleId
	 * @return
	 * @date 2017年7月4日
	 */
	public List<TreeNodeVo> findResourceTreeByRoleIdAndParentId(String parentId, String roleId);

	public List<TreeNodeVo> findResourceTreeByRoleId(String roleId);

	/**
	 * @Description 根据roleId and 父资源Id 查找 所有资源
	 * @param userId
	 * @param parentId
	 * @return
	 * @date 2017年7月4日
	 */
	public List<TreeNodeVo> findDeptTreeByUserIdAndParentId(String userId, String parentId);

	/**
	 * @Description 根据userId 查找 所有资源
	 * @param userId
	 * @return
	 * @date 2017年7月10日
	 */
	public List<TreeNodeVo> findDeptTreeByUserId(String userId);
	
	/**
	 * @Description 根据resourceId 查找 所有菜单资源
	 * @param resourceId
	 * @return
	 * @date 2017年7月10日
	 */
	public List<TreeNodeVo> findMenuResourceTreeByResourceId(String resourceId);

}
