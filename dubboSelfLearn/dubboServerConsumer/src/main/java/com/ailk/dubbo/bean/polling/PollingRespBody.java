package com.ailk.dubbo.bean.polling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollingRespBody {
	
	private Map<String,String> data = new HashMap<String,String>();
	
	private List<PollingRespsSubList> list = new ArrayList<PollingRespsSubList>();

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public List<PollingRespsSubList> getList() {
		return list;
	}

	public void setList(List<PollingRespsSubList> list) {
		this.list = list;
	}

}
