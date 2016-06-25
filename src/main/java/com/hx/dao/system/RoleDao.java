package com.hx.dao.system;

import java.util.List;

import com.hx.model.common.PageParam;
import com.hx.model.system.Role;

public interface RoleDao {
	/**
	 * 新增
	 * @param role
	 */
	void insert(Role role);
	/**
	 * 根据关键字查询
	 * @param keyWord
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
	 * 更新角色信息
	 * @param role
	 */
	void update(Role role);
}
