package com.thtf.yhdd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<YhddEntity> query(){
		return yhddService.query();
	}
}
