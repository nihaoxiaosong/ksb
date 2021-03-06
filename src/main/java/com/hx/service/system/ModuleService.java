package com.hx.service.system;

import java.util.List;
import java.util.Map;

import com.hx.model.system.Module;

public interface ModuleService {
	/**
	 * 查询所有
	 * @return
	 */
	List<Module> findAll();
	/**
	 * 根据 id 删除
	 * @param id
	 */
	void deleteById(String id);
	/**
	 * 新增模块
	 * @param module
	 */
	void insert(Module module);
	/**
	 * 查询所有,返回的是 map
	 * @return
	 */
	 List<Map<String,List<Module>>> findAllWithMap();
}
