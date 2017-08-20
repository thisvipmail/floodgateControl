package com.thtf.waterflow.service;

import java.util.List;
import java.util.Map;

import com.thtf.base.service.BaseService;

public interface WfdefService<T> extends BaseService<T>{

	public List<T> query(int page, int limit, Map<String,String> con);

	public int count(Map<String, String> con);

	public int updateByField(String id, String field, Object value);

}
