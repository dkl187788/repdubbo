package com.ailk.dubbo.model.strategy;

import java.io.Serializable;

public class StrategyElements  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String srId;
	
	private String scImg;
	
	private String srSort;
	
	private StrategyContents strategyContents;

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

	public StrategyContents getStrategyContents() {
		return strategyContents;
	}

	public void setStrategyContents(StrategyContents strategyContents) {
		this.strategyContents = strategyContents;
	}

	public String getSrId() {
		return srId;
	}

	public void setSrId(String srId) {
		this.srId = srId;
	}
	
}
