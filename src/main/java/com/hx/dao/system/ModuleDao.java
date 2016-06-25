package com.hx.dao.system;

import java.util.List;

import com.hx.model.system.Module;

public interface ModuleDao {
	/**
	 * 根据父编码查询
	 * @param parentCode
	 * @return
	 */
	List<Module> findByParentCode(String parentCode);
	/**
	 * 根据 id 删除
	 * @param id
	 */
	void deleteById(String id);
}
