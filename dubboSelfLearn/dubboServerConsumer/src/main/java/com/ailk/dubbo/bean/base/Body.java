package com.ailk.dubbo.bean.base;

import java.util.ArrayList;
import java.util.List;


public class Body {
	private Object data = new Object();
	@SuppressWarnings("rawtypes")
	private List list = new ArrayList();
	
	
	public Body() {
		super();
	}
	@SuppressWarnings("rawtypes")
	public Body(Object data, List list) {
		super();
		this.data = data;
		this.list = list;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	
}
