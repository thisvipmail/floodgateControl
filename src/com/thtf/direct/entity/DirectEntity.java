package com.thtf.direct.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="AZ_SLDD_INSTRUCT")
public class DirectEntity {

	/**
	 * 调度指令编码
	 */
	
	@Id
	@Column(name="INSTRUCT_CODE",columnDefinition="char(32)")
	private String instructCode;
	
	/**
	 * 工程编码
	 */
	@Column(name="CON_CODE",columnDefinition="varchar2(20)")
	private String conCode;
	
	/**
	 * 名称
	 */
	@Transient
	private String name;
	
	/**
	 * 控制类型（闸：01代表目标流量模式 02代表闸门开度模式 泵站：01代表控制流量模式 02代表控制水量模式）
	 */
	@Column(name="CON_MODEL",columnDefinition="char(2)")
	private String conModel;
	
	/**
	 * 控制量(闸：目标流量 泵站：目标流量或目标水量)
	 */
	@Column(name="CON_VALUE",columnDefinition="decimal(4,2)")
	private float conValue;
	
	/**
	 * 闸门开度
	 */
	@Column(name="BRAKE_DEGREE",columnDefinition="decimal(4,2)")
	private float brakeDegree;
	
	/**
	 * 前水位
	 */
	@Column(name="BEF_LEVEL",columnDefinition="decimal(6,2)")
	private float befLevel;
	
	/**
	 * 后水位
	 */
	@Column(name="AFT_LEVEL",columnDefinition="decimal(6,2)")
	private float aftLevel;
	
	/**
	 * 起始时间
	 */
	@Column(name="STA_TIME",columnDefinition="TIMESTAMP")
	private Date staTime;
	
	/**
	 * 终止时间
	 */
	@Column(name="END_TIME",columnDefinition="TIMESTAMP")
	private Date endTime;
	
	@Column(name="DB_TIME",columnDefinition="TIMESTAMP")
	private Date dbTime;
	
	@Transient
	private String ssqd;
	
	@Transient
	private int state;
	
	public String getInstructCode() {
		return instructCode;
	}

	public void setInstructCode(String instructCode) {
		this.instructCode = instructCode;
	}

	public String getConCode() {
		return conCode;
	}

	public void setConCode(String conCode) {
		this.conCode = conCode;
	}

	public String getConModel() {
		return conModel;
	}

	public void setConModel(String conModel) {
		this.conModel = conModel;
	}

	public float getConValue() {
		if(conCode.startsWith("LRLN") || "01".equals(conModel)){
			return conValue;
		}else{
			return brakeDegree;
		}
		
	}

	public void setConValue(float conValue) {
		this.conValue = conValue;
	}

	public float getBrakeDegree() {
		return brakeDegree;
	}

	public void setBrakeDegree(float brakeDegree) {
		this.brakeDegree = brakeDegree;
	}

	public float getBefLevel() {
		return befLevel;
	}

	public void setBefLevel(float befLevel) {
		this.befLevel = befLevel;
	}

	public float getAftLevel() {
		return aftLevel;
	}

	public void setAftLevel(float aftLevel) {
		this.aftLevel = aftLevel;
	}

	public Date getStaTime() {
		return staTime;
	}

	public void setStaTime(Date staTime) {
		this.staTime = staTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getDbTime() {
		return dbTime;
	}

	public void setDbTime(Date dbTime) {
		this.dbTime = dbTime;
	}

	public String getSsqd() {
		return ssqd;
	}

	public void setSsqd(String ssqd) {
		this.ssqd = ssqd;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
