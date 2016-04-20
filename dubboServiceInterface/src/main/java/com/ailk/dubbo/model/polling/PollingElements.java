package com.ailk.dubbo.model.polling;

import java.io.Serializable;

public class PollingElements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2758348994436027738L;

	/**
	 * 
	 */

	private String srId;
	
	private String scImg;
	
	private String srSort;
	
	private PollingContents pollingContents;

	public String getSrSort() {
		return srSort;
	}

	public void setSrSort(String srSort) {
		this.srSort = srSort;
	}

	public String getScImg() {
		return scImg;
	}

	public void setScImg(String scImg) {
		this.scImg = scImg;
	}

	public PollingContents getPollingContents() {
		return pollingContents;
	}

	public void setPollingContents(PollingContents pollingContents) {
		this.pollingContents = pollingContents;
	}

	public String getSrId() {
		return srId;
	}

	public void setSrId(String srId) {
		this.srId = srId;
	}
	
}
