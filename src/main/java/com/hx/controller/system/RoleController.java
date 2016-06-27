package com.hx.controller.system;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hx.controller.base.BaseController;
import com.hx.model.common.PageParam;
import com.hx.model.system.Role;
import com.hx.service.system.RoleService;
import com.hx.util.PageUtils;
import com.hx.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page, @RequestParam(value="keyWord",required=false)String keyWord){
		if(StringUtils.isEmpty(page)){
			page = "1";
		}
		PageParam pageParam = new PageParam(Integer.parseInt(page), PAGE_ZISE);
		List<Role> roleList = roleService.findByKeyWord(keyWord, pageParam);
		int totalCount = roleService.count(keyWord);
		String pageCode=PageUtils.getPagation(request.getContextPath()+"/role/list", totalCount, Integer.parseInt(page), PAGE_ZISE);
//		LOG.info("/role/list");
		ModelAndView mav = new ModelAndView();
		mav.addObject("roleList",roleList);
		mav.addObject("keyWord", keyWord);
		mav.addObject("pageCode", pageCode);
		mav.setViewName("/system/role");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/changeStatus")
	public void changeStatus(@RequestParam(value="roleId",required=true)String roleId, @RequestParam(value="enable",required=true)String enable) throws Exception{
		int status = Integer.parseInt(enable);
		roleService.checgeStatus(roleId, status);
//		LOG.info("/role/changeStatus");
		JSONObject result=new JSONObject();
		result.put("success", true);			
		ResponseUtil.write(result, response);
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public void add(@RequestParam(value="code",required=true)String code, @RequestParam(value="name",required=true)String name) throws Exception{
		Role role = new Role();
		role.setId(UUID.randomUUID().toString());
		role.setCode(code);
		role.setName(name);
		role.setEnable(0);
		role.setCreateTime(Calendar.getInstance().getTime());
		roleService.insert(role);
//		LOG.info("/role/add");
		JSONObject result=new JSONObject();
		result.put("success", true);			
		ResponseUtil.write(result, response);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="roleId",required=true)String roleId) throws Exception{
		roleService.deleteById(roleId);
//		LOG.info("/role/add");
		JSONObject result=new JSONObject();
		result.put("success", true);			
		ResponseUtil.write(result, response);
	}
	
}
