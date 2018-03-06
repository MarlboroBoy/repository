package com.sundata.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http请求、应答获取工具，不需要开发人员直接调用，只需要在web.xml中注册为filter并映射到*.do
 *
 */
public class FilterUtil implements Filter {

	public static ThreadLocal<HttpServletRequest> requestthreadLocal = new ThreadLocal<HttpServletRequest>();
	
	public static ThreadLocal<HttpServletResponse> responsethreadLocal = new ThreadLocal<HttpServletResponse>();
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//保存request
		requestthreadLocal.set((HttpServletRequest)request);
		responsethreadLocal.set((HttpServletResponse)response);
		chain.doFilter(request, response);
	}
	
	

	public void init(FilterConfig filterConfig) {
	}

}
