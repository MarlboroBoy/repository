package com.sundata.common.base;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.common.util.HtmlUtil;


public class BaseAction {

	public final static String SUCCESS = "_success";
	public final static String MSG = "_msg";
	public final static String DATA = "data";
	public final static String LOGOUT_FLAG = "logoutFlag";
	

	/**
	 * 转向指定页面
	 * @param viewName	页面名称，/views/页面名称.jsp为完整名称
	 * @param context	数据Map
	 * @return	ModelAndView
	 */
	public ModelAndView forword(String viewName, Map<String,Object> context) {
		return new ModelAndView(viewName, context);
	}

	/**
	 * 数据转换为JSON格式写入应答
	 * @param response	应答对象
	 * @param data	待返回数据
	 */
	public void sendData(HttpServletResponse response, Object data) {
		HtmlUtil.writeJson(response, data);
	}

	/**
	 * 将标准提示信息转换为JSON格式写入应答
	 * @param response	应答对象
	 */
	public void sendSuccessMessage(HttpServletResponse response) {
		sendSuccessMessage(response, null, null);
	}
	/**
	 * 将应答数据Map及标准提示信息转换为JSON格式写入应答
	 * @param response	应答对象
	 * @param result	应答数据Map
	 */
	public void sendSuccessMessage(HttpServletResponse response, Map<String, Object> result) {
		sendSuccessMessage(response, result, null);
	}
	/**
	 * 将指定提示信息转换为JSON格式写入应答
	 * @param response	应答对象
	 * @param message	提示信息
	 */
	public void sendSuccessMessage(HttpServletResponse response, String msg) {
		sendSuccessMessage(response, null, msg);
	}
	/**
	 * 将应答数据Map及提示信息转换为JSON格式写入应答
	 * @param response	应答对象
	 * @param result	应答数据Map
	 * @param message	提示信息
	 */
	public void sendSuccessMessage(HttpServletResponse response, Map<String, Object> result, String message) {
		if (result == null)
			result = new HashMap<String, Object>();
		if (message == null)
			message = "处理完成！";
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtil.writeJson(response, result);
	}
	
	/**
	 * 将指定信息以原始格式写入应答
	 * @param response	应答对象
	 * @param message	信息
	 */
	public void sendTextMessage(HttpServletResponse response,String msg){
		HtmlUtil.writeHtml(response, msg);
	}

	//统一异常处理方法
	@ExceptionHandler(Exception.class)  
    public void exceptionHandler(Exception ex,HttpServletResponse response,HttpServletRequest request) {
		//String msg = sysLogManageService.insert("", "", ex);

		// 有这句的话ie中会进入error方法
//		response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		sendFailureMessage(response, null);
	}
	private void sendFailureMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		try {
			HtmlUtil.writeJson(response, result);
		} catch (Exception e) {
			HtmlUtil.writeJsonStr(response, "{\""+SUCCESS+"\":false, \""+MSG+"\":\""+message+"\"}");
		}
	}
}
