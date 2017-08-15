package com.thtf.wtlv.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WtlvVo {

	private String name;
	private Date time;
	private String level;
	private List<WtlvDtlVo> itemData = new ArrayList<WtlvDtlVo>();
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<WtlvDtlVo> getItemData() {
		return itemData;
	}
	public void setItemData(List<WtlvDtlVo> itemData) {
		this.itemData = itemData;
	}
	
	
}
