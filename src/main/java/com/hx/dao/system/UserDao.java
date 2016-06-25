package com.hx.dao.system;

import com.hx.model.system.User;

public interface UserDao {
	User findByCode(String code);
}
