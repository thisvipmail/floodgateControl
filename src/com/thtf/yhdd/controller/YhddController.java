package com.thtf.yhdd.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.base.controller.BaseController;
import com.thtf.base.service.BaseService;
import com.thtf.yhdd.entity.YhddEntity;
import com.thtf.yhdd.service.YhddService;

@Controller
@RequestMapping("/yhddController")
public class YhddController extends BaseController<YhddEntity>{

	@Resource(name="yhddService")
	private YhddService<YhddEntity> yhddService;
	
	@Override
	public BaseService<YhddEntity> getBaseService() {
		return yhddService;
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public List<YhddEntity> query(@RequestParam(value = "page", required = true)int page,@RequestParam(value = "limit", required = true)int limit,
			@RequestParam(value = "nodeId", required = false)String nodeId){
		return yhddService.query(page,limit,nodeId);
	}
	
	@RequestMapping(value = "/count")
	@ResponseBody
	public int count(){
		return yhddService.count();
	}
	
	@RequestMapping(value = "/queryByCon")
	@ResponseBody
	public List<YhddEntity> queryByCon(@RequestParam(value = "pumps[]", required = true)String[] pumps,@RequestParam(value = "flow", required = true)int flow){
		return yhddService.queryByCon(Arrays.asList(pumps),flow);
	}
}
