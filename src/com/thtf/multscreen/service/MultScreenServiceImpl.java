package com.thtf.multscreen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thtf.multscreen.dao.MultScreenDao;
import com.thtf.multscreen.entity.FloodPumpCam;

@Service(value="multScreenService")
public class MultScreenServiceImpl implements MultScreenService {

	@Resource(name="multScreenDao")
	private MultScreenDao multScreenDao;
	@Override
	public FloodPumpCam getFloodPumpID(String id) {
		return this.multScreenDao.getFloodPumpID(id);
	}
	public MultScreenDao getMultScreenDao() {
		return multScreenDao;
	}
	public void setMultScreenDao(MultScreenDao multScreenDao) {
		this.multScreenDao = multScreenDao;
	}

}
