package com.thtf.base.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.base.entity.StatusCode;
import com.thtf.base.service.BaseService;

public abstract class BaseController<T> {

	public abstract BaseService<T> getBaseService();
	
	private Map<String,Serializable> baseMap = new HashMap<String,Serializable>();
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Serializable> save(HttpServletRequest request, HttpServletResponse response,@RequestBody T baseEntity) throws IOException{
		
		Serializable id = this.getBaseService().save(baseEntity);
		baseMap.put("id", id);
		
		return baseMap;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public StatusCode update(@RequestBody T baseEntity){
		this.getBaseService().update(baseEntity);
		return StatusCode.SUCCESS;
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public StatusCode saveOrUpdate(@RequestBody T baseEntity){
		this.getBaseService().saveOrUpdate(baseEntity);
		return StatusCode.SUCCESS;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public StatusCode delete(@RequestBody T baseEntity) {
		this.getBaseService().delete(baseEntity);
		return StatusCode.SUCCESS;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public T get(String entityName,String id){
		return this.getBaseService().get(entityName, id);
	}
}
