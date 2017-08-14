package com.thtf.gcaq.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.gcaq.dao.GcaqDao;

@Service(value="gcaqService")
public class GcaqServiceImpl<T> extends BaseServiceImpl<T> implements GcaqService<T>{

	@Resource(name="gcaqDao")
	private GcaqDao<T> gcaqDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return gcaqDao;
	}

	@Override
	public List<T> query(Map<String,Object> params) {
		return null;
	}

}
