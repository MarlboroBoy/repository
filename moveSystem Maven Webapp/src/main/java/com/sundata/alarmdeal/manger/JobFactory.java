package com.sundata.alarmdeal.manger;


import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class JobFactory extends SpringBeanJobFactory{
	 @Autowired
	    private AutowireCapableBeanFactory capableBeanFactory;
	    @Override

	    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

	        Object jobInstance = super.createJobInstance(bundle);

	        capableBeanFactory.autowireBean(jobInstance);

	        return jobInstance;

	    }
	 
}
