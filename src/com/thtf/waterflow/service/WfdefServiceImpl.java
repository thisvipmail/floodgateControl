package com.thtf.waterflow.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.waterflow.dao.WfdefDao;

@Service(value="wfdefService")
public class WfdefServiceImpl<T> extends BaseServiceImpl<T> implements WfdefService<T>{

	@Resource(name="wfdefDao")
	private WfdefDao<T> wfdefDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return wfdefDao;
	}


	@Override
	@Transactional
	public List<T> query(int page, int limit, Map<String,String> con) {
		List<String> list = new ArrayList<String>();
		StringBuilder queryString = new StringBuilder("from WfdefEntity where 1= 1 ");
		
		Set<Entry<String, String>> set = con.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			queryString.append(" and " + key + " = ? ");
			list.add(value);
		}
		
		return super.excuteHql(page * limit, limit, queryString.toString(), list);
	}

	@Override
	@Transactional
	public int count(Map<String,String> con) {
		
		List<String> list = new ArrayList<String>();
		StringBuilder queryString = new StringBuilder("select count(*) from WfdefEntity where 1= 1 ");
		
		Set<Entry<String, String>> set = con.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			queryString.append(" and " + key + " = ? ");
			list.add(value);
		}
		
		return super.excuteHqlCount(queryString.toString(), list);
	}


	@Override
	@Transactional
	public int updateByField(String id, String field, Object value) {
		String hql = "update WfdefEntity set " + field + " = ? where id = ? ";
		List list = new ArrayList();
		
		list.add(value);
		list.add(id);
		return super.executeUpdate(hql, list, 0);
	}
}
