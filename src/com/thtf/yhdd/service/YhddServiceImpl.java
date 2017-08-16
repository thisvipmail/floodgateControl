package com.thtf.yhdd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.yhdd.dao.YhddDao;

@Service(value="yhddService")
public class YhddServiceImpl<T> extends BaseServiceImpl<T> implements YhddService<T>{

	@Resource(name="yhddDao")
	private YhddDao<T> yhddDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return yhddDao;
	}

	@Override
	@Transactional
	public List<T> query() {
		return super.excuteHql(-1, -1, "from YhddEntity", null);
	}

}
