package com.hx.service.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.dao.system.ModuleDao;
import com.hx.model.system.Module;
import com.hx.service.system.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Resource
	private ModuleDao moduleDao;

	@Override
	public List<Module> findAll() {
		List<Module> moduleList = new ArrayList<Module>(); 
		List<Module> parentModule = moduleDao.findByParentCode("root");
		for (Module module : parentModule) {
			moduleList.add(module);
			List<Module> childModule = moduleDao.findByParentCode(module.getCode());
			moduleList.addAll(childModule);
		}
		return moduleList;
	}

	@Override
	public void deleteById(String id) {
		moduleDao.deleteById(id);
	}

	@Override
	public void insert(Module module) {
		moduleDao.insert(module);
	}

	@Override
	public List<Map<String, List<Module>>> findAllWithMap() {
		List<Module> parentModule = moduleDao.findByParentCode("root");
		List<Map<String, List<Module>>> list = new ArrayList<Map<String, List<Module>>>();
		for (Module root: parentModule) {
			Map<String, List<Module>> map = new HashMap<String, List<Module>>();
			List<Module> childModule = moduleDao.findByParentCode(root.getCode());
			map.put(root.getName(), childModule);
			list.add(map);
		}
		return list;
	}

}
