package com.thtf.gcaq.service;

import java.util.List;
import java.util.Map;

import com.thtf.base.service.BaseService;

public interface GcaqService<T> extends BaseService<T>{

	public List<T> query(Map<String, Object> params);

}
