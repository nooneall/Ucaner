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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ucaner.common.GlobalConstant;
import cn.ucaner.common.spring.ext.SpringContextHolder;
import cn.ucaner.framework.mvc.controller.BaseController;
import cn.ucaner.framework.mvc.controller.CheckParams;
import cn.ucaner.framework.mvc.controller.PageParams;
import cn.ucaner.framework.mvc.controller.RespBody;
import cn.ucaner.framework.mvc.entity.BaseEntity;
import cn.ucaner.framework.utils.StringHelper;
import cn.ucaner.security.entity.Resource;
import cn.ucaner.security.entity.User;
import cn.ucaner.security.service.ResourceService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * @Project ChuFangLiuZhuan_PlatForm
 * @Package com.sunshine.common.controller
 * @ClassName BasePlatformController.java
 * @Description 后台控制类基类
 * @JDK version used 1.8
 * @Author 于策/yu.ce@foxmail.com
 * @Create Date 2017年6月29日
 * @modify By
 * @modify Date
 * @Why&What is modify
 * @Version 1.0
 */
public abstract class BasePlatformController<T extends BaseEntity, PK extends Serializable> extends BaseController<T, PK> {
	private static Logger logger = LoggerFactory.getLogger(BasePlatformController.class);

	@Autowired
	private ResourceService resorceService;

}
