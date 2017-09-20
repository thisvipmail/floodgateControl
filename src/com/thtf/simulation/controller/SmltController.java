package com.thtf.simulation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.simulation.entity.RealDataEntity;
import com.thtf.simulation.entity.SmltEntity;
import com.thtf.simulation.service.SmltService;

@Controller
@RequestMapping("/smltController")
public class SmltController {

	@Resource(name="smltService")
	private SmltService<RealDataEntity> RealDataService;
	
	@Resource(name="smltService")
	private SmltService<SmltEntity> smltService;
	
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/querySmlt")
	@ResponseBody
	public List<SmltEntity> querySmlt(String fgps){
		return smltService.querySmlt(fgps);
		
	}

	
	@RequestMapping(value = "/queryHistoryData")
	@ResponseBody
	public List<RealDataEntity> queryHistoryData(String fgps){
		return RealDataService.queryHistoryData(fgps);
		
	}
	
	@RequestMapping(value = "/queryRealData")
	@ResponseBody
	public List<RealDataEntity> queryRealData(String fgps){
		return RealDataService.queryRealData(fgps);
		
	}
}
