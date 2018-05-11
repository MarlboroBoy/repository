package com.sundata.alarmdeal;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.sundata.common.util.ServiceAssistant;
import com.sundata.mobile.model.MobileAlarmModel;
@DisallowConcurrentExecution
@Service
public class AlarmDeal implements Job {
	SendMessageImpl sendMessage = (SendMessageImpl) ServiceAssistant.getServiceBean("sendMessage");

	QuartzManger qm = new QuartzManger();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {	
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		MobileAlarmModel model = (MobileAlarmModel) dataMap.get("model");
		System.out.println("111111111111111"+sendMessage.sendToCar(model));
		if ("1".equals(sendMessage.SendSuccess(model))) {
			// qm.shutdownJobs(Deal.scheduler);
			qm.removeJob(model.getAlarmSheetID()+"job1", model.getAlarmSheetID()+"jGroup1",model.getAlarmSheetID()+ "trigger1", model.getAlarmSheetID()+"tGroup1", Deal.scheduler);
			// 新增一个 给移车人发送的循环
			Deal.startSendToUserSchedule(model);
		}else
			sendMessage.sendToCar(model);
	}

}
