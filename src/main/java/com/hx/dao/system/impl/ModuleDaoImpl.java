package com.hx.dao.system.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hx.dao.base.BaseDao;
import com.hx.dao.system.ModuleDao;
import com.hx.model.system.Module;

@Repository("moduleDao")
public class ModuleDaoImpl extends BaseDao implements ModuleDao {

	@Override
	public List<Module> findByParentCode(String parentCode) {
		Query query = new Query();
		query.addCriteria(new Criteria("parentCode").is(parentCode));
		query.with(new Sort(new Order(Direction.ASC, "seq")));
		List<Module> list = mongoTemplate.find(query, Module.class);
		return list;
	}

	@Override
	public void deleteById(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(id));
		mongoTemplate.remove(query, Module.class);
	}

	@Override
	public void insert(Module module) {
		mongoTemplate.insert(module);
	}

}
