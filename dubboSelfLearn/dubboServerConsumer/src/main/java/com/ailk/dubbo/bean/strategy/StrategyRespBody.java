package com.ailk.dubbo.bean.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyRespBody {
	
	private Map<String,String> data = new HashMap<String,String>();
	
	private List<StrategyRespsSubList> list = new ArrayList<StrategyRespsSubList>();

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public List<StrategyRespsSubList> getList() {
		return list;
	}

	public void setList(List<StrategyRespsSubList> list) {
		this.list = list;
	}

}
