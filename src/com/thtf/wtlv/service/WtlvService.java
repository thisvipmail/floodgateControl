package com.thtf.wtlv.service;

import java.util.List;

import com.thtf.base.service.BaseService;

public interface WtlvService<T> extends BaseService<T>{

	public List<T> query(Class<T> t);
}
