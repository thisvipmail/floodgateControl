package com.thtf.gcaq.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.gcaq.dao.GcaqDao;
import com.thtf.gcaq.entity.OriginalDataBase;
import com.thtf.gcaq.entity.Osmometer;

@Service(value="osService")
public class OsmometerServiceImpl<T> extends GcaqServiceImpl<T>{


	@Override
	public List<T> query(Map<String,Object> params) {
		
		String queryString = "select apparatusname,surveytime,frequency,temperature,value from(select ROW_NUMBER()over(partition by app.APPARATUSID order by os.SURVEYTIME desc), "
				+ "app.APPARATUSNAME,os.SURVEYTIME,os.FREQUENCY,os.TEMPERATURE,os.VALUE "
				+ "from AO_XXJC_B_OSMOMETER os ,AO_XXJC_B_APPARATUSINFO app,AO_XXJC_B_SURVEYPOINT sp "
				+ "where os.APPARATUSCODE = app.APPARATUSCODE and app.SURVEYPOINTID = sp.SURVEYPOINTID "
				+ "and sp.FGPSTATIONID = :fgps)where rownum = 1";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("apparatusname", StringType.INSTANCE);
		scalarMap.put("surveytime", DateType.INSTANCE);
		scalarMap.put("frequency", FloatType.INSTANCE);
		scalarMap.put("temperature", FloatType.INSTANCE);
		scalarMap.put("value", FloatType.INSTANCE);
		
		return this.getBaseDao().excuteSql(queryString, (Class<T>) Osmometer.class, scalarMap, params, -1, -1);
	}

}
