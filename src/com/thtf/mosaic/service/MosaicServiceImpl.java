package com.thtf.mosaic.service;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.mosaic.util.MosaicDriverFactory;

@Service(value="mosaicService")
public class MosaicServiceImpl<T> extends BaseServiceImpl<T> implements MosaicService<T>{

	private MosaicDriverFactory mosaicDriverFactory;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return null;
	}
	
	@PostConstruct 
	public void init(){
		mosaicDriverFactory = new MosaicDriverFactory();
	}

	@Override
	public void sendDriect(Map<String,String> map) throws RemoteException {
		mosaicDriverFactory.connectOpen("scada");
		Iterator<Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			mosaicDriverFactory.sendControl(entry.getKey(), Double.parseDouble(entry.getValue()));
		}
		mosaicDriverFactory.disconnect();
	}

	@Override
	public void updateDriect(Map<String, String> map) throws RemoteException {
		mosaicDriverFactory.connectOpen("scada");
		Iterator<Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			String sql = "update Ana set (Eng,User) = ("+entry.getValue()+",0x0001:6153:34) where AltId='"+entry.getKey()+"'";
			mosaicDriverFactory.executeSql(sql);
		}
		mosaicDriverFactory.disconnect();
	}


}
