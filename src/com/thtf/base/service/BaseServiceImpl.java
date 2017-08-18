package com.thtf.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	@Transactional
	public Serializable save(T baseEntity) {
		return this.getBaseDao().save(baseEntity);
	}

	@Override
	@Transactional
	public void delete(T baseEntity) {
		this.getBaseDao().delete(baseEntity);
	}

	@Override
	@Transactional
	public void update(T baseEntity) {
		this.getBaseDao().update(baseEntity);
	}

	@Override
	@Transactional
	public T get(Class<T> entityClass, String id) {
		return this.getBaseDao().get(entityClass, id);
	}

	@Override
	@Transactional
	public T get(String entityName, String id) {
		return this.getBaseDao().get(entityName, id);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(T baseEntity) {
		this.getBaseDao().saveOrUpdate(baseEntity);
	}

	public abstract BaseDao<T> getBaseDao();

	@Override
	@Transactional
	public List<T> excuteSql(String queryString, Class<T> class_, Map<String, Type> scalarMap, Map<String, Object> params,
			int start, int size) {
		return getBaseDao().excuteSql(queryString, class_, scalarMap, params, start, size);
	}

	@Override
	@Transactional
	public int excuteSqlCount(String queryString, Map<String, Object> params) {
		return getBaseDao().excuteSqlCount(queryString, params);
	}

	@Override
	@Transactional
	public List<T> excuteHql(int start, int limit, String queryString, List params) {
		return getBaseDao().excuteHql(start, limit, queryString, params);
	}

	@Override
	@Transactional
	public int excuteHqlCount(String queryString, List params) {
		return getBaseDao().excuteHqlCount(queryString, params);
	}
	
	@Override
	@Transactional
	public List<T> excuteHql(final String queryString,final Map<String, Object> params, int start, int size){
		return getBaseDao().excuteHql(queryString, params,start,size);
	}
	
	@Override
	@Transactional
	public int excuteHqlCount(final String queryString,final Map<String, Object> params){
		return getBaseDao().excuteHqlCount(queryString, params);
	}
	
}
