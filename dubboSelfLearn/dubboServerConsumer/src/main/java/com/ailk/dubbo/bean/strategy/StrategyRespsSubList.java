package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyRespsSubList {
	
	private Map<String,String> subData = new HashMap<String,String>();
	
	private List<StrategyRespBlock> subList = new ArrayList<StrategyRespBlock>();

	public Map<String, String> getSubData() {
		return subData;
	}

	public void setSubData(Map<String, String> subData) {
		this.subData = subData;
	}

	public List<StrategyRespBlock> getSubList() {
		return subList;
	}

	public void setSubList(List<StrategyRespBlock> subList) {
		this.subList = subList;
	}
}
