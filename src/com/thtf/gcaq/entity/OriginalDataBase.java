package com.thtf.gcaq.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class OriginalDataBase {

	@Id
	@Column(name="id",columnDefinition="char(32)")
	private String originalDataId;
	
	/**
	 * 仪器编号
	 */
	@Column(length=100)
	private String apparatusCode;
	/**
	 * 测值时间
	 */
	@Column(columnDefinition="date")
	private Date surveyTime;
	/**
	 * 数据时间
	 */
	@Column(columnDefinition="date")
	private Date dbTime = new Date();
	public String getOriginalDataId() {
		return originalDataId;
	}
	public void setOriginalDataId(String originalDataId) {
		this.originalDataId = originalDataId;
	}
	public String getApparatusCode() {
		return apparatusCode;
	}
	public void setApparatusCode(String apparatusCode) {
		this.apparatusCode = apparatusCode;
	}
	public Date getSurveyTime() {
		return surveyTime;
	}
	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
	}
	public Date getDbTime() {
		return dbTime;
	}
	public void setDbTime(Date dbTime) {
		this.dbTime = dbTime;
	}
	
	
}
