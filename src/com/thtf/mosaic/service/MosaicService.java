package com.thtf.mosaic.service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import com.thtf.base.service.BaseService;

public interface MosaicService<T> extends BaseService<T>{

	public void sendDriect(Map<String,Double> map)  throws RemoteException;

	public void updateDriect(Map<String,Double> map)  throws RemoteException;
	
	public List<T> queryByIds(List<String> params);
}
