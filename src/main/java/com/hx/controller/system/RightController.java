package com.hx.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hx.controller.base.BaseController;

@Controller
@RequestMapping("/right")
public class RightController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(RightController.class);
	
	@RequestMapping("/list")
	public ModelAndView lsit(@RequestParam(value="roleId",required=false)String roleId){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/system/right");
		return mav;
	}
}
