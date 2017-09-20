package com.thtf.simulation.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.simulation.dao.SmltDao;
import com.thtf.simulation.entity.RealDataEntity;
import com.thtf.simulation.entity.SmltEntity;

@Service(value="smltService")
public class SmltServiceImpl<T> extends BaseServiceImpl<T> implements SmltService<T>{

	@Resource(name="smltDao")
	private SmltDao<T> smltDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return smltDao;
	}

	@Override
	@Transactional
	public List<T> queryHistoryData(String fgps) {
		Calendar calendar = new GregorianCalendar();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		String queryString = "";
		if(hours>=8){
			queryString = "select dbtime,sysw,xysw,flowvalue from AZ_XXJC_ZHLSSJ zhlssj inner join AA_PUB_FP_REF ref on (ref.sn = zhlssj.sn ) "
					+ "where WGNO = :fgps  and dbtime between  to_date(TO_CHAR (current date,'YYYY-MM-DD'),'YYYY-MM-DD')+8 hours and current date";
		}else{
			queryString = "select dbtime,sysw,xysw,flowvalue from AZ_XXJC_ZHLSSJ zhlssj inner join AA_PUB_FP_REF ref on (ref.sn = zhlssj.sn ) "
					+ "where WGNO = :fgps  and dbtime between  to_date(TO_CHAR (current date - 1 days,'YYYY-MM-DD'),'YYYY-MM-DD')+8 hours and current date";
		}
		
		Map<String, Type> scalarMap = new HashMap<String, Type>();
		scalarMap.put("dbtime", StringType.INSTANCE);
		scalarMap.put("sysw", FloatType.INSTANCE);
		scalarMap.put("xysw", FloatType.INSTANCE);
		scalarMap.put("flowvalue", FloatType.INSTANCE);
		
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("fgps", fgps);
		 
		return smltDao.excuteSql(queryString,  (Class<T>) RealDataEntity.class, scalarMap, params, -1, -1);
	}

	@Override
	@Transactional
	public List<T> querySmlt(String fgps) {
		
		String queryString = "select to_date(BEGINTIME,'YYYY-MM-DD HH24:MI:SS') + intMinutes minutes beginTime, dblFrontZ,dblBackZ, dblq from AZ_SLDD_SIMULATION where STRCODE = :fgps order by INTMINUTES asc";
		
		Map<String, Type> scalarMap = new HashMap<String, Type>();
		scalarMap.put("beginTime", StringType.INSTANCE);
		scalarMap.put("dblFrontZ", FloatType.INSTANCE);
		scalarMap.put("dblBackZ", FloatType.INSTANCE);
		scalarMap.put("dblq", FloatType.INSTANCE);
		
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("fgps", fgps);
		 
		return smltDao.excuteSql(queryString,  (Class<T>) SmltEntity.class, scalarMap, params, 1, 100);
	}

	@Override
	@Transactional
	public List<T> queryRealData(String fgps) {
		String queryString = "select dbtime,sysw,xysw,flowvalue from AZ_XXJC_ZHSSSJ zhsssj inner join AA_PUB_FP_REF ref on (ref.sn = SUBSTR(locationid,LOCATE('-',locationid,LOCATE('-',locationid)+1)+1) ) where WGNO = :fgps ";
		Map<String, Type> scalarMap = new HashMap<String, Type>();
		scalarMap.put("dbtime", StringType.INSTANCE);
		scalarMap.put("sysw", FloatType.INSTANCE);
		scalarMap.put("xysw", FloatType.INSTANCE);
		scalarMap.put("flowvalue", FloatType.INSTANCE);
		
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("fgps", fgps);
		 
		return smltDao.excuteSql(queryString,  (Class<T>) RealDataEntity.class, scalarMap, params, -1, -1);
	}
	
}
