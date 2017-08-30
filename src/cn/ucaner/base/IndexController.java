package cn.ucaner.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
