package com.thtf.webdriver.dao;

import org.springframework.stereotype.Repository;

import com.thtf.base.dao.BaseDaoImpl;

@Repository(value = "webDriverDao")
public class WebDriverDaoImpl<T> extends BaseDaoImpl<T> implements WebDriverDao<T>{

	
}
