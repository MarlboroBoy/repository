package com.sundata.mobile.action;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sundata.common.base.BaseAction;
import com.sundata.common.util.DateUtil;
import com.sundata.common.util.alarmdeal.AlarmDeal;
import com.sundata.mobile.model.MobileAlarmModel;
import com.sundata.mobile.service.MobileAlarmService;
@Controller
@RequestMapping("alarm")
public class MobileAlarmAction  extends BaseAction{
	
	
	@Autowired
	private MobileAlarmService mobileAlarmService;
	@Autowired 
	private AlarmDeal alarmDeal;
	@RequestMapping("alarm")
	public void alarm(MobileAlarmModel mobileAlarmModel,HttpServletResponse response){
		mobileAlarmModel.setAlarmTime(DateUtil.getCurTime());
		mobileAlarmModel.setProcessingState("1");
		
		mobileAlarmService.alarm(mobileAlarmModel);
		//发送移车信息的逻辑
		alarmDeal.alarmDeal(mobileAlarmModel);
		sendSuccessMessage(response);	
	}
	
	@RequestMapping("/queryOnAlarm")
	public void queryOnAlarm(HttpServletResponse response,MobileAlarmModel mobileAlarmModel){
		mobileAlarmModel.setUserid("1001");
		sendData(response, mobileAlarmService.queryOnAlarm(mobileAlarmModel));
		
	}
	
	
}
