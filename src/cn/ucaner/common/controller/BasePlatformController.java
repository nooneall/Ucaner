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
package cn.ucaner.common.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ucaner.framework.mvc.controller.BaseController;
import cn.ucaner.framework.mvc.entity.BaseEntity;
import cn.ucaner.security.service.ResourceService;

/**
* @Package：cn.ucaner.common.controller   
* @ClassName：BasePlatformController   
* @Description：   <p> 后台控制类基类</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月26日 上午9:28:05   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public abstract class BasePlatformController<T extends BaseEntity, PK extends Serializable> extends BaseController<T, PK> {
	
	//private static Logger logger = LoggerFactory.getLogger(BasePlatformController.class);

	@Autowired
	private ResourceService resorceService;

}
