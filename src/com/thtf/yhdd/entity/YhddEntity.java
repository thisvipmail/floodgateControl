package com.thtf.yhdd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AZ_SLDD_YHDD")
public class YhddEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5452488981083861981L;

	@Id
	@GeneratedValue(generator="system-uuid" )
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="id",columnDefinition="char(32)")
	private String id;
	
	/**
	 * 工程编码
	 */
	@Column(name="pumpId",columnDefinition="varchar2(20)")
	private String pumpId;
	
	/**
	 * 目标流量
	 */
	@Column(name="flow")
	private int flow;
	
	/**
	 * 上游水位
	 */
	@Column(name="beflevel",columnDefinition="decimal(4,2)")
	private float befLevel;
	
	/**
	 * 下游水位
	 */
	@Column(name="aftLevel",columnDefinition="decimal(4,2)")
	private float aftLevel;
	
	/**
	 * 机组开启台数
	 */
	@Column(name="num")
	private int nums;
	
	/**
	 * 1#叶片角度
	 */
	@Column(name="angle1",columnDefinition="decimal(5,2)")
	private float angle1;
	
	/**
	 * 2#叶片角度
	 */
	@Column(name="angle2",columnDefinition="decimal(5,2)")
	private float angle2;
	
	/**
	 * 3#叶片角度
	 */
	@Column(name="angle3",columnDefinition="decimal(5,2)")
	private float angle3;
	
	/**
	 * 4#叶片角度
	 */
	@Column(name="angle4",columnDefinition="decimal(5,2)")
	private float angle4;
	
	/**
	 * 5#叶片角度
	 */
	@Column(name="angle5",columnDefinition="decimal(5,2)")
	private float angle5;
	
	/**
	 * 电量单价
	 */
	@Column(name="price",columnDefinition="decimal(3,2)")
	private float price;
	
	/**
	 * 运行时长
	 */
	@Column(name="term")
	private int term;
	
	/**
	 * 	预计电费
	 */
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

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
