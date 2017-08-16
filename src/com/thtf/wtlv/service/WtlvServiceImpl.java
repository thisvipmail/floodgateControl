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
		
		String sql = "select stan,samplingtime,waterlevel,dic.SMALL_TYPE_NAME name,nvl(value,0) value,waterqualitygrade level from AP_XXJC_B_MONITORSTATION left join ("
				+ "select * from("
				+ "select SAMPLINGTIME,BASEINFOID,WATERLEVEL,MONITORPOINT,ROW_NUMBER() over(partition by MONITORPOINT order by SAMPLINGTIME desc) from AP_XXJC_B_MONITORDATABASE where WATERLEVEL != 'F'"
				+ ") where rownum = 1)base on (stationid = base.MONITORPOINT) "
				+ "left join AP_XXJC_B_MONITORDATADETAIL detail on(detail.BASEINFOID = base.BASEINFOID)  "
				+ "inner join (select * from SYSPL_DIC_SMALL_TYPE where BIG_TYPE_ID = '160')dic on(monitoritem = dic.SMALL_TYPE_CODE)";
		
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

	@Override
	@Transactional
	public List<T> queryList(String name,Class<T> t) {
		String sql = "select rownum,waterlevel,MAX(case MONITORITEM when 'w01001' then value end) ph,"
				+ "MAX(case MONITORITEM when 'w01010' then value end) sw,MAX(case MONITORITEM when 'w21011' then value end) p,"
				+ "MAX(case MONITORITEM when 'w21001' then value end) zn,MAX(case MONITORITEM when 'w01019' then value end) gmsj,"
				+ "MAX(case MONITORITEM when 'w21003' then value end) an,MAX(case MONITORITEM when 'w01003' then value end) hzd,"
				+ "MAX(case MONITORITEM when 'w01014' then value end) ddl,MAX(case MONITORITEM when 'w01009' then value end ) rjy "
				+ "from(select * from("
				+ "SELECT SAMPLINGTIME,row_number() over(order by SAMPLINGTIME desc),BASEINFOID,WATERLEVEL FROM AP_XXJC_B_MONITORDATABASE WHERE WATERLEVEL != 'F' AND "
				+ "SAMPLINGTIME BETWEEN CURRENT DATE - 7 AND CURRENT DATE AND EXISTS"
				+ "(SELECT * FROM AP_XXJC_B_MONITORSTATION WHERE stan = :name AND STATIONID = MONITORPOINT )) base"
				+ " inner join (select MONITORITEM,VALUE,BASEINFOID from AP_XXJC_B_MONITORDATADETAIL) detail on(detail.BASEINFOID = base.BASEINFOID )order by SAMPLINGTIME desc) group by rownum,waterlevel";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("rownum", StringType.INSTANCE);
		scalarMap.put("waterlevel", StringType.INSTANCE);
		scalarMap.put("ph", StringType.INSTANCE);
		scalarMap.put("sw", StringType.INSTANCE);
		scalarMap.put("p", StringType.INSTANCE);
		scalarMap.put("zn", StringType.INSTANCE);
		scalarMap.put("gmsj", StringType.INSTANCE);
		scalarMap.put("an", StringType.INSTANCE);
		scalarMap.put("hzd", StringType.INSTANCE);
		scalarMap.put("ddl", StringType.INSTANCE);
		scalarMap.put("rjy", StringType.INSTANCE);
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		
		return super.excuteSql(sql, t, scalarMap, params, -1, -1);
	}


}
