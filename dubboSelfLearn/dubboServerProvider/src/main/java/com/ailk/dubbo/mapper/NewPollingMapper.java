package com.ailk.dubbo.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ailk.dubbo.model.polling.PollingParam;
import com.ailk.dubbo.model.polling.Pollings;



public interface NewPollingMapper {
	
	
    
	List<Pollings> obtainPollingCell(PollingParam sp);


	List<Pollings> obtainPollingCity(PollingParam sp);

	List<Pollings> obtainPollingCountry(PollingParam sp);

	List<Pollings> obtainPollingsDefault(PollingParam sp);


	String obtainPollingUrl();


	List<Pollings> obtainSuperMarket(PollingParam sp);


	String obtainSuperMarketUrl();
	
	 int selectUserCountByCellId(String cellid);
	 
	 Map<String,String> selectBoundWuYe(String cellId);
	 
	Map<String,BigDecimal>obtainlongitude(String cellId);
	
	
}