package com.ailk.dubbo.bean.polling;

import com.ailk.dubbo.bean.base.Head;


public class PollingResponse {

	private Head head = new Head();
	
	private PollingRespBody body = new PollingRespBody();
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public PollingRespBody getBody() {
		return body;
	}
	public void setBody(PollingRespBody body) {
		this.body = body;
	}
}
