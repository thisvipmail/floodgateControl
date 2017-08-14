package com.thtf.wtlv.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.direct.entity.DirectEntity;
import com.thtf.wtlv.service.WtlvService;

@Controller
@RequestMapping("/wtlvController")
public class WtlvController{

	@Resource(name="wtlvService")
	private WtlvService wtlvService;
	
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public List<DirectEntity> query(@RequestParam(value = "params", required = true)Map<String,String> params){
		return null;
	}

}
