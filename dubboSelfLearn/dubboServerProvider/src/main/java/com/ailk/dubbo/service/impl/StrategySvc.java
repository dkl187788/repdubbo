package com.ailk.dubbo.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.dubbo.mapper.StrategyMapper;
import com.ailk.dubbo.model.strategy.StrategyParam;
import com.ailk.dubbo.model.strategy.Strategys;


import com.ailk.dubbo.service.IStrategySvc;
import com.alibaba.dubbo.config.annotation.Service;



@Service(interfaceClass=IStrategySvc.class,version="1.0")
@Transactional
public class StrategySvc implements IStrategySvc {

	@Autowired
	public StrategyMapper strategyMapper;
	
	@Override
	public List<Strategys> obtainStrategys(StrategyParam sp) {
		return strategyMapper.obtainStrategys(sp);
	}

	@Override
	public String obtainUrlService(Map<String, String> paramMap) {
		return strategyMapper.obtainUrlService(paramMap);
	}
	@Override
	public String obtainStrategyCell(String cellId) {
		return strategyMapper.obtainStrategyCell(cellId);
	}

	@Override
	public List<Strategys> obtainStrategysOnlyCell(StrategyParam sp) {
		return strategyMapper.obtainStrategysOnlyCell(sp);
	}
	

}
