package com.ailk.dubbo.model.strategy;

import java.io.Serializable;
import java.util.List;

public class StrategyBlocks implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String blockId;
	
	private String strategyId;
	
	private String blockStyle;
	
	private List<StrategyElements> strategyElementList;

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
	}

	public String getBlockStyle() {
		return blockStyle;
	}

	public void setBlockStyle(String blockStyle) {
		this.blockStyle = blockStyle;
	}

	public List<StrategyElements> getStrategyElementList() {
		return strategyElementList;
	}

	public void setStrategyElementList(List<StrategyElements> strategyElementList) {
		this.strategyElementList = strategyElementList;
	}
	
}
