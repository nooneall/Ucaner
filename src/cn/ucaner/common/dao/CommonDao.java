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
package cn.ucaner.common.dao;

import java.util.List;
import cn.ucaner.common.vo.TreeNodeVo;

/**
* @Package：cn.ucaner.common.dao   
* @ClassName：CommonDao   
* @Description：   <p> 通用Dao</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:45:21   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
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
