package com.ailk.dubbo.model.strategy;

import java.io.Serializable;

public class StrategyParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String city;
	
	private String cellId;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	
}
