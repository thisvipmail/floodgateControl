package com.thtf.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Resource(name = "sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Serializable save(T baseEntity) {
		return this.getSessionFactory().getCurrentSession().save(baseEntity);
	}

	@Override
	public void delete(T baseEntity) {
		this.getSessionFactory().getCurrentSession().delete(baseEntity);
	}

	@Override
	public void update(T baseEntity) {
		this.getSessionFactory().getCurrentSession().update(baseEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClass, String id) {
		return (T) this.getSessionFactory().getCurrentSession().get(entityClass, id);
	}

	@Override
	public void saveOrUpdate(T baseEntity) {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(baseEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String entityName, String id) {
		return ((T) this.getSessionFactory().getCurrentSession().get(entityName, id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int executeUpdate(String hql,List params,int type){
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = null;
		if(type ==0 ){//hql
			query = session.createQuery(hql);
		}else{//sql
			query = session.createSQLQuery(hql);
		}
		
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		return query.executeUpdate();
	}
	
	@Override
	public int executeUpdate(String hql,Map<String, Object> params,int type){
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = null;
		if(type ==0 ){//hql
			query = session.createQuery(hql);
		}else{//sql
			query = session.createSQLQuery(hql);
		}
		
		if (params != null) {
			Set<Entry<String, Object>> paramSet = params.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				if (entry.getValue() instanceof List) {
					query.setParameterList(entry.getKey(), (List) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		return query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> excuteHql(final int start, final int limit, final String queryString, final List params) {
		List<T> list = null;
		final Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		
		if (start != -1) {
			query.setFirstResult(start);
		}
		if (limit != -1) {
			query.setFetchSize(limit);
		}
		
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		list = query.list();
		return list;
	}
	
	@Override
	public int excuteHqlCount(final String queryString, final List params) {
		final Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		Long size = (Long) query.uniqueResult();
		return size != null ? size.intValue() : 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> excuteHql(final String queryString,final Map<String, Object> params, int start, int size) {
		List<T> list = null;
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);

		if (params != null) {
			Set<Entry<String, Object>> paramSet = params.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				if (entry.getValue() instanceof List) {
					query.setParameterList(entry.getKey(), (List) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		if (start != -1) {
			query.setFirstResult(start);
		}
		if (size != -1) {
			query.setFetchSize(size);
		}
		list = query.list();
		return list;
	}
	
	@Override
	public int excuteHqlCount(String queryString, Map<String, Object> params) {
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		if (params != null) {
			Set<Entry<String, Object>> paramSet = params.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				if (entry.getValue() instanceof List) {
					query.setParameterList(entry.getKey(), (List) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		Long size = (Long) query.uniqueResult();
		return size.intValue();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> excuteSql(final String queryString, final Class<T> class_, final Map<String, Type> scalarMap,
			final Map<String, Object> params, int start, int size) {
		List<T> list = null;
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		Set<Entry<String, Type>> set = scalarMap.entrySet();
		for (Entry<String, Type> entry : set) {
			query.addScalar(entry.getKey(), entry.getValue());
		}
		query.setResultTransformer(Transformers.aliasToBean(class_));
		if (params != null) {
			Set<Entry<String, Object>> paramSet = params.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				if (entry.getValue() instanceof List) {
					query.setParameterList(entry.getKey(), (List) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		if (start != -1) {
			query.setFirstResult(start);
		}
		if (size != -1) {
			query.setFetchSize(size);
		}
		list = query.list();
		return list;
	}

	@Override
	public int excuteSqlCount(final String queryString, final Map<String, Object> params) {
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		if (params != null) {
			Set<Entry<String, Object>> paramSet = params.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				if (entry.getValue() instanceof List) {
					query.setParameterList(entry.getKey(), (List) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		return (Integer) query.uniqueResult();
	}

}
