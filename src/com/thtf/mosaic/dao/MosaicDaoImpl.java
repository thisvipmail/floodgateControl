package com.thtf.mosaic.dao;

import org.springframework.stereotype.Repository;

import com.thtf.base.dao.BaseDaoImpl;

@Repository(value = "mosaicDao")
public class MosaicDaoImpl<T> extends BaseDaoImpl<T> implements MosaicDao<T>{

	
}
