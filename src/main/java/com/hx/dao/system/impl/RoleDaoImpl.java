package com.hx.dao.system.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hx.dao.base.BaseDao;
import com.hx.dao.system.RoleDao;
import com.hx.model.common.PageParam;
import com.hx.model.system.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao implements RoleDao {
	
	@Override
	public void insert(Role role) {
		mongoTemplate.save(role);
	}

	@Override
	public List<Role> findByKeyWord(String keyWord, PageParam pageParam) {
		Query query = new Query();
		if(!StringUtils.isEmpty(keyWord)){
			query.addCriteria(new Criteria("name").regex(keyWord));
		}
		query.with(new Sort(new Order(Direction.DESC, "createTime")));
		query.skip(pageParam.getStartIndex()).limit(pageParam.getPageSize());
		List<Role> list = mongoTemplate.find(query, Role.class);
		return list;
	}

	@Override
	public int count(String keyWord) {
		Query query = new Query();
		if(!StringUtils.isEmpty(keyWord)){
			query.addCriteria(new Criteria("name").regex(keyWord));
		}
		int count = (int) mongoTemplate.count(query, Role.class);
		return count;
	}

	@Override
	public void update(Role role) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(role.getId()));
		
		Update update = new Update();
		if(!StringUtils.isEmpty(role.getCode())){
			update.set("code", role.getCode());
		}
		if(!StringUtils.isEmpty(role.getName())){
			update.set("name", role.getName());
		}
		if(role.getEnable()>=0){
			update.set("enable", role.getEnable());
		}
		mongoTemplate.updateFirst(query, update, Role.class);
	}

	@Override
	public void deleteById(String roleId) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(roleId));
		mongoTemplate.remove(query, Role.class);
	}

	@Override
	public Role findById(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(id));
		return mongoTemplate.findOne(query, Role.class);
	}

}
