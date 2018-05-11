package com.sundata.alarmdeal.send;


import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.Deal;
import com.sundata.alarmdeal.QuartzManger;
import com.sundata.alarmdeal.service.impl.UserServiceImpl;
import com.sundata.common.util.ServiceAssistant;
import com.sundata.mobile.model.MobileAlarmModel;
@DisallowConcurrentExecution
@Service
public class SendToUser implements Job{
SendMessageToUserImpl sendMessageToUser = (SendMessageToUserImpl) ServiceAssistant.getServiceBean("sendMessageToUser");
QuartzManger qm = new QuartzManger();
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//SendMessage sendMessage  = new SendMessage((String) SessionUtil.getAttr("licensePlate"));
		JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        MobileAlarmModel model = (MobileAlarmModel) dataMap.get("model");
		System.out.println(model.getAlarmSheetID()+"发送给报警人"+key);
		
		if("5".equals(sendMessageToUser.send(model)))
			qm.removeJob(model.getAlarmSheetID()+"job2", model.getAlarmSheetID()+"jGroup2",model.getAlarmSheetID()+ "trigger2", model.getAlarmSheetID()+"tGroup2", Deal.scheduler);
	//qm.shutdownJobs(Deal.scheduler);
		else
			sendMessageToUser.sendToUser(model);
			
		
	}
	
}
