package com.thtf.waterflow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AZ_WF_SUM")
public class WfsumEntity {

	/**
	 * 调度指令编码
	 */
	
	@Id
	@Column(name="id",columnDefinition="char(32)")
	private String id;
	
	/**
	 * 工程编码
	 */
	@Column(name="pumpId",columnDefinition="varchar2(20)")
	private String pumpId;
	
	/**
	 * 控制类型（闸：01代表目标流量模式 02代表闸门开度模式 泵站：01代表控制流量模式 02代表控制水量模式）
	 */
	@Column(name="flow")
	private int flow;
	
	/**
	 * 控制量(闸：目标流量 泵站：目标流量或目标水量)
	 */
	@Column(name="beflevel",columnDefinition="decimal(4,2)")
	private float befLevel;
	
	/**
	 * 后水位
	 */
	@Column(name="aftLevel",columnDefinition="decimal(4,2)")
	private float aftLevel;
	
	@Column(name="num")
	private int nums;
	
	@Column(name="angle1",columnDefinition="decimal(5,2)")
	private float angle1;
	
	@Column(name="angle2",columnDefinition="decimal(5,2)")
	private float angle2;
	
	@Column(name="angle3",columnDefinition="decimal(5,2)")
	private float angle3;
	
	@Column(name="angle4",columnDefinition="decimal(5,2)")
	private float angle4;
	
	@Column(name="angle5",columnDefinition="decimal(5,2)")
	private float angle5;
	
	@Column(name="price",columnDefinition="decimal(3,2)")
	private float price;
	
	@Column(name="term",columnDefinition="decimal(7,2)")
	private float term;
	
	@Column(name="total",columnDefinition="decimal(7,2)")
	private float total;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPumpId() {
		return pumpId;
	}

	public void setPumpId(String pumpId) {
		this.pumpId = pumpId;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
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

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public float getAngle1() {
		return angle1;
	}

	public void setAngle1(float angle1) {
		this.angle1 = angle1;
	}

	public float getAngle2() {
		return angle2;
	}

	public void setAngle2(float angle2) {
		this.angle2 = angle2;
	}

	public float getAngle3() {
		return angle3;
	}

	public void setAngle3(float angle3) {
		this.angle3 = angle3;
	}

	public float getAngle4() {
		return angle4;
	}

	public void setAngle4(float angle4) {
		this.angle4 = angle4;
	}

	public float getAngle5() {
		return angle5;
	}

	public void setAngle5(float angle5) {
		this.angle5 = angle5;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTerm() {
		return term;
	}

	public void setTerm(float term) {
		this.term = term;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
