package com.thtf.base.service;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.thtf.base.dao.BaseDao;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	public void save(T baseEntity) {
		this.getBaseDao().save(baseEntity);
	}

	@Override
	public void delete(T baseEntity) {
		this.getBaseDao().delete(baseEntity);
	}

	@Override
	public void update(T baseEntity) {
		this.getBaseDao().update(baseEntity);
	}

	@Override
	public T get(Class<T> entityClass, String id) {
		return this.getBaseDao().get(entityClass, id);
	}

	@Override
	public T get(String entityName, String id) {
		return this.getBaseDao().get(entityName, id);
	}
	
	@Override
	public void saveOrUpdate(T baseEntity) {
		this.getBaseDao().saveOrUpdate(baseEntity);
	}

	public abstract BaseDao<T> getBaseDao();

	@Override
	public List<T> excuteSql(String queryString, Class<T> class_, Map<String, Type> scalarMap, Map<String, Object> params,
			int start, int size) {
		return getBaseDao().excuteSql(queryString, class_, scalarMap, params, start, size);
	}

	@Override
	public int excuteSqlCount(String queryString, Map<String, Object> params) {
		return getBaseDao().excuteSqlCount(queryString, params);
	}

	@Override
	public List<T> excuteHql(int start, int limit, String queryString, List params) {
		return getBaseDao().excuteHql(start, limit, queryString, params);
	}

	@Override
	public int excuteHqlCount(String queryString, List params) {
		return getBaseDao().excuteHqlCount(queryString, params);
	}
	
	
	
}
