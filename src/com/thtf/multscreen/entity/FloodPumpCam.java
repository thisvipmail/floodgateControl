package com.thtf.multscreen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLOODPUMP_CAM_ID")
public class FloodPumpCam {

	@Id
	private String floodPumpId;
	
	private String camID;
	
	private String path;

	public String getFloodPumpId() {
		return floodPumpId;
	}

	public void setFloodPumpId(String floodPumpId) {
		this.floodPumpId = floodPumpId;
	}

	public String getCamID() {
		return camID;
	}

	public void setCamID(String camID) {
		this.camID = camID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
