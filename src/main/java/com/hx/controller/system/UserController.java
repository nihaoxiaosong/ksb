package com.hx.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hx.controller.base.BaseController;
import com.hx.model.system.User;
import com.hx.service.system.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="code",required=false)String code){
		User user = userService.findByCode(code);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",user);
		mav.setViewName("/system/user");
		return mav;
	}
}
