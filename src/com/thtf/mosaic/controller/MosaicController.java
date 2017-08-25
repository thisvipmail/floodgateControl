package com.thtf.mosaic.controller;

import java.rmi.RemoteException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.base.controller.BaseController;
import com.thtf.base.service.BaseService;
import com.thtf.mosaic.service.MosaicService;

@Controller
@RequestMapping("/mosaicController")
public class MosaicController extends BaseController{

	@Resource(name="mosaicService")
	private MosaicService mosaicService;

	@Override
	public BaseService getBaseService() {
		return mosaicService;
	}
	
	/**
	 * 发送指令
	 * @param attr
	 * @param value
	 */
	@RequestMapping(value = "/sendDriect")
	@ResponseBody
	public void sendDriect(@RequestParam Map<String,String> map){
		
		try {
			mosaicService.sendDriect(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 更新指令
	 * @param attr
	 * @param value
	 */
	@RequestMapping(value = "/updateDriect")
	@ResponseBody
	public void updateDriect(@RequestParam Map<String,String> map){
		
		try {
			mosaicService.updateDriect(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
