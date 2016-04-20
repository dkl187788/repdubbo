package com.ailk.dubbo.model.polling;

import java.io.Serializable;

public class PollingParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3995470033942253483L;

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
