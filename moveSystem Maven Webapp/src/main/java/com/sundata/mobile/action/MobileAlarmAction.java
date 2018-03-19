package com.sundata.mobile.action;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sundata.common.base.BaseAction;
import com.sundata.common.util.DateUtil;
import com.sundata.common.util.alarmdeal.AlarmDeal;
import com.sundata.common.util.car.service.CarService;
import com.sundata.mobile.model.MobileAlarmModel;
import com.sundata.mobile.service.MobileAlarmService;
@Controller
@RequestMapping("alarm")
public class MobileAlarmAction  extends BaseAction{
	
	
	@Autowired
	private MobileAlarmService mobileAlarmService;
	@Autowired 
	private AlarmDeal alarmDeal;
	
	@Autowired
	private CarService carService;//查询车辆信息
	
	@RequestMapping("alarm")
	public void alarm(MobileAlarmModel mobileAlarmModel,HttpServletResponse response){
		mobileAlarmModel.setAlarmTime(DateUtil.getCurTime());
		if(carService.carIsHave(mobileAlarmModel.getLicensePlate())){
		mobileAlarmModel.setProcessingState("1");
		mobileAlarmService.alarm(mobileAlarmModel);
		alarmDeal.alarmDeal(mobileAlarmModel);
		}
		else
		{
			mobileAlarmModel.setProcessingState("2");//车辆库无此车,人工处理中
			mobileAlarmService.alarm(mobileAlarmModel);
		}
			
		//发送移车信息的逻辑
		sendSuccessMessage(response);	
	}
	
	@RequestMapping("/queryOnAlarm")
	public void queryOnAlarm(HttpServletResponse response,MobileAlarmModel mobileAlarmModel){
		sendData(response, mobileAlarmService.queryOnAlarm(mobileAlarmModel));
		
	}
	//查看一条报警信息
	@RequestMapping("/queryOneAlarm")
	public void queryOneAlarm(HttpServletResponse response,String alarmSheetId){
		MobileAlarmModel mobileAlarmModel = new MobileAlarmModel();
		mobileAlarmModel.setAlarmSheetID(alarmSheetId);
		sendData(response,mobileAlarmService.queryOneAlarm(mobileAlarmModel));
	}
	
	@RequestMapping("/alarmHistory")
	public void alarmHisttory(HttpServletResponse response,MobileAlarmModel mobileAlarmModel){
		sendData(response, mobileAlarmService.alarmHistory(mobileAlarmModel));
	}
	
	//报警单完成
	@RequestMapping("/alarmFinish")
	public void alarmFinish(HttpServletResponse response,String alarmSheetId){
		MobileAlarmModel mobileAlarmModel = new MobileAlarmModel();
		mobileAlarmModel.setAlarmSheetID(alarmSheetId);
		mobileAlarmService.alarmFinish(mobileAlarmModel);
		sendSuccessMessage(response);
		
	}
	
}
