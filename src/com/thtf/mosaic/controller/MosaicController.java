package com.thtf.mosaic.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import com.thtf.mosaic.entity.MosaicEntity;
import com.thtf.mosaic.service.MosaicService;

@Controller
@RequestMapping("/mosaicController")
public class MosaicController extends BaseController{

	@Resource(name="mosaicService")
	private MosaicService mosaicService;
	
	@Resource(name="mosaicService")
	private MosaicService<MosaicEntity> mosaicEntityService;
	
	@Resource(name="directService")
	private DirectService<DirectEntity> directService;

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
	public void sendDriect(@RequestParam List<String> param){
		
		//根据list查询指令
		List<DirectEntity> directList = directService.queryByIds(param);
		List<String> fgpsList = new ArrayList<String>();
		for (DirectEntity directEntity : directList) {
			fgpsList.add(directEntity.getConCode());
		}
		
		//根据list查询mosaic对应关系
		List<MosaicEntity> mosaicList = mosaicEntityService.queryByIds(fgpsList);
		
		Map<String,Double> controlMap = new HashMap<String,Double>();
		Map<String,Double> updateMap = new HashMap<String,Double>();
		
		for (int i = 0; i < directList.size(); i++) {
			DirectEntity directEntity = directList.get(i);
			MosaicEntity mosaicEntity = mosaicList.get(i);
			
			String model = directEntity.getConModel();
			float value = directEntity.getConValue();
			float bl = directEntity.getBefLevel();
			float al = directEntity.getAftLevel();
			
			String waterflowAtt;
			if("01".equals(model)){
				waterflowAtt = mosaicEntity.getFlowAttr();
			}else{
				waterflowAtt = mosaicEntity.getWaterAttr();
			}
			controlMap.put(waterflowAtt, (double) value);
			updateMap.put(mosaicEntity.getBefLevel(), (double) bl);
			updateMap.put(mosaicEntity.getAftLevel(), (double) al);
		}
		try {
			mosaicService.sendDriect(controlMap);
			mosaicService.updateDriect(updateMap);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 更新指令
	 * @param attr
	 * @param value
	 */
	@RequestMapping(value = "/stopDriect")
	@ResponseBody
	public void stopDriect(@RequestParam String directId){
		
		//根据指令ID查询指令中的建筑物
		DirectEntity directEntity = directService.get(DirectEntity.class, directId);

		//根据建筑物查询对应ID关系
		MosaicEntity mosaicEntity = mosaicEntityService.get(MosaicEntity.class, directEntity.getConCode());
		String stopAttr = mosaicEntity.getStopAttr();

		List<String> list = Arrays.asList(stopAttr.split(","));
		Map<String,Double> map = new HashMap<String,Double>();
		for (String attr : list) {
			map.put(attr, (double) 0);
		}
		
		try {
			mosaicService.sendDriect(map);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
