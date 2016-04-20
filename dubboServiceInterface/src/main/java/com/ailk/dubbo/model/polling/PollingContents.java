package com.ailk.dubbo.model.polling;

import java.io.Serializable;
import java.util.List;

public class PollingContents implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7608714695268721325L;

	/**
	 * 
	 */

	private String scId;
	
	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	private String scName;
	
	private String scType;
	
	private List<PollingParams> pollingParamList;

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScType() {
		return scType;
	}

	public void setScType(String scType) {
		this.scType = scType;
	}

	public List<PollingParams> getPollingParamList() {
		return pollingParamList;
	}

	public void setPollingParamList(List<PollingParams> pollingParamList) {
		this.pollingParamList = pollingParamList;
	}

}
