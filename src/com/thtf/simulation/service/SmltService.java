package com.thtf.simulation.service;

import java.util.List;

import com.thtf.base.service.BaseService;

public interface SmltService<T> extends BaseService<T>{

	public List<T> queryHistoryData(String fgps);
	
	public List<T> querySmlt(String fgps);

	public List<T> queryRealData(String fgps);

}
