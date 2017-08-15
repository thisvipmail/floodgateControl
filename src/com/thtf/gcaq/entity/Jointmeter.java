package com.thtf.gcaq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * 测缝计
 *
 */
@Entity
@Table(name="AO_XXJC_B_JOINTMETER")
public class Jointmeter extends OriginalDataBase {

	@Column(name="frequency", columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuex;
	
	@Column(name="value", columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuez;
	
	@Column(name="temperature", columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuey;

	public float getValuex() {
		return valuex;
	}

	public void setValuex(float valuex) {
		this.valuex = valuex;
	}

	public float getValuez() {
		return valuez;
	}

	public void setValuez(float valuez) {
		this.valuez = valuez;
	}

	public float getValuey() {
		return valuey;
	}

	public void setValuey(float valuey) {
		this.valuey = valuey;
	}

}
