package com.thtf.simulation.entity;

public class RealDataEntity {

	/**
	 * 开始时间
	 */
	private String dbtime;

	/**
	 * 过闸流量
	 */
	private float flowvalue;
	
	/**
	 * 前水位
	 */
	private float sysw;
	
	/**
	 * 后水位
	 */
	private float xysw;

	public String getDbtime() {
		return dbtime;
	}

	public void setDbtime(String dbtime) {
		this.dbtime = dbtime;
	}

	public float getFlowvalue() {
		return flowvalue;
	}

	public void setFlowvalue(float flowvalue) {
		this.flowvalue = flowvalue;
	}

	public float getSysw() {
		return sysw;
	}

	public void setSysw(float sysw) {
		this.sysw = sysw;
	}

	public float getXysw() {
		return xysw;
	}

	public void setXysw(float xysw) {
		this.xysw = xysw;
	}


	
}
