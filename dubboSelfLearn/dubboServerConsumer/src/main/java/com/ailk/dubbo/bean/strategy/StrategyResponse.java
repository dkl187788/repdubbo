package com.ailk.dubbo.bean.strategy;

import com.ailk.dubbo.bean.base.Head;


public class StrategyResponse {

	private Head head = new Head();
	
	private StrategyRespBody body = new StrategyRespBody();
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public StrategyRespBody getBody() {
		return body;
	}
	public void setBody(StrategyRespBody body) {
		this.body = body;
	}
}
