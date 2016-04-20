package com.ailk.dubbo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ailk.dubbo.model.polling.PollingParam;
import com.ailk.dubbo.model.polling.Pollings;


public interface INewPollingSvc {

	public List<Pollings> obtainPollingsCell(PollingParam sp);

	public List<Pollings> obtainPollingCountry(PollingParam sp);

	public List<Pollings> obtainPollingCity(PollingParam sp);

	public List<Pollings> obtainPollingsDefault(PollingParam sp);

	public String obtainPollingUrl();

	public List<Pollings> obtainSuperMarket(PollingParam sp);

	public String obtainSuperMarketUrl();
	
	Map<String,BigDecimal>obtainlongitude(String cellId);
	
	public int selectUserCountByCellId(String cellid);
	
	public Map<String,String> selectBoundWuYe(String cellId);
	
	
}
