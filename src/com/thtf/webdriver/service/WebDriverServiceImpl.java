package com.thtf.webdriver.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.direct.dao.DirectDao;

@Service(value="webDriverService")
public class WebDriverServiceImpl<T> extends BaseServiceImpl<T> implements WebDriverService<T>{

	@Resource(name="directDao")
	private DirectDao<T> directDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return directDao;
	}

}
