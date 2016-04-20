package com.ailk.dubbo.service;

import java.util.List;
import java.util.Map;

import com.ailk.dubbo.model.strategy.StrategyParam;
import com.ailk.dubbo.model.strategy.Strategys;
public interface IStrategySvc {

	public String obtainUrlService(Map<String,String> paramMap);
	
	public List<Strategys> obtainStrategys(StrategyParam sp);
	
	public String obtainStrategyCell(String cellId);
	
	public List<Strategys> obtainStrategysOnlyCell(StrategyParam sp) ;
	
}
