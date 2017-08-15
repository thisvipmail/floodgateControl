package com.thtf.wtlv.entity;

import java.util.Date;

public class WtlvEntity extends WtlvDtlVo{
	private String stan;
	private Date samplingtime;
	private String waterlevel;
	public String getStan() {
		return stan;
	}
	public void setStan(String stan) {
		this.stan = stan;
	}
	public Date getSamplingtime() {
		return samplingtime;
	}
	public void setSamplingtime(Date samplingtime) {
		this.samplingtime = samplingtime;
	}
	public String getWaterlevel() {
		return waterlevel;
	}
	public void setWaterlevel(String waterlevel) {
		this.waterlevel = waterlevel;
	}
	
}
