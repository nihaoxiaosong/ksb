package com.hx.controller.system;

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
import com.hx.model.system.Module;
import com.hx.service.system.ModuleService;
import com.hx.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ModuleController.class);
	@Autowired
	private ModuleService moduleService;

	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page, @RequestParam(value="keyWord",required=false)String keyWord){
		if(StringUtils.isEmpty(page)){
			page = "1";
		}
		List<Module> moduleList = moduleService.findAll();
//		LOG.info("/module/list");
		ModelAndView mav = new ModelAndView();
		mav.addObject("moduleList",moduleList);
		mav.setViewName("/system/module");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public void add(@RequestParam(value="parentCode",required=false)String parentCode, 
							@RequestParam(value="code",required=false)String code,
							@RequestParam(value="name",required=false)String name, 
							@RequestParam(value="url",required=false)String url,
							@RequestParam(value="seq",required=false)String seq) throws Exception{
		Module module = new Module();
		module.setId(UUID.randomUUID().toString());
		module.setCode(code);
		module.setName(name);
		module.setUrl(url);
		module.setParentCode(parentCode);
		module.setSeq(Integer.parseInt(seq));
		moduleService.insert(module);
//		LOG.info("/module/add");
		JSONObject result=new JSONObject();
		result.put("success", true);			
		ResponseUtil.write(result, response);
	}
	
}
