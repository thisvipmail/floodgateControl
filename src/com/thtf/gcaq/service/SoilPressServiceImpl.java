package com.thtf.gcaq.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.gcaq.entity.SoilPresses;

@Service(value="spService")
public class SoilPressServiceImpl<T> extends GcaqServiceImpl<T>{

	@Override
	@Transactional
	public List<T> query(Map<String,Object> params) {
		
		String queryString = "select apparatusname name,surveytime time,frequency valuex,temperature valuey,value valuez from(select ROW_NUMBER()over(partition by app.APPARATUSID order by os.SURVEYTIME desc), "
				+ "app.APPARATUSNAME,os.SURVEYTIME,os.FREQUENCY,os.TEMPERATURE,os.VALUE "
				+ "from AO_XXJC_B_SOILPRESSES os ,AO_XXJC_B_APPARATUSINFO app,AO_XXJC_B_SURVEYPOINT sp,FGPS_ALL_VIEW fgps "
				+ "where os.APPARATUSCODE = app.APPARATUSCODE and app.SURVEYPOINTID = sp.SURVEYPOINTID "
				+ "and sp.FGPSTATIONID = fgps.WGCD and fgps.wgno = :fgps)where rownum = 1";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("name", StringType.INSTANCE);
		scalarMap.put("time", DateType.INSTANCE);
		scalarMap.put("valuex", FloatType.INSTANCE);
		scalarMap.put("valuey", FloatType.INSTANCE);
		scalarMap.put("valuez", FloatType.INSTANCE);
		
		return this.getBaseDao().excuteSql(queryString, (Class<T>) SoilPresses.class, scalarMap, params, -1, -1);
	}

}
