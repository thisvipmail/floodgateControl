package com.thtf.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thtf.base.service.BaseService;

public abstract class BaseController<T> {

	public abstract BaseService<T> getBaseService();
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response,@RequestBody T baseEntity) throws IOException{
		this.getBaseService().save(baseEntity);
		response.setContentType("text/html;charset=utf-8");
	    response.getWriter().write("success");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody T baseEntity){
		this.getBaseService().update(baseEntity);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody T baseEntity) {
		this.getBaseService().delete(baseEntity);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public T get(String entityName,String id){
		return this.getBaseService().get(entityName, id);
	}
}
