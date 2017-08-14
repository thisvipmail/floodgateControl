package com.thtf.waterflow.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thtf.base.controller.BaseController;
import com.thtf.base.service.BaseService;
import com.thtf.waterflow.entity.WfdefEntity;
import com.thtf.waterflow.service.WfdefService;

@Controller
@RequestMapping("/wfdefController")
public class WfdefController extends BaseController<WfdefEntity>{

	@Resource(name="wfdefService")
	private WfdefService<WfdefEntity> wfdefService;
	
	@Override
	public BaseService<WfdefEntity> getBaseService() {
		return wfdefService;
	}

}
