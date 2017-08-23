package com.thtf.waterflow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AZ_WF_SUM")
public class WfsumEntity {

	/**
	 * 调度指令编码
	 */
	
	@Id
	@GeneratedValue(generator="system-uuid" )
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="id",columnDefinition="char(32)")
	private String id;
	
	/**
	 * 工程编码
	 */
	@Column(name="fgps",columnDefinition="varchar2(20)")
	private String fgps;
	
	/**
	 * 控制类型（闸：01代表目标流量模式 02代表闸门开度模式 泵站：01代表控制流量模式 02代表控制水量模式）
	 */
	@Column(name="totalflow",columnDefinition="decimal(7,2)")
	private float totalFlow;
	
	@Column(name="time")
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFgps() {
		return fgps;
	}

	public void setFgps(String fgps) {
		this.fgps = fgps;
	}


	public float getTotalFlow() {
		return totalFlow;
	}

	public void setTotalFlow(float totalFlow) {
		this.totalFlow = totalFlow;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

	
}
