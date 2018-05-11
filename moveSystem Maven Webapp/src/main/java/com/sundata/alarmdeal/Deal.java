package com.sundata.alarmdeal;

import java.util.HashMap;
import java.util.Map;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.util.StringUtil;
import com.sundata.alarmdeal.send.SendToUser;
import com.sundata.alarmdeal.service.AlarmDealService;
import com.sundata.alarmdeal.service.CarService;
import com.sundata.common.util.DateUtil;
import com.sundata.common.util.SessionUtil;
import com.sundata.common.util.SettingUtil;
import com.sundata.mobile.model.MobileAlarmModel;


@Service
public class Deal {
@Autowired
private CarService carService;
@Autowired
private AlarmDealService alarmDealService;
	
	public  static Scheduler scheduler;
public String findCarAndState(MobileAlarmModel mobileAlarmModel){
	if(carService.carIsHave(mobileAlarmModel.getLicensePlate())){
	//设置状态为2,呼叫中
		alarmDealService.setState2(mobileAlarmModel.getAlarmSheetID());
			startSchedule(mobileAlarmModel);
			return "发送短信中";
	}else{
		//设置状态为4,人工处置
		alarmDealService.setState4(mobileAlarmModel.getAlarmSheetID());
		return "没有该车辆";
	}
	
}
	
	
	
	
	public static void startSchedule(MobileAlarmModel model) {
        try {
        	Map<String,Object> map =new HashMap<String,Object>();
        	map.put("model", model);
        	JobDataMap map1 =new JobDataMap(map);
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(AlarmDeal.class)
            // 任务执行类
                    .withIdentity(model.getAlarmSheetID()+"job1", model.getAlarmSheetID()+"jGroup1").usingJobData(map1)
                    // 任务名，任务组
                    .build();

//            // 触发器类型
            SimpleScheduleBuilder builder = SimpleScheduleBuilder
            		.simpleSchedule()
            		.withIntervalInSeconds(1)
                    .withRepeatCount(10);
            
            
//           SimpleScheduleBuilder builder = SimpleScheduleBuilder
//                    // 设置执行次数
//                    .repeatSecondlyForTotalCount(5)
//                    .withRepeatCount(5)
//                    .withIntervalInSeconds(10);
//                    ;
            //CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(model.getAlarmSheetID()+"trigger1",model.getAlarmSheetID()+ "tGroup1")
                    .startNow()
                    .withSchedule(builder)
                    .build();

            // 3、创建Scheduler
            scheduler = StdSchedulerFactory.getDefaultScheduler();
           
            // 4、调度执行
          
            //scheduler.deleteJob(JobKey.jobKey("job3", "jGroup3"));
          scheduler.scheduleJob(jobDetail, trigger);
          scheduler.start();
          
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
	public static void startSendToUserSchedule(MobileAlarmModel model) {
        try {
        	Map<String,Object> map =new HashMap<String,Object>();
        	map.put("model", model);
        	JobDataMap map1 =new JobDataMap(map);
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(SendToUser.class)
            // 任务执行类
                    .withIdentity(model.getAlarmSheetID()+"job2", model.getAlarmSheetID()+"jGroup2").usingJobData(map1)
                    // 任务名，任务组
                    .build();

//            // 触发器类型
            SimpleScheduleBuilder builder = SimpleScheduleBuilder
            		.simpleSchedule()
            		.withIntervalInSeconds(Integer.parseInt(SettingUtil.callTimeOut))
                    .withRepeatCount(Integer.parseInt(SettingUtil.callTimes));
            
            
//           SimpleScheduleBuilder builder = SimpleScheduleBuilder
//                    // 设置执行次数
//                    .repeatSecondlyForTotalCount(5)
//                    .withRepeatCount(5)
//                    .withIntervalInSeconds(10);
//                    ;
            //CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(model.getAlarmSheetID()+"trigger2", model.getAlarmSheetID()+"tGroup2")
                    .startAt(DateUtil.getNowLaterTime(Integer.parseInt(SettingUtil.callTimeLater)))
                    .withSchedule(builder)
                    .build();

            // 3、创建Scheduler
            scheduler = StdSchedulerFactory.getDefaultScheduler();
           
            // 4、调度执行
          
            //scheduler.deleteJob(JobKey.jobKey("job3", "jGroup3"));
          scheduler.scheduleJob(jobDetail, trigger);
          scheduler.start();
          
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

	
	
	public static Scheduler getScheduler() {
		return scheduler;
	}

	public static void setScheduler(Scheduler scheduler) {
		Deal.scheduler = scheduler;
	}
}
