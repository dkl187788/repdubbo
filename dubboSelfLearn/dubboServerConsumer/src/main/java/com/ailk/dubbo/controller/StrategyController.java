package com.ailk.dubbo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ailk.dubbo.bean.strategy.StrategyRequest;
import com.ailk.dubbo.bean.strategy.StrategyRespBlock;
import com.ailk.dubbo.bean.strategy.StrategyRespElement;
import com.ailk.dubbo.bean.strategy.StrategyRespsSubList;


import com.ailk.dubbo.model.strategy.StrategyBlocks;
import com.ailk.dubbo.model.strategy.StrategyContents;
import com.ailk.dubbo.model.strategy.StrategyElements;
import com.ailk.dubbo.model.strategy.StrategyParam;
import com.ailk.dubbo.model.strategy.StrategyParams;
import com.ailk.dubbo.model.strategy.Strategys;
import com.ailk.dubbo.service.IStrategySvc;
import com.ailk.dubbo.util.JSONUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("/StrategyController/")
public class StrategyController extends BaseController {
	
	@Autowired
	public IStrategySvc iStrategySvc;
	
	@RequestMapping(value = "obtainStrategys")
	public void obtainStrategys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String str = parseRequestData(request);
		request.setAttribute("json", str);
		String json = (String)request.getAttribute("json");
		logger.info(str+"==============================="+json);
		Gson gson = new Gson();
		StrategyRequest sr = gson.fromJson(json, StrategyRequest.class);
		StrategyParam sp = sr.getBody().getData();
		String action = sr.getHead().getAction();		
		List<StrategyRespsSubList> subResqList = null;		 
		 // 重新组建频道数据 满足设定的数据结构
		subResqList = concreteStrategyData(sp);
		JSONUtils.successNewVersion(response, null, subResqList, action);
	}

	// 重新组建频道数据 满足设定的数据结构
	private List<StrategyRespsSubList> concreteStrategyData(StrategyParam sp) {
		List<StrategyRespsSubList> subResqList = new ArrayList<StrategyRespsSubList>();
		StrategyRespsSubList subResq;
		StrategyRespBlock respBlock;
		List<StrategyRespBlock> blockRespList = null;
		List<Strategys> strategylist = null;
		String strategyOnlyCell = iStrategySvc.obtainStrategyCell(sp.getCellId());
		if(strategyOnlyCell !=null  &&  !"".equals(strategyOnlyCell)){
		strategylist  = iStrategySvc.obtainStrategysOnlyCell(sp);
		}else{
	    strategylist = iStrategySvc.obtainStrategys(sp);
		}
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("param1", "0");
		String url = iStrategySvc.obtainUrlService(paramMap);
		Map<String,String> map = null;
		List<Map<String,String>> paramsList = null;
		List<StrategyRespElement> blockList = null;
		StrategyRespElement blockChild = null;
		for (int i = 0; i < strategylist.size(); i++) {
			blockRespList = new ArrayList<StrategyRespBlock>();
			subResq = new StrategyRespsSubList();
			Strategys s = strategylist.get(i);
			map = new HashMap<String,String>();
			map.put("sTitle", s.getsTitle());
			map.put("sSort", s.getsSort());
			subResq.setSubData(map);
			List<StrategyBlocks> sbList = s.getStrategyBlockList();
			for (int l = 0; l < sbList.size(); l++) {
				respBlock = new StrategyRespBlock();
				StrategyBlocks strategyBlock = sbList.get(l);
				map = new HashMap<String,String>();
				map.put("blockStyle", strategyBlock.getBlockStyle());
				map.put("strategyId", strategyBlock.getStrategyId());
				respBlock.setBlockData(map);
				List<StrategyElements> srlist = strategyBlock.getStrategyElementList();
				blockList = new ArrayList<StrategyRespElement>();
				for (int j = 0; j < srlist.size(); j ++) {
					blockChild = new StrategyRespElement();
					StrategyElements strategyElements = srlist.get(j);
					StrategyContents strategyContents = strategyElements.getStrategyContents();
					map = new HashMap<String,String>();
					map.put("scImg", url + strategyElements.getScImg());
					map.put("scType", strategyContents.getScType());
					map.put("srSort", strategyElements.getSrSort());
					map.put("elementId", strategyElements.getSrId());
					map.put("contentId", strategyContents.getScId());//图片路径
					blockChild.setParamData(map);					
					List<StrategyParams> strategyParamsList = strategyContents.getStrategyParamList();
					paramsList = new ArrayList<Map<String,String>>();
					for (int k = 0; k < strategyParamsList.size(); k++) {
						map = new HashMap<String,String>();
						StrategyParams strategyParams = strategyParamsList.get(k);
						map.put("paramCode", strategyParams.getParamCode());
						map.put("paramValue", strategyParams.getParamValue());
						paramsList.add(map);
					}
					blockChild.setParamList(paramsList);
					blockList.add(blockChild);
				}
				respBlock.setBlockList(blockList);
				blockRespList.add(respBlock);
			}
			subResq.setSubList(blockRespList);
			subResqList.add(subResq);
		}
		return subResqList;
	}
	
}
