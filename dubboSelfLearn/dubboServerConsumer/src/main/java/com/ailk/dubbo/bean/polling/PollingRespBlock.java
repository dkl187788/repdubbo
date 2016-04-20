package com.ailk.dubbo.bean.polling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollingRespBlock {
	
	private Map<String,String> blockData = new HashMap<String,String>();
	
	private List<PollingRespElement> blockList = new ArrayList<PollingRespElement>();

	public Map<String, String> getBlockData() {
		return blockData;
	}

	public void setBlockData(Map<String, String> blockData) {
		this.blockData = blockData;
	}

	public List<PollingRespElement> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<PollingRespElement> blockList) {
		this.blockList = blockList;
	}

}
