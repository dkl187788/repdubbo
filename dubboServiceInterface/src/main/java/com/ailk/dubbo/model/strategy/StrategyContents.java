package com.ailk.dubbo.model.strategy;

import java.io.Serializable;
import java.util.List;

public class StrategyContents implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String scId;
	
	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	private String scName;
	
	private String scType;
	
	private List<StrategyParams> StrategyParamList;

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScType() {
		return scType;
	}

	public void setScType(String scType) {
		this.scType = scType;
	}

	public List<StrategyParams> getStrategyParamList() {
		return StrategyParamList;
	}

	public void setStrategyParamList(List<StrategyParams> strategyParamList) {
		StrategyParamList = strategyParamList;
	}

}
