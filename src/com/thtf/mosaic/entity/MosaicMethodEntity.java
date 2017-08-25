package com.thtf.mosaic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AZ_SLDD_MOSAICMETHOD")
public class MosaicMethodEntity {

	/**
	 * 类型
	 */
	@Id
	@Column(name="type",columnDefinition="varchar2(10)")
	private String type;
	
	/**
	 * 值
	 */
	@Column(name="value",columnDefinition="varchar2(1)")
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
