package com.thtf.gcaq.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;

import com.thtf.gcaq.entity.DisplaceGage;

@Service(value="dgService")
public class DisplaceGageServiceImpl<T> extends GcaqServiceImpl<T>{

	@Override
	public List<T> query(Map<String,Object> params) {
		
		String queryString = "select apparatusname,surveytime,valuex,valuey,valuez from(select ROW_NUMBER()over(partition by app.APPARATUSID order by os.SURVEYTIME desc), "
				+ "app.APPARATUSNAME,dg.SURVEYTIME,dg.valuex,dg.valuey,dg.valuez "
				+ "from AO_XXJC_B_DISPLACEGAGE dg ,AO_XXJC_B_APPARATUSINFO app,AO_XXJC_B_SURVEYPOINT sp "
				+ "where dg.APPARATUSCODE = app.APPARATUSCODE and app.SURVEYPOINTID = sp.SURVEYPOINTID "
				+ "and sp.FGPSTATIONID = :fgps)where rownum = 1";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("apparatusname", StringType.INSTANCE);
		scalarMap.put("surveytime", DateType.INSTANCE);
		scalarMap.put("valuex", FloatType.INSTANCE);
		scalarMap.put("valuey", FloatType.INSTANCE);
		scalarMap.put("valuez", FloatType.INSTANCE);
		
		return this.getBaseDao().excuteSql(queryString, (Class<T>) DisplaceGage.class, scalarMap, params, -1, -1);
	}

}
