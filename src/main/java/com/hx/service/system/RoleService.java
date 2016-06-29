package com.hx.service.system;

import java.util.List;

import com.hx.model.common.PageParam;
import com.hx.model.system.Role;

public interface RoleService {
	/**
	 * 新增
	 * 
	 * @param role
	 */
	void insert(Role role);

	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @param pageParam
	 * @return
	 */
	List<Role> findByKeyWord(String keyWord, PageParam pageParam);
	
	/**
	 * 计数
	 * @param keyWord
	 * @return
	 */
	int count(String keyWord);
	
	/**
	 * 启用禁用角色
	 * @param roleId
	 * @param enable 0禁用,1启用
	 */
	void checgeStatus(String roleId, int enable);
	/**
	 * 根据id删除角色信息
	 * @param roleId
	 */
	void deleteById(String roleId);
	/**
	 * 根据 id 查询
	 * @param id
	 * @return
	 */
	Role findById(String id);
	/**
	 * 根据角色id去更新该角色绑定的模块
	 * @param roleId
	 * @param moduleIds
	 */
	void update(String roleId, List<String> moduleIds);

}
