package com.thtf.mosaic.service;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.mosaic.dao.MosaicDao;
import com.thtf.mosaic.util.MosaicDriverFactory;

@Service(value="mosaicService")
public class MosaicServiceImpl<T> extends BaseServiceImpl<T> implements MosaicService<T>{

	@Resource(name="mosaicDao")
	private MosaicDao<T> mosaicDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return mosaicDao;
	}
	
	@Override
	public void sendDriect(Map<String,Double> map) throws RemoteException {
		MosaicDriverFactory mosaicDriverFactory = new MosaicDriverFactory();
		mosaicDriverFactory.connectOpen("scada");
		Iterator<Entry<String,Double>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Double> entry = it.next();
			mosaicDriverFactory.sendControl(entry.getKey(), entry.getValue());
		}
		mosaicDriverFactory.disconnect();
	}

	@Override
	public void updateDriect(Map<String, Double> map) throws RemoteException {
		MosaicDriverFactory mosaicDriverFactory = new MosaicDriverFactory();
		mosaicDriverFactory.connectOpen("scada");
		Iterator<Entry<String,Double>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Double> entry = it.next();
			String sql = "update Ana set (Eng,User) = ("+entry.getValue()+",0x0001:6153:34) where AltId='"+entry.getKey()+"'";
			mosaicDriverFactory.executeSql(sql);
		}
		mosaicDriverFactory.disconnect();
	}

	@Override
	@Transactional
	public List<T> queryByIds(List<String> fgps) {
		return super.queryByIds("from MosaicEntity where fgps in (:ids)", fgps);
	}

}
