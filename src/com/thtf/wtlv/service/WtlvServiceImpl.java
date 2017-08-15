package com.thtf.wtlv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.type.FloatType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.wtlv.dao.WtlvDao;

@Service(value="wtlvService")
public class WtlvServiceImpl<T> extends BaseServiceImpl<T> implements WtlvService<T>{

	@Override
	@Transactional
	public List<T> query(Class<T> t) {
		
		String sql = "select stan,samplingtime,waterlevel,monitoritem name,nvl(value,0) value,waterqualitygrade level from AP_XXJC_B_MONITORSTATION left join ("
				+ "select * from("
				+ "select SAMPLINGTIME,BASEINFOID,WATERLEVEL,MONITORPOINT,ROW_NUMBER() over(partition by MONITORPOINT order by SAMPLINGTIME desc) from AP_XXJC_B_MONITORDATABASE where WATERLEVEL != 'F'"
				+ ") where rownum = 1)base on (stationid = base.MONITORPOINT) "
				+ "left join AP_XXJC_B_MONITORDATADETAIL detail on(detail.BASEINFOID = base.BASEINFOID)";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("stan", StringType.INSTANCE);
		scalarMap.put("waterlevel", StringType.INSTANCE);
		scalarMap.put("name", StringType.INSTANCE);
		scalarMap.put("level", StringType.INSTANCE);
		scalarMap.put("value", FloatType.INSTANCE);
		scalarMap.put("samplingtime", TimestampType.INSTANCE);
		
		return super.excuteSql(sql, t, scalarMap, null, -1, -1);
	}
	@Resource(name="wtlvDao")
	private WtlvDao<T> wtlvDao;

	@Override
	public BaseDao<T> getBaseDao() {
		return wtlvDao;
	}


}
