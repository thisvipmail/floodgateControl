package com.thtf.base.entity;

public enum StatusCode {

	SUCCESS("400"),ERROR("500");
	
	private StatusCode(String code) {  
        this.code = code;  
    }  
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
}
