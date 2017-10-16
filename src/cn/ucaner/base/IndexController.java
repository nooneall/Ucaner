package cn.ucaner.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* @Package：cn.ucaner.base   
* @ClassName：IndexController   
* @Description：   <p> index 首页跳转 </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月16日 上午11:17:11   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(value="/index", method = {RequestMethod.GET})
	public ModelAndView index(ModelMap model) {
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
}
