package com.thtf.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thtf.base.service.BaseService;

public abstract class BaseController<T> {

	public abstract BaseService<T> getBaseService();
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(T baseEntity){
		this.getBaseService().save(baseEntity);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(T baseEntity){
		this.getBaseService().update(baseEntity);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(T baseEntity) {
		this.getBaseService().delete(baseEntity);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public T get(String entityName,String id){
		return this.getBaseService().get(entityName, id);
	}
}
