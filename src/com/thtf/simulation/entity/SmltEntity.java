package com.thtf.simulation.entity;

public class SmltEntity {

	/**
	 * 开始时间
	 */
	private String beginTime;

	/**
	 * 过闸流量
	 */
	private float dblq;
	
	/**
	 * 前水位
	 */
	private float dblFrontZ;
	
	/**
	 * 后水位
	 */
	private float dblBackZ;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public float getDblq() {
		return dblq;
	}

	public void setDblq(float dblq) {
		this.dblq = dblq;
	}

	public float getDblFrontZ() {
		return dblFrontZ;
	}

	public void setDblFrontZ(float dblFrontZ) {
		this.dblFrontZ = dblFrontZ;
	}

	public float getDblBackZ() {
		return dblBackZ;
	}

	public void setDblBackZ(float dblBackZ) {
		this.dblBackZ = dblBackZ;
	}


	
}
