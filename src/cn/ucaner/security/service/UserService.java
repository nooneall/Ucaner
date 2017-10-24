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
import cn.ucaner.security.entity.User;

/**
* @Package：cn.ucaner.security.service   
* @ClassName：UserService   
* @Description：   <p> 用户操作</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:09:25   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public interface UserService extends BaseService<User, String> {

	/**
	 * @param account
	 * @return
	 */
	public User findUserByAccount(String account);

	/**
	 * @param user
	 * @return
	 */
	public boolean isUniqueAccount(User user);

	/**
	 * @Description 保存新用户
	 * @param user
	 * @return 用户Id
	 * @date 2017年7月3日
	 */
	public String saveUser(User user);

	/**
	 * @Description 更新用户信息
	 * @param user
	 * @date 2017年7月3日
	 */
	public void updateUser(User user);
}
