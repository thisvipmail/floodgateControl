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
	private float valueX;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valueY;
	
	@Column(columnDefinition = "decimal(8,4)")
	@NumberFormat(pattern="####.####",style=Style.NUMBER)
	private float valueZ;
	
	public float getValueX() {
		return valueX;
	}

	public void setValueX(float valueX) {
		this.valueX = valueX;
	}

	public float getValueY() {
		return valueY;
	}

	public void setValueY(float valueY) {
		this.valueY = valueY;
	}

	public float getValueZ() {
		return valueZ;
	}

	public void setValueZ(float valueZ) {
		this.valueZ = valueZ;
	}
}
