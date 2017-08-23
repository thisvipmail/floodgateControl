package com.thtf.webdriver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AZ_GZT_IPSHIP")
public class IPEntity {

	/**
	 * 类型
	 */
	
	@Id
	private String kind;
	
	/**
	 * IP地址
	 */
	private String ip;
	
	/**
	 * 触发类型，nvgt页面跳转，click页面点击
	 */
	private String type;
	
	/**
	 * 首页
	 */
	private String indexPage;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}
	
	
	
}
