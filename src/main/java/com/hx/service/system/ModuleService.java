package com.hx.service.system;

import java.util.List;

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
}
