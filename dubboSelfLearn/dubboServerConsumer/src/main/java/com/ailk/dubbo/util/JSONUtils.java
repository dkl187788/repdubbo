package com.ailk.dubbo.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


import com.ailk.dubbo.bean.base.Body;
import com.ailk.dubbo.bean.base.Head;
import com.ailk.dubbo.bean.base.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {
	
	protected static Logger logger = Logger.getLogger(JSONUtils.class); 
	
	public static final String EMPTY = "";
	public static final String EMPTY_JSON = "{}";
	public static final String EMPTY_JSON_ARRAY = "[]";
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonString2List(String jsonString, Class<T> clazz)throws Exception {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Object[] array = (Object[])JSONArray.toArray(jsonArray, clazz);
		List<T> list = (List<T>) Arrays.asList(array);
		return list;
    }	
	
	/**
	 * 
	 * @param target
	 *            目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @param isSerializeNulls
	 *            是否序列化NULL值字段。
	 * @param isSerializeDate
	 *            是否需要序列号日期
	 * @param datePattern
	 *            日期字段的格式化模式
	 * @param isResultArrays
	 *            是否返回数组
	 * @return 目标对象的JSON格式的字符串
	 */
	public static String toJson(Object target, Type targetType, boolean isSerializeNulls, boolean isSerializeDate, String datePattern, boolean isResultArrays) {
		if (target == null) {
			if (isResultArrays) {
				return EMPTY_JSON_ARRAY;
			} else {
				return EMPTY_JSON;
			}
		}

		GsonBuilder builder = new GsonBuilder();
		if (isSerializeNulls) {
			builder.serializeNulls();
		}

		if (isSerializeDate) {
			if (isEmpty(datePattern)) {
				// 日期格式模式为空，采用默认
				datePattern = DEFAULT_DATE_PATTERN;
			}
			builder.setDateFormat(datePattern);
		}
		String result = EMPTY;
		Gson gson = builder.create();
		try {
			if (targetType != null) {
				result = gson.toJson(target, targetType);
			} else {
				result = gson.toJson(target);
			}
		} catch (Exception ex) {
			if (isResultArrays || target instanceof Collection || target instanceof Iterator || target instanceof Enumeration || target.getClass().isArray()) {
				result = EMPTY_JSON_ARRAY;
			} else {
				result = EMPTY_JSON;
			}
		}
		return result;
	}

	/**
	 * Gson将List对象转成JSON文本
	 * 
	 * @param list
	 * @return
	 */
	public static String list2jsonForDate(List<?> list) {
		return toJson(list, null, true, true, null, true);

	}

	/**
	 * Gson将List对象转成JSON文本
	 * 
	 * @param list
	 * @return
	 */
	public static String list2json(List<?> list) {
		return toJson(list, null, false, false, null, false);

	}
	
	/**
	 * Gson将Object对象转成JSON文本
	 * 
	 * @param obj
	 * @return
	 */
	public static String obj2json(Object obj) {
		return toJson(obj, null, false, false, null, false);
	}

	/**
	 * Gson将List对象转成JSON文本，包含总数
	 * 
	 * @param count
	 * @param list
	 * @return
	 */
	public static String applist2jsonForPage(Long count, List<?> list) {
		String result = toJson(list, null, false, false, null, false);
		return "{\"totalCount\":\"" + count + "\", \"root\":" + result + "}";

	}

	
	/**
	 * Gson将List对象转成JSON文本
	 * 
	 * @param list
	 * @return
	 */
	public static String applist2json(List<?> list) {
		return toJson(list, null, false, false, null, false);

	}
	
	/**
	 * Gson将Object对象转成JSON文本
	 * 
	 * @param obj
	 * @return
	 */
	public static String appobj2json(Object obj) {
		return toJson(obj, null, false, false, null, false);
	}
	
	
	/**
	 * 将List对象序列化为JSON文本
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> String toJSONString(List<T> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	/**
	 * 将对象序列化为JSON文本
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	/**
	 * 将对象串转换为List对象
	 * 
	 * @param jsonstr
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List toArrayList(String jsonstr) throws JSONException {
		List arrayList = new ArrayList();
		JSONArray jsonArray = new JSONArray().element(jsonstr);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			Iterator keys = jsonObject.keys();
			Map map = new HashMap();
			while (keys.hasNext()) {
				Object key = keys.next();
				Object value = jsonObject.get(String.valueOf(key));
				if (value == null || "null".equals(value.toString())) {
					map.put(key, "");
				} else {
					map.put(key, value);
				}
			}
			arrayList.add(map);
		}
		return arrayList;
	}

	public static boolean isEmpty(String inStr) {
		boolean reTag = false;
		if (inStr == null || "".equals(inStr)) {
			reTag = true;
		}
		return reTag;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void success(HttpServletResponse response,Object data , List list, String action) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,"0","OK!"));
		if (data == null) {
			data = new HashMap();
		}
        Gson gson = new Gson();
        resp.setBody(new Body(data,list));
        logger.info("---JSON:" + gson.toJson(resp).toLowerCase());
       // logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp).toLowerCase()));
		response.getWriter().write(gson.toJson(resp).toLowerCase());
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void successOTO(HttpServletResponse response,Object data , List list, String action) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,"0","OK!"));
		if (data == null) {
			data = new HashMap();
		}
        Gson gson = new Gson();
        resp.setBody(new Body(data,list));
        logger.info("---JSON:" + gson.toJson(resp));
       // logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp)));
		response.getWriter().write(gson.toJson(resp));
	}
	public static void failed(HttpServletResponse response,String errorCode,String msg, String action) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,errorCode,msg));
        Gson gson = new Gson();
        logger.info("---JSON:" + gson.toJson(resp).toLowerCase());
      //  logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp).toLowerCase()));
		response.getWriter().write(gson.toJson(resp).toLowerCase());
	}
	
	@SuppressWarnings("rawtypes")
	public static void successNewVersion(HttpServletResponse response,Object data , List list, String action) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,"0","OK!"));
		if (data == null) {
			data = new HashMap();
		}
		if(list==null){
			list = new ArrayList();
		}
        Gson gson = new Gson();
        resp.setBody(new Body(data,list));
        logger.info("---JSON:" + gson.toJson(resp));
       // logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp)));
		response.getWriter().write(gson.toJson(resp));
	}
	
	public static void failedNewVersion(HttpServletResponse response,String errorCode,String msg, String action) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,errorCode,msg));
        Gson gson = new Gson();
        logger.info("---JSON:" + gson.toJson(resp));
       // logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp)));
		response.getWriter().write(gson.toJson(resp));
	}
	
	@SuppressWarnings("rawtypes")
	public static void successNew(HttpServletResponse response,Object data , List list, String action,String code) throws IOException{
		Response resp = new Response();
		resp.setHead(new Head(action,"0","OK!"));
		if (data == null) {
			data = new HashMap();
		}
		
        Gson gson = new Gson();
        resp.setBody(new Body(data,list));
        logger.info("---JSON:" + gson.toJson(resp));
        // logger.info("---XML:" + XmlJSON.json2XML(gson.toJson(resp)));
		response.getWriter().write(gson.toJson(resp));
	}
}
