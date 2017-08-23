package com.thtf.webdriver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AZ_GZT_IDSHIP")
public class IDEntity {

	/**
	 * 工程编码
	 */
	@Id
	private String fgps;
	
	/**
	 * 闸控运行
	 */
	private String zkyx;
	
	/**
	 * 闸控告警
	 */
	private String zkgj;
	
	/**
	 * 视频监控
	 */
	private String spjk;
	
	/**
	 * 水质测站
	 */
	private String szcz;
	
	/**
	 * 闸控用户
	 */
	private String zkuser;
	
	/**
	 * 闸控密码
	 */
	private String zkpwd;

	public String getFgps() {
		return fgps;
	}

	public void setFgps(String fgps) {
		this.fgps = fgps;
	}

	public String getZkyx() {
		return zkyx;
	}

	public void setZkyx(String zkyx) {
		this.zkyx = zkyx;
	}

	public String getZkgj() {
		return zkgj;
	}

	public void setZkgj(String zkgj) {
		this.zkgj = zkgj;
	}

	public String getSpjk() {
		return spjk;
	}

	public void setSpjk(String spjk) {
		this.spjk = spjk;
	}

	public String getSzcz() {
		return szcz;
	}

	public void setSzcz(String szcz) {
		this.szcz = szcz;
	}

	public String getZkuser() {
		return zkuser;
	}

	public void setZkuser(String zkuser) {
		this.zkuser = zkuser;
	}

	public String getZkpwd() {
		return zkpwd;
	}

	public void setZkpwd(String zkpwd) {
		this.zkpwd = zkpwd;
	}
	
}
