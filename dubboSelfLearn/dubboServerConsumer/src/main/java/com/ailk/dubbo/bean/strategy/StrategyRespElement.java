package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyRespElement {

	private Map<String,String> paramData = new HashMap<String,String>();
	
	private List<Map<String,String>> paramList = new ArrayList<Map<String,String>>();

	public Map<String, String> getParamData() {
		return paramData;
	}

	public void setParamData(Map<String, String> paramData) {
		this.paramData = paramData;
	}

	public List<Map<String, String>> getParamList() {
		return paramList;
	}

	public void setParamList(List<Map<String, String>> paramList) {
		this.paramList = paramList;
	}
	
}
