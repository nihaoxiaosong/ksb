package com.hx.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.dao.system.UserDao;
import com.hx.model.system.User;
import com.hx.service.system.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

}
