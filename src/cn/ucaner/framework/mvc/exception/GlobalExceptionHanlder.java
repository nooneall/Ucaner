/**
 * <html>
 * <body>
 *  <P> Copyright 2014 广东天泽阳光康众医疗投资管理有限公司. 粤ICP备09007530号-15</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2017-6-17</p>
 *  <p> Created by sun001</p>
 *  </body>
 * </html>
 */
package cn.ucaner.framework.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Project: easy_health 
 * @Package: com.sunshine.framework.mvc.exception
 * @ClassName: GlobalExceptionHanlder
 * @Description: <p>全局的handler异常处理器。前后端系统合一，SimpleMappingExceptionResolver不能满足需求，需自定义异常处理器</p>
 * @JDK version used: 
 * @Author: 甘松
 * @Create Date: 2017-6-17
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
@Component
public class GlobalExceptionHanlder implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHanlder.class);

	public GlobalExceptionHanlder() {
		logger.info("启用全局异常处理器.........");
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (handler != null && handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			ResponseBody b = handlerMethod.getMethodAnnotation(ResponseBody.class);
			logger.error("全局异常处理器捕获异常", ex);
			if (b == null){
				// 后台管理系统页面
				if (handlerMethod.getBean().getClass().getName().startsWith("com.sunshine.platform.")) {
					return new ModelAndView("/platform/error/500");
				} else {// 前端系统页面
					return new ModelAndView("/error/500");
				}
			}
			// else ajax请求，由前端js 框架完成错误提示
		}
		// 阻止 spring mvc 继续寻找视图
		return new ModelAndView();
	}


}
