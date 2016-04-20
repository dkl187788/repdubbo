package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyRespBlock {
	
	private Map<String,String> blockData = new HashMap<String,String>();
	
	private List<StrategyRespElement> blockList = new ArrayList<StrategyRespElement>();

	public Map<String, String> getBlockData() {
		return blockData;
	}

	public void setBlockData(Map<String, String> blockData) {
		this.blockData = blockData;
	}

	public List<StrategyRespElement> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<StrategyRespElement> blockList) {
		this.blockList = blockList;
	}

}
