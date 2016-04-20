package com.ailk.dubbo.bean.base;

public class Response {

	private Body body = new Body();
	private Head head = new Head();
	
	public Head getHead() {
		return head;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	
	
}
