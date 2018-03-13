package com.sundata.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = paramApplicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	   public static Object getBean(String beanName) {
	        return applicationContext.getBean(beanName);
	    }
	

}
