package com.thtf.yhdd.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thtf.base.controller.BaseController;
import com.thtf.base.service.BaseService;
import com.thtf.yhdd.entity.YhddEntity;
import com.thtf.yhdd.service.YhddService;

@Controller
@RequestMapping("/directController")
public class YhddController extends BaseController<YhddEntity>{

	@Resource(name="directService")
	private YhddService<YhddEntity> yhddService;
	
	@Override
	public BaseService<YhddEntity> getBaseService() {
		return yhddService;
	}

}
