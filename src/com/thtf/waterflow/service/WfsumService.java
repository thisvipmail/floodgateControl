package com.thtf.waterflow.service;

import java.util.List;
import java.util.Map;

import com.thtf.base.service.BaseService;

public interface WfsumService<T> extends BaseService<T>{

	public List<T> queryYear(Map<String, Object> params,Class<T> cls, int start, int size);
	
	public List<T> queryMonth(Map<String, Object> params,Class<T> cls, int start, int size);
	
	public List<T> queryTen(Map<String, Object> params,Class<T> cls, int start, int size);
	
	public List<T> queryDay(Map<String, Object> params,Class<T> cls, int start, int size);

}
