package com.thtf.waterflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 损水系数定义
 * @author WHOAMI
 *
 */
@Entity
@Table(name="AZ_WF_DEF")
public class WfdefEntity {

	/**
	 * 调度指令编码
	 */
	
	@Id
	@GeneratedValue(generator="system-uuid" )
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="id",columnDefinition="char(32)")
	private String id;
	
	/**
	 * 分类
	 */
	@Column(name="kind",columnDefinition="varchar2(5)")
	private String kind;
	
	/**
	 * 工程编码
	 */
	@Column(name="fgps",columnDefinition="varchar2(20)")
	private String fgps;
	
	/**
	 * 年
	 */
	@Column(name="year",columnDefinition="char(4)")
	private String year;
	
	/**
	 * 一月损水系数
	 */
	@Column(name="jan",columnDefinition="decimal(4,3)")
	private float jan;
	
	/**
	 * 二月损水系数
	 */
	@Column(name="feb",columnDefinition="decimal(4,3)")
	private float feb;
	
	/**
	 * 三月损水系数
	 */
	@Column(name="mar",columnDefinition="decimal(4,3)")
	private float mar;
	
	/**
	 * 四月损水系数
	 */
	@Column(name="apr",columnDefinition="decimal(4,3)")
	private float apr;
	
	/**
	 * 五月损水系数
	 */
	@Column(name="may",columnDefinition="decimal(4,3)")
	private float may ;
	
	/**
	 * 六月损水系数
	 */
	@Column(name="june",columnDefinition="decimal(4,3)")
	private float june ;
	
	/**
	 * 七月损水系数
	 */
	@Column(name="july",columnDefinition="decimal(4,3)")
	private float july;
	
	/**
	 * 八月损水系数
	 */
	@Column(name="aug",columnDefinition="decimal(4,3)")
	private float aug;
	
	/**
	 * 九月损水系数
	 */
	@Column(name="sept",columnDefinition="decimal(4,3)")
	private float sept;
	
	/**
	 * 十月损水系数
	 */
	@Column(name="oct",columnDefinition="decimal(4,3)")
	private float oct;
	
	/**
	 * 十一月损水系数
	 */
	@Column(name="nov",columnDefinition="decimal(4,3)")
	private float nov;
	
	/**
	 * 十二月损水系数
	 */
	@Column(name="dec",columnDefinition="decimal(4,3)")
	private float  dec;

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public float getJan() {
		return jan;
	}

	public void setJan(float jan) {
		this.jan = jan;
	}

	public float getFeb() {
		return feb;
	}

	public void setFeb(float feb) {
		this.feb = feb;
	}

	public float getMar() {
		return mar;
	}

	public void setMar(float mar) {
		this.mar = mar;
	}

	public float getApr() {
		return apr;
	}

	public void setApr(float apr) {
		this.apr = apr;
	}

	public float getMay() {
		return may;
	}

	public void setMay(float may) {
		this.may = may;
	}

	public float getJune() {
		return june;
	}

	public void setJune(float june) {
		this.june = june;
	}

	public float getJuly() {
		return july;
	}

	public void setJuly(float july) {
		this.july = july;
	}

	public float getAug() {
		return aug;
	}

	public void setAug(float aug) {
		this.aug = aug;
	}

	public float getSept() {
		return sept;
	}

	public void setSept(float sept) {
		this.sept = sept;
	}

	public float getOct() {
		return oct;
	}

	public void setOct(float oct) {
		this.oct = oct;
	}

	public float getNov() {
		return nov;
	}

	public void setNov(float nov) {
		this.nov = nov;
	}

	public float getDec() {
		return dec;
	}

	public void setDec(float dec) {
		this.dec = dec;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	

	
}
