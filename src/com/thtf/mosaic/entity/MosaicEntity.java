package com.thtf.mosaic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AZ_SLDD_MOSAIC")
public class MosaicEntity {

	/**
	 * 工程编码
	 */
	@Id
	@Column(name="FGPS",columnDefinition="varchar2(20)")
	private String fgps;
	
	/**
	 * 控制类型（闸：01代表目标流量模式  泵站：01代表控制流量模式）
	 */
	@Column(name="flowAttr",columnDefinition="varchar2(20)")
	private String flowAttr;
	
	/**
	 * 控制类型（闸： 02代表闸门开度模式 泵站：02代表控制水量模式）
	 */
	@Column(name="waterAttr",columnDefinition="varchar2(20)")
	private String waterAttr;
	
	
	/**
	 * 前水位
	 */
	@Column(name="BEFLEVEL",columnDefinition="varchar2(20)")
	private String befLevel;
	
	/**
	 * 后水位
	 */
	@Column(name="AFTLEVEL",columnDefinition="varchar2(20)")
	private String aftLevel;
	
	/**
	 * 急停ID
	 */
	@Column(name="STOPATTR",columnDefinition="varchar2(100)")
	private String stopAttr;

	public String getFgps() {
		return fgps;
	}

	public void setFgps(String fgps) {
		this.fgps = fgps;
	}

	public String getFlowAttr() {
		return flowAttr;
	}

	public void setFlowAttr(String flowAttr) {
		this.flowAttr = flowAttr;
	}

	public String getWaterAttr() {
		return waterAttr;
	}

	public void setWaterAttr(String waterAttr) {
		this.waterAttr = waterAttr;
	}

	public String getBefLevel() {
		return befLevel;
	}

	public void setBefLevel(String befLevel) {
		this.befLevel = befLevel;
	}

	public String getAftLevel() {
		return aftLevel;
	}

	public void setAftLevel(String aftLevel) {
		this.aftLevel = aftLevel;
	}

	public String getStopAttr() {
		return stopAttr;
	}

	public void setStopAttr(String stopAttr) {
		this.stopAttr = stopAttr;
	}
	
	

}
