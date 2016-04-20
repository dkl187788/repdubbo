package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ailk.dubbo.model.strategy.StrategyParam;




public class StrategyReqList {
	
	private StrategyParam subData = new StrategyParam();
	
	private List<StrategyParam> subList = new ArrayList<StrategyParam>();

	public StrategyParam getSubData() {
		return subData;
	}

	public void setSubData(StrategyParam subData) {
		this.subData = subData;
	}

	public List<StrategyParam> getSubList() {
		return subList;
	}

	public void setSubList(List<StrategyParam> subList) {
		this.subList = subList;
	}
}
