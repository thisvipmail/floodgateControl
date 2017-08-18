package com.thtf.yhdd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.yhdd.dao.YhddDao;
import com.thtf.yhdd.entity.YhddEntity;

@Service(value="yhddService")
public class YhddServiceImpl<T> extends BaseServiceImpl<T> implements YhddService<T>{

	@Resource(name="yhddDao")
	private YhddDao<T> yhddDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return yhddDao;
	}

	@Override
	@Transactional
	public List<T> query(int page, int limit, String nodeId) {
		List<String> list = new ArrayList<String>();
		String where = "";
		if(nodeId != null){
			list.add(nodeId);
			where = " where pumpId = ? ";
		}
		
		return super.excuteHql((page-1) * limit, limit, "from YhddEntity" + where, list);
	}

	@Override
	@Transactional
	public int count() {
		return super.excuteHqlCount("select count(*) from YhddEntity", new ArrayList<String>());
	}

	@Override
	@Transactional
	public List<T> queryByCon(List<String> pumps,int flow) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("pumps", pumps);
		params.put("flow", flow);
		
		return super.excuteHql("from YhddEntity where pumpId in (:pumps) and flow = :flow", params, -1, -1);
	}

}
