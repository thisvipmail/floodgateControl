package com.thtf.yhdd.service;

import java.util.List;

import com.thtf.base.service.BaseService;

public interface YhddService<T> extends BaseService<T>{

	public List<T> query(int start, int limit, String nodeId);
	
	public int count();

	public List<T> queryByCon(List<String> pumps,int flow);

}
