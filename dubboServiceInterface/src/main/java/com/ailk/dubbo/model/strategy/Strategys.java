package com.ailk.dubbo.model.strategy;

import java.io.Serializable;
import java.util.List;

public class Strategys implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sId;
	
	private String sTitle;
	
	private String sSort;
	
	private List<StrategyBlocks> strategyBlockList;

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

	public List<StrategyBlocks> getStrategyBlockList() {
		return strategyBlockList;
	}

	public void setStrategyBlockList(List<StrategyBlocks> strategyBlockList) {
		this.strategyBlockList = strategyBlockList;
	}
	
}
