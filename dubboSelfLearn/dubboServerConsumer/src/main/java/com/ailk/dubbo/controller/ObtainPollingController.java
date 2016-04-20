package com.ailk.dubbo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.ailk.dubbo.bean.polling.PollingRequest;
import com.ailk.dubbo.bean.polling.PollingRespBlock;
import com.ailk.dubbo.bean.polling.PollingRespElement;
import com.ailk.dubbo.bean.polling.PollingRespsSubList;
import com.ailk.dubbo.model.polling.PollingBlocks;
import com.ailk.dubbo.model.polling.PollingContents;
import com.ailk.dubbo.model.polling.PollingElements;
import com.ailk.dubbo.model.polling.PollingParam;
import com.ailk.dubbo.model.polling.PollingParams;
import com.ailk.dubbo.model.polling.Pollings;
import com.ailk.dubbo.service.INewPollingSvc;
import com.ailk.dubbo.util.JSONUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;

/**
 * 
 * @title 新版轮训图
 * @author admin
 * @refactor 
 * @date 2015年9月17日
 * 
 *
 *
 */
@Controller
@RequestMapping("/obtainPollingController/")
public class ObtainPollingController  extends BaseController{
	
	private String url =null;
	
	@Autowired
	@Reference(version="1.0")
	public INewPollingSvc iNewPollingSvc;
	
	
	@RequestMapping(value="obtainPolling.json")
	public void  obtainPolling(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("===============come in obtainPolling interface==============");
		String str = parseRequestData(request);
		request.setAttribute("json", str);
		String json = (String) request.getAttribute("json");
		Gson gson = new Gson();
		PollingRequest sr = gson.fromJson(json, PollingRequest.class);
		PollingParam sp = sr.getBody().getData();
		String action = sr.getHead().getAction();
		String cellId = sp.getCellId();
		Map<String, String> mapParam = new HashMap<String, String>();
		
		// 小区轮训图图片路径前缀
		String tempUrl = iNewPollingSvc.obtainPollingUrl();		
		if (tempUrl == null) {
			url = "http://182.92.161.166/images/UPLOAD_FILE_PATH/";
		}else{
			url = tempUrl;
		}
		// 获取小区人气
		obtainCellCount(cellId, mapParam);
		// 确认是否绑定物业
		confirmBondProperty(cellId, mapParam);
		// 3.小区轮训图	
		List<PollingRespsSubList> subResqList = new ArrayList<PollingRespsSubList>();		
		PollingRespsSubList subResq = new PollingRespsSubList();
		List<PollingRespBlock> blockRespList = new ArrayList<PollingRespBlock>();
		PollingRespBlock respBlock = new PollingRespBlock();
		List<PollingRespElement> blockList = new ArrayList<PollingRespElement>();
		Map<String, String> blockData = new HashMap<String, String>();
		if (!obtainPolling(sp, blockData, blockList)) {
			JSONUtils.failedNewVersion(response, "8888", "输入参数有误！", action);
			return;
		}
		System.out.println("=============start===========");
		if(blockData!=null){
			System.out.println(blockData.get("strategyId"));
		}
		// 4.获取首页超市专场 的配置信息
		obtainSuperMarket(sp, blockList);
		if (blockData != null) {
			respBlock.setBlockData(blockData);
		}
		respBlock.setBlockList(blockList);
		blockRespList.add(respBlock);
		subResq.setSubList(blockRespList);
		subResqList.add(subResq);
		if (subResqList != null && subResqList.size() > 0) {
			JSONUtils.successNewVersion(response, mapParam, subResqList, action);
		} else {
			JSONUtils.failedNewVersion(response, "8888", "该小区无广告图", action);
		}
	}

	
	// 获取超市专场配置信息
	private void obtainSuperMarket(PollingParam sp,	List<PollingRespElement> blockList) {		
		String cellId = sp.getCellId();
		String cityId = sp.getCity();
		int count2 = blockList.size();
		if (count2 >= 4) {
			String superUrl = iNewPollingSvc.obtainSuperMarketUrl();
			if (superUrl == null || "".equals(superUrl.trim())) {
				superUrl = "http://182.92.161.166:8090/pmcs/htmController/ctrl.htm?action=responseUrlPartner";
			}
			List<Pollings> pollinglist5 = null;
			if (cityId != null && !"".equals(cityId.trim())) {
				pollinglist5 = iNewPollingSvc.obtainSuperMarket(sp);// 查询是否配置默认
			}
			if (pollinglist5 != null) {
				List<PollingRespBlock> blockRespList = changeList(pollinglist5);
				List<PollingRespElement> blockList2 = null;
				if (blockRespList != null && blockRespList.size() > 0) {
					blockList2 = blockRespList.get(0).getBlockList();
					List<Map<String, String>> element = blockList2.get(0)
							.getParamList();					
					if (element == null || element.size() == 0) {
						confirmSuperMarket(cellId, blockList, superUrl);
					}
					blockList.add(blockList2.get(0));
				} else {
					confirmSuperMarket(cellId, blockList, superUrl);
				}
			} else {
				confirmSuperMarket(cellId, blockList, superUrl);
			}
		}
	}
    // 根据 小区、城市、全国、默认 获取小区轮训图配置信息  
	private boolean obtainPolling( PollingParam sp,Map<String, String> blockData, List<PollingRespElement> blockList)
				throws IOException {
		String cellId = sp.getCellId();
		String cityId = sp.getCity();
		List<Pollings> requestPollingList = null;
		boolean flag = false;
		if (cellId != null && !"".equals(cellId.trim())) {
			requestPollingList = iNewPollingSvc.obtainPollingsCell(sp);// 查询是否配置某个小区			
			flag = buildBlockList(blockList, requestPollingList, blockData);// 根据小区ID获取该小区的轮巡图配置			
				if (!flag) {
				if (cityId != null && !"".equals(cityId.trim())) {
					requestPollingList = iNewPollingSvc.obtainPollingCity(sp);// 查询是否配置整个城市
					flag = buildBlockList(blockList, requestPollingList,
							blockData);// 根据城市ID获取该小区的轮巡图配置
				}
				if (!flag) {
					requestPollingList = iNewPollingSvc
							.obtainPollingCountry(sp);// 查询是否配置全国
					flag = buildBlockList(blockList, requestPollingList,
							blockData);// 获取全国轮巡图配置
					if (!flag) {
						requestPollingList = iNewPollingSvc
								.obtainPollingsDefault(sp);// 查询是否配置默认
						flag = buildBlockList(blockList, requestPollingList,
								blockData);
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
   
	// 确认是否绑定物业
	private void confirmBondProperty(String cellId,
			Map<String, String> mapParam) {
		Map<String, String> paramMap = iNewPollingSvc.selectBoundWuYe(cellId);		
		   //2.判断是否绑定物业 0 未绑定物业  1 已绑定物业
		if (paramMap == null || paramMap.get("CELL_RELATION") == null
				|| "".equals(paramMap.get("CELL_RELATION").trim())
				|| paramMap.get("COMPANY_CODE") == null
				|| "".equals(paramMap.get("COMPANY_CODE").trim())) {
			mapParam.put("bound", "0");
		} else {
			mapParam.put("bound", "1");
		}
	}
   
	// 获取小区人气
	private void obtainCellCount(String cellId, Map<String, String> mapParam) {
		int count = iNewPollingSvc.selectUserCountByCellId(cellId);		
	    Map<String, BigDecimal> longitudeMap = new HashMap<String, BigDecimal>();
	    longitudeMap =iNewPollingSvc.obtainlongitude(cellId);
	    mapParam.put("userCount", count + "");//小区人气
		if (longitudeMap != null) {
			mapParam.put("longitude", longitudeMap.get("LONGITUDE")+"");//经度
			mapParam.put("latitude", longitudeMap.get("LATITUDE")+"");//纬度
		} else {
			mapParam.put("longitude", "124.089");
			mapParam.put("latitude", "34.234");
		}
	}
	
	// 创建默认的超市专场信息
	private void confirmSuperMarket(String cellId,List<PollingRespElement> blockList, String superUrl) {
		PollingRespElement blockChild = new PollingRespElement();
		List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map1 = new HashMap<String, String>();
		map = new HashMap<String, String>();
		map.put("scImg", url + "" + "mth.png");// 图片路径
		map.put("srSort", (blockList.size() + 1) + "");// 内容排序
		map.put("scType", "3");// 内容排序
		map1.put("paramCode", "url");// 参数编码
		map1.put("paramValue",superUrl+"&CELL_ID="+cellId);// 参数值
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("paramCode", "listTitle");// 参数编码
		map2.put("paramValue", "超市专场");// 参数值
		paramsList.add(map1);
		paramsList.add(map2);
		blockChild.setParamData(map);
		blockChild.setParamList(paramsList);
		blockList.add(blockChild);
	}
    /*
	 参数：blockList 存放的是最终需要的轮训图信息 ，只要够4条立即反回	
	*/
	private boolean buildBlockList(List<PollingRespElement> blockList, List<Pollings> pollinglist,Map<String,String> blockData) {
		if (pollinglist != null) {
			List<PollingRespBlock> blockRespList = changeList(pollinglist);
			int size = blockList.size();
			logger.debug("----------------size---------"+size);
			List<PollingRespElement> blockListTemp = null;
			if (blockRespList != null && blockRespList.size() > 0) {
				blockListTemp = blockRespList.get(0).getBlockList();
				if(blockData.get("strategyId")==null) {
					Map<String,String> blockData2 = blockRespList.get(0).getBlockData();
					blockData.put("strategyId", blockData2.get("strategyId"));
					blockData.put("blockStyle", blockData2.get("blockStyle"));
					blockData = blockRespList.get(0).getBlockData();					
				}
				for (int i = 0; i < blockListTemp.size(); i++) {
					Map<String,String> parammap =blockListTemp.get(i).getParamData();
					parammap.put("srSort", (blockList.size()+1)+"");
					blockListTemp.get(i).setParamData(parammap);
					blockList.add(blockListTemp.get(i));
					size++;
					if (size >= 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	// 数据组装
	private List<PollingRespBlock>  changeList(List<Pollings> pollinglist){
		// PollingRespsSubList subResq = null;
		PollingRespBlock respBlock = null;
		List<PollingRespBlock> pollingRespList = null;
		Map<String, String> map = null;
		List<Map<String, String>> paramsList = null;
		List<PollingRespElement> blockList = null;
		PollingRespElement blockChild = null;
		for (int i = 0; i < pollinglist.size(); i++) {
			pollingRespList = new ArrayList<PollingRespBlock>();
			Pollings s = pollinglist.get(i);
			List<PollingBlocks> sbList = s.getPollingBlockList();
			for (int l = 0; l < sbList.size(); l++) {
				respBlock = new PollingRespBlock();
				PollingBlocks strategyBlock = sbList.get(l);
				map = new HashMap<String, String>();
				map.put("blockStyle", strategyBlock.getBlockStyle());// 模块样式
				map.put("strategyId", strategyBlock.getStrategyId());
				respBlock.setBlockData(map);
				List<PollingElements> srlist = strategyBlock
						.getPollingElementList();
				blockList = new ArrayList<PollingRespElement>();
				for (int j = 0; j < srlist.size(); j++) {
					blockChild = new PollingRespElement();
					PollingElements strategyElements = srlist.get(j);
					PollingContents strategyContents = strategyElements
							.getPollingContents();
					map = new HashMap<String, String>();
					map.put("scImg", url + "" + strategyElements.getScImg());// 图片路径
					map.put("srSort", strategyElements.getSrSort());// 内容排序
					map.put("elementId", strategyElements.getSrId());// 图片路径
					if (strategyContents != null
							&& strategyContents.getScType() != null) {
						map.put("scType", strategyContents.getScType());// 内容类型
						map.put("contentId", strategyContents.getScId());// 图片路径
						blockChild.setParamData(map);
						List<PollingParams> strategyParamsList = strategyContents
								.getPollingParamList();
						paramsList = new ArrayList<Map<String, String>>();
						for (int k = 0; k < strategyParamsList.size(); k++) {
							map = new HashMap<String, String>();
							PollingParams strategyParams = strategyParamsList
									.get(k);
							map.put("paramCode", strategyParams.getParamCode());// 参数编码
							map.put("paramValue", strategyParams
									.getParamValue());// 参数值
							paramsList.add(map);
						}
						blockChild.setParamList(paramsList);
						blockList.add(blockChild);
					} else {
						blockChild.setParamData(map);
						blockList.add(blockChild);
					}
				}
				respBlock.setBlockList(blockList);
				pollingRespList.add(respBlock);
			}

		}
		return pollingRespList;
	}
}
