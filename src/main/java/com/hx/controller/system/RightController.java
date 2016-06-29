package com.hx.controller.system;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hx.controller.base.BaseController;
import com.hx.model.system.Module;
import com.hx.model.system.Role;
import com.hx.service.system.ModuleService;
import com.hx.service.system.RoleService;

@Controller
@RequestMapping("/right")
public class RightController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(RightController.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="roleId",required=false)String roleId){
		List<Map<String, List<Module>>> moduleMapList = moduleService.findAllWithMap();
		Role role = roleService.findById(roleId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("role", role);
		mav.addObject("moduleMapList", moduleMapList);
		mav.setViewName("/system/right");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public void save(@RequestParam(value="roleId",required=false)String roleId,
					@RequestParam(value="moduleIds[]",required=false)List<String> moduleIds){
		
		roleService.update(roleId, moduleIds);
		System.out.println(roleId);
		System.out.println(moduleIds);
	}
}
