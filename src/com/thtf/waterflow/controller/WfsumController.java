package com.thtf.waterflow.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.base.controller.BaseController;
import com.thtf.base.service.BaseService;
import com.thtf.waterflow.entity.WfsumEntity;
import com.thtf.waterflow.service.WfsumService;

@Controller
@RequestMapping("/wfsumController")
public class WfsumController extends BaseController<WfsumEntity>{

	@Resource(name="wfsumService")
	private WfsumService<WfsumEntity> wfsumService;
	
	@Override
	public BaseService<WfsumEntity> getBaseService() {
		return wfsumService;
	}
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/queryYear")
	@ResponseBody
	public List<WfsumEntity> queryYear(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		return wfsumService.queryYear(map,WfsumEntity.class, -1, -1);
	}
	
	@RequestMapping(value = "/queryMonth")
	@ResponseBody
	public List<WfsumEntity> queryMonth(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		return wfsumService.queryMonth(map,WfsumEntity.class, -1, -1);
	}
	
	@RequestMapping(value = "/queryTen")
	@ResponseBody
	public List<WfsumEntity> queryTen(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		return wfsumService.queryTen(map,WfsumEntity.class, -1, -1);
	}
	
	@RequestMapping(value = "/queryDay")
	@ResponseBody
	public List<WfsumEntity> queryDay(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		return wfsumService.queryDay(map,WfsumEntity.class, -1, -1);
	}

}
