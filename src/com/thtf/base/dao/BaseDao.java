package com.thtf.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.type.Type;

public interface BaseDao<T> {

	/**
	 * 增加
	 * @param baseEntity
	 */
	public Serializable save(T baseEntity);
	
	/**
	 * 删除
	 * @param baseEntity
	 */
	public void delete(T baseEntity);
	
	/**
	 * 修改
	 * @param baseEntity
	 */
	public void update(T baseEntity);
	
	/**
	 * 查询
	 */
	public T get(Class<T> entityClass,String id);
	
	/**
	 * 查询
	 */
	public T get(String entityName,String id);
	
	/**
	 * 保存或更新
	 * @param baseEntity
	 */
	public void saveOrUpdate(T baseEntity);
	
	
	public Session getCurrentSession();
	
	/**
	 * 原生sql查询
	 * @param queryString
	 * @param params
	 * @param class_
	 * @param map
	 * @return
	 */
	public List<T> excuteSql(final String queryString,final Class<T> class_,final Map<String,Type> scalarMap,final Map<String,Object> params,int start,int size);
	
	/**
	 * 原生sql查询数量
	 * @param queryString
	 * @param params
	 * @return
	 */
	public  int excuteSqlCount(final String queryString,final Map<String,Object> params);
	
	/**
	 * 执行hql语句
	 * @param start
	 * @param limit
	 * @param queryString
	 * @param params
	 * @return
	 */
	public List<T> excuteHql(final int start, final int limit, final String queryString, final List params);
	
	/**
	 * 执行hql语句
	 * @param queryString
	 * @param params
	 * @param start
	 * @param size
	 * @return
	 */
	public List<T> excuteHql(final String queryString,final Map<String, Object> params, int start, int size);
	
	/**
	 * 执行hql语句查询数量
	 * @param queryString
	 * @param params
	 * @return
	 */
	public int excuteHqlCount(final String queryString,final Map<String, Object> params);
	
	/**
	 * 执行hql语句查询数量
	 * @param queryString
	 * @param params
	 * @return
	 */
	public int excuteHqlCount(final String queryString, final List params);

	/**
	 * update
	 * @param hql
	 * @param params
	 * @param type 0:hql,1:sql
	 * @return
	 */
	public int executeUpdate(String hql, List params, int type);

	/**
	 * update
	 * @param hql
	 * @param params
	 * @param type 0:hql,1:sql
	 * @return
	 */
	public int executeUpdate(String hql, Map<String, Object> params, int type);

	/**
	 * 根据ID查询
	 * @param queryStr
	 * @param params
	 * @return
	 */
	public List<T> queryByIds(String queryStr, List<String> params);

}
