package com.thtf.gcaq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
/**
 * 位移计
 * @author LiuNing
 *
 */
@Entity
@Table(name="AO_XXJC_B_DISPLACEGAGE")
public class DisplaceGage extends OriginalDataBase {

	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuex;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuey;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valuez;

	public float getValuex() {
		return valuex;
	}

	public void setValuex(float valuex) {
		this.valuex = valuex;
	}

	public float getValuey() {
		return valuey;
	}

	public void setValuey(float valuey) {
		this.valuey = valuey;
	}

	public float getValuez() {
		return valuez;
	}

	public void setValuez(float valuez) {
		this.valuez = valuez;
	}
	
	
}
