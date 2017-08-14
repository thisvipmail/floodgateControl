package com.thtf.direct.controller;

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
import com.thtf.direct.entity.DirectEntity;
import com.thtf.direct.service.DirectService;

@Controller
@RequestMapping("/directController")
public class DirectController extends BaseController<DirectEntity>{

	@Resource(name="directService")
	private DirectService<DirectEntity> directService;
	
	@Override
	public BaseService<DirectEntity> getBaseService() {
		return directService;
	}
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public List<DirectEntity> query(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		return directService.query(map,DirectEntity.class, -1, -1);
	}

}
