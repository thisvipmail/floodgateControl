package com.thtf.waterflow.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.waterflow.dao.WfdefDao;

@Service(value="wfdefService")
public class WfdefServiceImpl<T> extends BaseServiceImpl<T> implements WfdefService<T>{

	@Resource(name="wfdefDao")
	private WfdefDao<T> wfdefDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return wfdefDao;
	}


}
