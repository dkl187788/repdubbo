package com.ailk.dubbo.model.polling;

import java.io.Serializable;

public class PollingParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1891785771674354927L;

	private String paramId;
	
	private String paramCode;
	
	private String paramValue;
	
	private String paramName;

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	
}
