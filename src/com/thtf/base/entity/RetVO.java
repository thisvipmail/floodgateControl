package com.thtf.base.entity;

import java.util.List;

public class RetVO<T> {
	
	/**
	 * 总行数
	 */
	private int total;
	
	/**
	 * 记录LIST
	 */
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	

}
