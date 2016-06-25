package com.hx.service.system;

import com.hx.model.system.User;

public interface UserService {
	User findByCode(String code);
}
