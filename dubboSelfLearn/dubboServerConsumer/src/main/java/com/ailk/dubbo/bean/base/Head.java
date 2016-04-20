package com.ailk.dubbo.bean.base;

public class Head {
	private String action = "";
	private String resultCode = "0";
	private String resultcode = "0";
	private String errormsg = "";

	
	public Head() {
		super();
	}

	public Head(String action, String resultCode, String errorMsg) {
		super();
		this.action = action;
		this.resultCode = resultCode;
		this.errormsg = errorMsg;
		this.resultcode = resultCode;
	}

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorMsg() {
		return errormsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errormsg = errorMsg;
	}
}
