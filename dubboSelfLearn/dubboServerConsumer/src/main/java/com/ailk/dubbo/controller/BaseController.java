package com.ailk.dubbo.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class BaseController {  
	protected Logger logger = Logger.getLogger(this.getClass()); 
	
	protected Logger loginfo = Logger.getLogger("importLogs");
	
	protected String parseRequestData(HttpServletRequest request)
			throws IOException {
		BufferedReader buf = request.getReader();// 创建一个使用指定大小输入缓冲区的缓冲字符输入流
		StringBuffer sb = new StringBuffer();
		String oneLine = null;
		// 从buf中读出字符串拼成完整报文
		while ((oneLine = buf.readLine()) != null) {// 读取一个文本行。
			sb.append(oneLine);
		}
		buf.close();
		String json = sb.toString();
		return json;
	}

}


