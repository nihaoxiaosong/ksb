package com.hx.dao.system.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hx.dao.base.BaseDao;
import com.hx.dao.system.UserDao;
import com.hx.model.system.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public User findByCode(String code) {
		Query query = new Query();
		query.addCriteria(new Criteria("code").is(code));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

}
