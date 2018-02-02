package com.sundata.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;

import com.sundata.common.exception.ServiceException;

public class HtmlUtil {

	
private final static Log logger = LogFactory.getLog(HtmlUtil.class);
	
	/**
	 * 应答返回json格式的字符串
	 * @param response
	 * @param jsonStr
	 */
	public static void writeJsonStr(HttpServletResponse response,String jsonStr) {
//		response.setContentType("application/json");
		writeResp(response,jsonStr);
	}
	
	/**
	 * 应答返回输入对象转换成的json格式的字符串
	 * @param response
	 * @param object
	 */
	
	public static void writeJson(HttpServletResponse response,Object object) {
		// 此处不能设置为json，否则ie9会弹出下载窗口，而不是继续处理
//		response.setContentType("application/json");
		writeResp(response,JsonUtil.toJSONString(object));
	}
	
	/**
	 * 应答返回标准的HTML代码
	 * @param response
	 * @param htmlStr
	 */
	public static void writeHtml(HttpServletResponse response,String htmlStr) {
		writeResp(response,htmlStr);
	}

	/**
	 * 转换前台经过编码的参数 如%XX%XX
	 * @param param
	 * @return
	 * 2015-9-22
	 * @Author Magic
	 */
	public static String transURLParam(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ServiceException("不支持字符集UTF-8", e);
		}
	}
	
	private static void writeResp(HttpServletResponse response,String str) {
		try {
			//设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.print(str);
			out.flush();
			out.close();
			logger.debug("response:"+str);
		} catch (IOException e) {
			throw new ServiceException("写入应答对象失败", e);
		}
	} 

}
