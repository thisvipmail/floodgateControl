package com.thtf.direct.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDaoImpl;

@Repository(value = "directDao")
@Transactional
public class DirectDaoImpl<T> extends BaseDaoImpl<T> implements DirectDao<T>{

	
}
