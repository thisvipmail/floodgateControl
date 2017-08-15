package com.thtf.gcaq.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


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
	
	@Transient
	private String name;
	
	/**
	 * 测值时间
	 */
	@Column(name="surveyTime" ,columnDefinition="date")
	private Date time;
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
	public Date getDbTime() {
		return dbTime;
	}
	public void setDbTime(Date dbTime) {
		this.dbTime = dbTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
