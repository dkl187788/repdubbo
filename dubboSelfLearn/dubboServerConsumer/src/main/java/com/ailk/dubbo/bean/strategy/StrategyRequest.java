package com.ailk.dubbo.bean.strategy;

import com.ailk.dubbo.bean.base.Head;


public class StrategyRequest {

	private Head head = new Head();
	
	private StrategyReqBody body = new StrategyReqBody();
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public StrategyReqBody getBody() {
		return body;
	}
	public void setBody(StrategyReqBody body) {
		this.body = body;
	}
}
