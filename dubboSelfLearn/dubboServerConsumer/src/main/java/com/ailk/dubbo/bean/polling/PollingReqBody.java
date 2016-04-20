package com.ailk.dubbo.bean.polling;

import java.util.ArrayList;
import java.util.List;

import com.ailk.dubbo.model.polling.PollingParam;



public class PollingReqBody {
	
	private PollingParam data = new PollingParam();
	
	private List<PollingParam> list = new ArrayList<PollingParam>();

	public PollingParam getData() {
		return data;
	}

	public void setData(PollingParam data) {
		this.data = data;
	}

	public List<PollingParam> getList() {
		return list;
	}

	public void setList(List<PollingParam> list) {
		this.list = list;
	}
	
}
