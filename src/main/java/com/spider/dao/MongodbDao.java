package com.spider.dao;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.spider.bean.MongoBaseEntity;

@Service
public class MongodbDao<PK extends MongoBaseEntity> {

	@Autowired
	private MongoTemplate mongoTemplate;

	public PK findOne(Query query, Class<PK> pk) {
		return this.mongoTemplate.findOne(query, pk, pk.getName());
	}

	public List<PK> findList(Query query, Class<PK> pk) {
		return (List<PK>) this.mongoTemplate.find(query, pk, pk.getName());
	}
	
	public Long count(Query query, Class<PK> pk) {
		return this.mongoTemplate.count(query, pk, pk.getName());
	}
	
	public GroupByResults<PK> group(GroupBy groupBy, Class<PK> pk) {
		return this.mongoTemplate.group(pk.getName(), groupBy, pk);
	}
	
	public GroupByResults<PK> group(Criteria criteria, GroupBy groupBy, Class<PK> pk) {
		return this.mongoTemplate.group(criteria, pk.getName(), groupBy, pk);
	}
	
	public void insert(PK pk) {
		this.mongoTemplate.insert(pk, pk.getClass().getName());
	}

	public void save(PK pk) {
		try {
			String collectionName = pk.getClass().getName();
			Update update = new Update();
			BeanInfo beanInfo = Introspector.getBeanInfo(pk.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(pk, new Object[0]);
					if (result != null) {
						update.set(propertyName, result);
					}
				}
			}
			if (pk.getId() != null) {
				Query query = new Query();
				query.addCriteria(new Criteria("_id").is(pk.getId()));
				this.mongoTemplate.updateFirst(query, update, collectionName);
			} else {
				this.mongoTemplate.save(pk, collectionName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	};

}
