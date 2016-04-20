package com.ailk.dubbo.model.polling;

import java.io.Serializable;
import java.util.List;

public class PollingBlocks implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5404680894129582656L;

	/**
	 * 
	 */

	private String blockId;
	
	private String strategyId;
	
	private String blockStyle;
	
	private List<PollingElements> pollingElementList;

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

	public List<PollingElements> getPollingElementList() {
		return pollingElementList;
	}

	public void setPollingElementList(List<PollingElements> pollingElementList) {
		this.pollingElementList = pollingElementList;
	}
	
}
