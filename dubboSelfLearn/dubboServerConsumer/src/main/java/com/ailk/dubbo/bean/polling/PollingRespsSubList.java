package com.ailk.dubbo.bean.polling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollingRespsSubList {
	
	private Map<String,String> subData = new HashMap<String,String>();
	
	private List<PollingRespBlock> subList = new ArrayList<PollingRespBlock>();

	public Map<String, String> getSubData() {
		return subData;
	}

	public void setSubData(Map<String, String> subData) {
		this.subData = subData;
	}

	public List<PollingRespBlock> getSubList() {
		return subList;
	}

	public void setSubList(List<PollingRespBlock> subList) {
		this.subList = subList;
	}
}
