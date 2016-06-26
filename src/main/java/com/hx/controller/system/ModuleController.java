package com.hx.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hx.controller.base.BaseController;
import com.hx.model.system.Module;
import com.hx.service.system.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController {
	@Autowired
	private ModuleService moduleService;

	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page, @RequestParam(value="keyWord",required=false)String keyWord){
		if(StringUtils.isEmpty(page)){
			page = "1";
		}
		List<Module> moduleList = moduleService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("moduleList",moduleList);
		mav.setViewName("/system/module");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam(value="parentCode",required=false)String parentCode, 
							@RequestParam(value="code",required=false)String code,
							@RequestParam(value="name",required=false)String name, 
							@RequestParam(value="url",required=false)String url,
							@RequestParam(value="seq",required=false)String seq){
		System.err.println(parentCode+code+name+url+seq);
		List<Module> moduleList = moduleService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("moduleList",moduleList);
		mav.setViewName("/system/module");
		return mav;
	}
	
}
