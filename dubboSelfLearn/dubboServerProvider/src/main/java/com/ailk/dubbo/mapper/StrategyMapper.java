package com.ailk.dubbo.mapper;

import java.util.List;
import java.util.Map;

import com.ailk.dubbo.model.strategy.StrategyParam;
import com.ailk.dubbo.model.strategy.Strategys;




public interface StrategyMapper {
	
	String obtainUrlService(Map<String, String> paramMap);
	
	List<Strategys> obtainStrategys(StrategyParam sp);

	String obtainStrategyCell(String cellId);

	List<Strategys> obtainStrategysOnlyCell(StrategyParam sp);

}