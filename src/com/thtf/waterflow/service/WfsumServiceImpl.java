package com.thtf.waterflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.waterflow.dao.WfsumDao;

@Service(value="wfsumService")
public class WfsumServiceImpl<T> extends BaseServiceImpl<T> implements WfsumService<T>{

	@Resource(name="wfsumDao")
	private WfsumDao<T> wfsumDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return wfsumDao;
	}

	@Override
	public List<T> queryYear(Map<String, Object> params,Class<T> cls, int start, int size) {
		String queryString = "";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("instructCode", StringType.INSTANCE);
		scalarMap.put("conCode", StringType.INSTANCE);
		scalarMap.put("conModel", StringType.INSTANCE);
		scalarMap.put("conValue", FloatType.INSTANCE);
		scalarMap.put("brakeDegree", FloatType.INSTANCE);
		scalarMap.put("befLevel", FloatType.INSTANCE);
		scalarMap.put("aftLevel", FloatType.INSTANCE);
		scalarMap.put("staTime", DateType.INSTANCE);
		scalarMap.put("endTime", DateType.INSTANCE);
		scalarMap.put("dbTime", DateType.INSTANCE);
		
		return super.excuteSql(queryString, cls, scalarMap, params, start, size);
	}
	
	@Override
	public List<T> queryMonth(Map<String, Object> params,Class<T> cls, int start, int size) {
		String queryString = "";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("instructCode", StringType.INSTANCE);
		scalarMap.put("conCode", StringType.INSTANCE);
		scalarMap.put("conModel", StringType.INSTANCE);
		scalarMap.put("conValue", FloatType.INSTANCE);
		scalarMap.put("brakeDegree", FloatType.INSTANCE);
		scalarMap.put("befLevel", FloatType.INSTANCE);
		scalarMap.put("aftLevel", FloatType.INSTANCE);
		scalarMap.put("staTime", DateType.INSTANCE);
		scalarMap.put("endTime", DateType.INSTANCE);
		scalarMap.put("dbTime", DateType.INSTANCE);
		
		return super.excuteSql(queryString, cls, scalarMap, params, start, size);
	}

	@Override
	public List<T> queryTen(Map<String, Object> params,Class<T> cls, int start, int size) {
		String queryString = "";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("instructCode", StringType.INSTANCE);
		scalarMap.put("conCode", StringType.INSTANCE);
		scalarMap.put("conModel", StringType.INSTANCE);
		scalarMap.put("conValue", FloatType.INSTANCE);
		scalarMap.put("brakeDegree", FloatType.INSTANCE);
		scalarMap.put("befLevel", FloatType.INSTANCE);
		scalarMap.put("aftLevel", FloatType.INSTANCE);
		scalarMap.put("staTime", DateType.INSTANCE);
		scalarMap.put("endTime", DateType.INSTANCE);
		scalarMap.put("dbTime", DateType.INSTANCE);
		
		return super.excuteSql(queryString, cls, scalarMap, params, start, size);
	}
	
	@Override
	public List<T> queryDay(Map<String, Object> params,Class<T> cls, int start, int size) {
		String queryString = "";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("instructCode", StringType.INSTANCE);
		scalarMap.put("conCode", StringType.INSTANCE);
		scalarMap.put("conModel", StringType.INSTANCE);
		scalarMap.put("conValue", FloatType.INSTANCE);
		scalarMap.put("brakeDegree", FloatType.INSTANCE);
		scalarMap.put("befLevel", FloatType.INSTANCE);
		scalarMap.put("aftLevel", FloatType.INSTANCE);
		scalarMap.put("staTime", DateType.INSTANCE);
		scalarMap.put("endTime", DateType.INSTANCE);
		scalarMap.put("dbTime", DateType.INSTANCE);
		
		return super.excuteSql(queryString, cls, scalarMap, params, start, size);
	}
}
