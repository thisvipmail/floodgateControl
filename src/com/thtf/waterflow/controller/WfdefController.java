package com.thtf.waterflow.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.base.controller.BaseController;
import com.thtf.base.entity.RetVO;
import com.thtf.base.entity.StatusCode;
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
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public RetVO<WfdefEntity> query(@RequestParam Map<String,String> map){
		Map<String,String> params = new HashMap<String,String>();
		int page = 0,limit = 0;
		Set<Entry<String, String>> set = map.entrySet();  
        Iterator<Entry<String, String>> it = set.iterator(); 
        while (it.hasNext()) {  
            Entry<String, String> entry = it.next();  
            String key = entry.getKey();
            String value = entry.getValue();
            //处理过滤参数
            switch (key) {
			case "_":
				//过滤掉
				break;
			case "limit":
				limit = Integer.parseInt(value);
				break;
			case "page":
				page = Integer.parseInt(value);
				break;
			default:
				if(value != null && !"".equals(value) && !"请选择".equals(value)){
					params.put(key, value);
				}
				break;
			}
        }  
		
		List<WfdefEntity> list = wfdefService.query(page, limit, params);
		int total = wfdefService.count(params);
		
		RetVO<WfdefEntity> retVo = new RetVO<WfdefEntity>();
		retVo.setRows(list);
		retVo.setTotal(total);
		
		return retVo;
		
	}
	
	@RequestMapping(value = "/updateByField")
	@ResponseBody
	public int updateByField(@RequestParam(value = "id", required = true)String id,@RequestParam(value = "field", required = true)String field,
			@RequestParam(value = "value", required = true)String value,@RequestParam(value = "dataType", required = true)String dataType){
		Object objValue = value;
		if("float".equals(dataType)){
			objValue = Float.parseFloat(value);
		}
		return wfdefService.updateByField(id,field,objValue);
	}

}
