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

	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float value;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float frequency;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float temperature;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

}
