package com.hx.service.system.impl;

import java.util.ArrayList;
import java.util.List;

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
		List<Module> parentModule = moduleDao.findByParentCode("root");
		
		List<Module> moduleList = new ArrayList<Module>(); 
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

}
