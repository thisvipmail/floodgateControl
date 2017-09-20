package com.thtf.simulation.dao;

import org.springframework.stereotype.Repository;

import com.thtf.base.dao.BaseDaoImpl;

@Repository(value = "smltDao")
public class SmltDaoImpl<T> extends BaseDaoImpl<T> implements SmltDao<T>{

}
