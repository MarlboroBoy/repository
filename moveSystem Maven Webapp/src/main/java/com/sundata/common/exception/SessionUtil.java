package com.sundata.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.sundata.common.util.ActiveUser;
import com.sundata.common.util.FilterUtil;



/**
 * session操作工具类
 *
 */
public final class SessionUtil {
	
	protected static final Logger logger = Logger.getLogger(SessionUtil.class);
	
	private static final String SESSION_USER = "session_user";
	
	private static final String CANT_BUTTON_MAP = "cantButtonMap"; 		//按钮权限
	
	private static final String CURR_CANT_BUTTON = "currcantbutton"; 	//按钮权限
	
	private static final String DATA_SCOPE = "dataScopeMap"; 		//数据权限
	
	/**
	* 获取request
	* @return
	*/
	public static HttpServletRequest getServletRequest(){
		HttpServletRequest req = FilterUtil.requestthreadLocal.get();
		if (req == null) throw new ServiceException("没有配置FilterUtil");
		return req;
	}
	
	/**
	 * 获取Response
	 * @return
	 */
	public static HttpServletResponse getServletResponse(){
		HttpServletResponse rsp = FilterUtil.responsethreadLocal.get();
		if (rsp == null) throw new ServiceException("没有配置FilterUtil");
		return rsp;
	}
	
	
	
	



	/**
	* 清除session
	*/
	public static void clearSesion(HttpServletRequest request){
		removeAttr(DATA_SCOPE);
		removeAttr(CANT_BUTTON_MAP);
		removeAttr(CURR_CANT_BUTTON);
		removeAttr(SESSION_USER);
	}


    
	/**
	 * 设置session的值
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttr(HttpServletRequest request,String key,Object value){
		request.getSession(true).setAttribute(key, value);
	}
	public static void setAttr(String key,Object value){
		setAttr(getServletRequest(), key, value);
	}

	/**
	 * 获取session的值
	 * @param request
	 * @param key
	 * @param value
	 */
	public static Object getAttr(HttpServletRequest request,String key){
		return request.getSession(true).getAttribute(key);
	}
	public static Object getAttr(String key){
		return getAttr(getServletRequest(), key);
	}

	/**
	 * 删除Session值
	 * @param request
	 * @param key
	 */
	public static void removeAttr(HttpServletRequest request,String key){
		request.getSession(true).removeAttribute(key);
	}
	public static void removeAttr(String key){
		removeAttr(getServletRequest(), key);
	}

	/**
	 * 设置用户信息 到session
	 * @param request
	 * @param user
	 */
	public static void setUser(HttpServletRequest request,ActiveUser user){
		setAttr(SESSION_USER, user);
	}

	/**
	 * 从session中获取用户信息
	 * @param request
	 * @return SysUser
	 */
	public static ActiveUser getUser(HttpServletRequest request){
		return (ActiveUser)getAttr(request, SESSION_USER);
	}
	public static ActiveUser getUser() {
		return (ActiveUser)getAttr(SESSION_USER);
	}

	/**
	 * 从session中删除用户信息
	 * @param request
	 * @return SysUser
	 */
	public static void removeUser(HttpServletRequest request){
		removeAttr(request, SESSION_USER);
	}
	

	

	
}