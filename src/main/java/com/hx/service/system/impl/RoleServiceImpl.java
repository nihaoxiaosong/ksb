package com.hx.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.dao.system.RoleDao;
import com.hx.model.common.PageParam;
import com.hx.model.system.Role;
import com.hx.service.system.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;

	@Override
	public void insert(Role role) {
		roleDao.insert(role);
	}

	@Override
	public List<Role> findByKeyWord(String keyWord, PageParam pageParam) {
		List<Role> list = roleDao.findByKeyWord(keyWord, pageParam);
		return list;
	}

	@Override
	public int count(String keyWord) {
		int count = roleDao.count(keyWord);
		return count;
	}

	@Override
	public void checgeStatus(String roleId, int enable) {
		Role role = new Role();
		role.setId(roleId);
		role.setEnable(enable);
		roleDao.update(role);
	}

	@Override
	public void deleteById(String roleId) {
		roleDao.deleteById(roleId);
	}

	@Override
	public Role findById(String id) {
		return roleDao.findById(id);
	}

	@Override
	public void update(String roleId, List<String> moduleIds) {
		// TODO Auto-generated method stub
		
	}

}
