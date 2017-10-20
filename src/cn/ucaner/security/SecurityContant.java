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
package cn.ucaner.security;

/**
* @Package：cn.ucaner.security   
* @ClassName：SecurityContant   
* @Description：   <p> TODO</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:10:13   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SecurityContant {
	/**
	 * 资源-菜单
	 */
	public static final String RESOURCE_TYPE_MENU = "1";
	/**
	 * 资源-按钮
	 */
	public static final String RESOURCE_TYPE_BUTTON = "2";

	// 资源的操作方式 1:跳转action或页面的url 2:调用js function 3：其他
	public static final int RESOURCE_OPEN_ACTION = 1;
	public static final int RESOURCE_OPEN_FINCTION = 2;
	public static final int RESOURCE_OPEN_OTHER = 3;

}
