package com.thtf.gcaq.controller;

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
import com.thtf.gcaq.entity.DisplaceGage;
import com.thtf.gcaq.entity.GcaqEntity;
import com.thtf.gcaq.entity.Jointmeter;
import com.thtf.gcaq.entity.OriginalDataBase;
import com.thtf.gcaq.entity.Osmometer;
import com.thtf.gcaq.entity.SoilPresses;
import com.thtf.gcaq.service.DisplaceGageServiceImpl;
import com.thtf.gcaq.service.GcaqService;
import com.thtf.gcaq.service.JointmeterServiceImpl;
import com.thtf.gcaq.service.OsmometerServiceImpl;
import com.thtf.gcaq.service.SoilPressServiceImpl;

@Controller
@RequestMapping("/gcaqController")
public class GcaqController extends BaseController<OriginalDataBase>{

	@Resource(name="gcaqService")
	private GcaqService<OriginalDataBase> gcaqService;
	
	@Resource(name="dgService")
	private DisplaceGageServiceImpl<DisplaceGage> dgService;
	
	@Resource(name="osService")
	private OsmometerServiceImpl<Osmometer> osService;
	
	@Resource(name="jmService")
	private JointmeterServiceImpl<Jointmeter> jmService;
	
	@Resource(name="spService")
	private SoilPressServiceImpl<SoilPresses> spService;
	
	@Override
	public BaseService<OriginalDataBase> getBaseService() {
		return gcaqService;
	}
	/**
	 * 根据参数进行查询
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public List<GcaqEntity> query(@RequestParam(value = "params", required = true)Map<String,String> params){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it = params.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = params.get(key);
			map.put(key, value);
		}
		List<DisplaceGage> dgList = dgService.query(map);
		List<Osmometer> osList = osService.query(map);
		List<Jointmeter> jmList = jmService.query(map);
		List<SoilPresses> dpList = spService.query(map);
		
		List<GcaqEntity> list = new ArrayList<GcaqEntity>();
		
		GcaqEntity<DisplaceGage> dg = new GcaqEntity<DisplaceGage>();
		dg.setName("位移计");
		dg.setCode("wyj");
		dg.setList(dgList);
		list.add(dg);
		
		GcaqEntity<Osmometer> os = new GcaqEntity<Osmometer>();
		os.setName("渗压计");
		os.setCode("syj");
		os.setList(osList);
		list.add(os);
		
		GcaqEntity<Jointmeter> jm = new GcaqEntity<Jointmeter>();
		jm.setName("测缝计");
		jm.setCode("cfj");
		jm.setList(jmList);
		list.add(jm);
		
		GcaqEntity<SoilPresses> sp = new GcaqEntity<SoilPresses>();
		sp.setName("渗压计");
		sp.setCode("syj");
		sp.setList(dpList);
		list.add(sp);
		
		return list;
	}

}
