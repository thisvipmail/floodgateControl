package com.thtf.direct.service;

import java.util.List;
import java.util.Map;

import com.thtf.base.service.BaseService;

public interface DirectService<T> extends BaseService<T>{

	public List<T> query(Map<String, Object> params,Class<T> cls, int start, int size);
	
	
	public List<T> queryByIds(List<String> params);

}
