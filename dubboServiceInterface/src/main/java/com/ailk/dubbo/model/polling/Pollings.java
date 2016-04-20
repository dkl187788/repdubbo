package com.ailk.dubbo.model.polling;

import java.io.Serializable;
import java.util.List;

public class Pollings implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6608148011224104558L;

	private String sId;
	
	private String remark;
	
	private String sTitle;
	
	private String sSort;
	
	private List<PollingBlocks> pollingBlockList;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsSort() {
		return sSort;
	}

	public void setsSort(String sSort) {
		this.sSort = sSort;
	}

	public List<PollingBlocks> getPollingBlockList() {
		return pollingBlockList;
	}

	public void setPollingBlockList(List<PollingBlocks> pollingBlockList) {
		this.pollingBlockList = pollingBlockList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
