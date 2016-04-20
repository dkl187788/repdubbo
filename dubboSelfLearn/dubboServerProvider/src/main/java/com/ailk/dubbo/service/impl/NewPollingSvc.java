package com.ailk.dubbo.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.dubbo.mapper.NewPollingMapper;
import com.ailk.dubbo.model.polling.PollingParam;
import com.ailk.dubbo.model.polling.Pollings;
import com.ailk.dubbo.service.INewPollingSvc;
import com.alibaba.dubbo.config.annotation.Service;



@Service(version="1.0",interfaceClass=INewPollingSvc.class)
//@Service("iNewPollingSvc")
@Transactional
public class NewPollingSvc implements INewPollingSvc {

	@Autowired
	public NewPollingMapper pollingMapper;

	@Override
	public List<Pollings> obtainPollingsCell(PollingParam sp) {
		return pollingMapper.obtainPollingCell(sp);
	}

	@Override
	public List<Pollings> obtainPollingCountry(PollingParam sp) {	
		return pollingMapper.obtainPollingCountry(sp);
	}

	public List<Pollings> obtainPollingCity(PollingParam sp) {
		return pollingMapper.obtainPollingCity(sp);
	}

	@Override
	public List<Pollings> obtainPollingsDefault(PollingParam sp) {
		return pollingMapper.obtainPollingsDefault(sp);
	}

	@Override
	public String obtainPollingUrl() {
		return pollingMapper.obtainPollingUrl();
	}

	@Override
	public List<Pollings> obtainSuperMarket(PollingParam sp) {
		return pollingMapper.obtainSuperMarket(sp);
	}

	@Override
	public String obtainSuperMarketUrl() {
		return pollingMapper.obtainSuperMarketUrl();
	}

	@Override
	public Map<String, BigDecimal> obtainlongitude(String cellId) {
		return pollingMapper.obtainlongitude(cellId);
	}

	@Override
	public Map<String, String> selectBoundWuYe(String cellId) {
		return pollingMapper.selectBoundWuYe(cellId);
	}

	@Override
	public int selectUserCountByCellId(String cellId) {
		return pollingMapper.selectUserCountByCellId(cellId);
	}

	
	
}
