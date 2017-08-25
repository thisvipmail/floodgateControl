package com.thtf.direct.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thtf.base.dao.BaseDao;
import com.thtf.base.service.BaseServiceImpl;
import com.thtf.direct.dao.DirectDao;

@Service(value="directService")
public class DirectServiceImpl<T> extends BaseServiceImpl<T> implements DirectService<T>{

	@Resource(name="directDao")
	private DirectDao<T> directDao;
	
	@Override
	public BaseDao<T> getBaseDao() {
		return directDao;
	}

	@Override
	@Transactional
	public List<T> query(Map<String, Object> params,Class<T> cls, int start, int size) {
		String queryString = "select instructCode,STATIONNAME conCode,conModel,conValue ,brakeDegree,befLevel,aftLevel,staTime,endTime,dbTime,dddyid ssqd,state from ("
				+ "select INSTRUCT_CODE instructCode ,CON_CODE conCode,CON_MODEL conModel,CON_VALUE conValue,BRAKE_DEGREE brakeDegree,"
				+ "BEF_LEVEL befLevel,AFT_LEVEL aftLevel,STA_TIME staTime,END_TIME endTime,DB_TIME dbTime,STATE from "
				+ "(select ROW_NUMBER()over(partition by con_code order by db_time desc),INSTRUCT_CODE,CON_CODE,CON_MODEL,CON_VALUE,"
				+ "BRAKE_DEGREE,BEF_LEVEL,AFT_LEVEL,STA_TIME,END_TIME,DB_TIME, CASE WHEN STA_TIME - CURRENT DATE > 0 THEN '0' ELSE '1' END STATE from AZ_SLDD_INSTRUCT) where rownum = 1 or END_TIME > current date)"
				+ " inner join ZHHS_GATE_PUMP_STATION_PROJECT_VIEW on(stationid = conCode)";
		
		Map<String,Type> scalarMap = new HashMap<String,Type>();
		scalarMap.put("instructCode", StringType.INSTANCE);
		scalarMap.put("conCode", StringType.INSTANCE);
		scalarMap.put("conModel", StringType.INSTANCE);
		scalarMap.put("conValue", FloatType.INSTANCE);
		scalarMap.put("brakeDegree", FloatType.INSTANCE);
		scalarMap.put("befLevel", FloatType.INSTANCE);
		scalarMap.put("aftLevel", FloatType.INSTANCE);
		scalarMap.put("staTime", TimestampType.INSTANCE);
		scalarMap.put("endTime", TimestampType.INSTANCE);
		scalarMap.put("dbTime", TimestampType.INSTANCE);
		scalarMap.put("ssqd", StringType.INSTANCE);
		scalarMap.put("state", IntegerType.INSTANCE);
		
		return super.excuteSql(queryString, cls, scalarMap, params, start, size);
	}

	@Override
	@Transactional
	public List<T> queryByIds(List<String> params) {
		return super.queryByIds("from DirectEntity where instructCode in (:ids)", params);
	}

}
