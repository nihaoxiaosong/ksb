package com.hx.dao.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * jdbcTemplate
 * @author song
 * @date 2016年6月22日下午8:26:25
 */
public class BaseDao {
	@Autowired
	protected MongoTemplate mongoTemplate;

}
