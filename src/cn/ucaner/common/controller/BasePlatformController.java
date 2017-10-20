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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ucaner.framework.mvc.controller.BaseController;
import cn.ucaner.framework.mvc.entity.BaseEntity;
import cn.ucaner.security.service.ResourceService;

/**
* @Package：cn.ucaner.common.controller   
* @ClassName：BasePlatformController   
* @Description：   <p> 后台控制类基类</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:44:23   
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
