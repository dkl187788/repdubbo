package com.ailk.dubbo.bean.polling;

import com.ailk.dubbo.bean.base.Head;



public class PollingRequest {

	private Head head = new Head();
	
	private PollingReqBody body = new PollingReqBody();
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public PollingReqBody getBody() {
		return body;
	}
	public void setBody(PollingReqBody body) {
		this.body = body;
	}
}
