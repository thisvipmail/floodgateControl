package com.thtf.direct.dao;

import org.springframework.stereotype.Repository;

import com.thtf.base.dao.BaseDaoImpl;

@Repository(value = "directDao")
public class DirectDaoImpl<T> extends BaseDaoImpl<T> implements DirectDao<T>{

	
}