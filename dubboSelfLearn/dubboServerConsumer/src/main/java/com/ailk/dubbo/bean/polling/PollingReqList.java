package com.ailk.dubbo.bean.polling;

import java.util.ArrayList;
import java.util.List;

import com.ailk.dubbo.model.polling.PollingParam;


public class PollingReqList {
	
	private PollingParam subData = new PollingParam();
	
	private List<PollingParam> subList = new ArrayList<PollingParam>();

	public PollingParam getSubData() {
		return subData;
	}

	public void setSubData(PollingParam subData) {
		this.subData = subData;
	}

	public List<PollingParam> getSubList() {
		return subList;
	}

	public void setSubList(List<PollingParam> subList) {
		this.subList = subList;
	}
}
