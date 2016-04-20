package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ailk.dubbo.model.strategy.StrategyParam;




public class StrategyReqBody {
	
	private StrategyParam data = new StrategyParam();
	
	private List<StrategyParam> list = new ArrayList<StrategyParam>();

	public StrategyParam getData() {
		return data;
	}

	public void setData(StrategyParam data) {
		this.data = data;
	}

	public List<StrategyParam> getList() {
		return list;
	}

	public void setList(List<StrategyParam> list) {
		this.list = list;
	}
	
}
