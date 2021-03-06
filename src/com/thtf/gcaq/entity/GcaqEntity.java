package com.thtf.gcaq.entity;

import java.util.List;

public class GcaqEntity<T> {

	/**
	 * 类型名称
	 */
	private String name;
	
	/**
	 * 类型代码
	 */
	private String code;
	
	private List<T> itemData;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<T> getItemData() {
		return itemData;
	}

	public void setItemData(List<T> itemData) {
		this.itemData = itemData;
	}


}
