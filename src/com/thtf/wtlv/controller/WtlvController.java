package com.thtf.wtlv.controller;

import java.util.ArrayList;
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
import com.thtf.wtlv.entity.WtlvDtlVo;
import com.thtf.wtlv.entity.WtlvEntity;
import com.thtf.wtlv.entity.WtlvRecord;
import com.thtf.wtlv.entity.WtlvVo;
import com.thtf.wtlv.service.WtlvService;

@Controller
@RequestMapping("/wtlvController")
public class WtlvController extends BaseController<WtlvEntity>{

	@Resource(name="wtlvService")
	private WtlvService<WtlvEntity> wtlvService;
	
	@Resource(name="wtlvService")
	private WtlvService<WtlvRecord> wtrdService;
	
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public List<WtlvVo> query(){
		List<WtlvVo> wtlvList = new ArrayList<WtlvVo>();
		List<WtlvEntity> list = wtlvService.query(WtlvEntity.class);
		Map<String,WtlvVo> map = new HashMap<String,WtlvVo>();
		for (WtlvEntity wtlvEntity : list) {
			WtlvDtlVo dtlvo = wtlvEntity;
			if(map.get(wtlvEntity.getStan())==null){
				map.put(wtlvEntity.getStan(), new WtlvVo());
			};
			WtlvVo vo = map.get(wtlvEntity.getStan());
			vo.setLevel(wtlvEntity.getWaterlevel());
			vo.setName(wtlvEntity.getStan());
			vo.setTime(wtlvEntity.getSamplingtime());
			vo.getItemData().add(dtlvo);
		}
		Iterator<WtlvVo> it = map.values().iterator();
		while(it.hasNext()){
			wtlvList.add(it.next());
		}
		return wtlvList;
	}
	
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public List<WtlvRecord> queryList(@RequestParam(value = "name", required = true)String name){
		List<WtlvRecord> list = wtrdService.queryList(name, WtlvRecord.class);
		return list;
	}

	@Override
	public BaseService<WtlvEntity> getBaseService() {
		return wtlvService;
	}

}
