/**
 * <html>
 * <body>
 *  <P> Copyright 2014 JasonInternational Ucanx</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 20170828</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
*   
* @Package：cn.ucaner.base   
* @ClassName：ComomController   
* @Description：   <p> ---通用跳转控制器 ---</p>
* @Author： - DaoDou 
* @CreatTime：2017年8月28日 下午5:12:31   
* @Modify By：   no i dont thinks so what aboutl you are you 
* @ModifyTime：  this is a time what you can be is a good things do you think so 
* @Modify marker：   do change any  things else you can approval you can do good    
* @version    V1.0
 */
@Controller
@RequestMapping("/common")
public class ComomController {
	
	@RequestMapping(value="/index", method = {RequestMethod.GET})
	public ModelAndView index(ModelMap model) {
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
}
