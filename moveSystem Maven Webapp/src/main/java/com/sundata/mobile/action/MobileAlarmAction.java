package com.sundata.mobile.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sundata.alarmdeal.AlarmDeal;
import com.sundata.alarmdeal.Deal;
import com.sundata.alarmdeal.service.CarService;
import com.sundata.common.base.BaseAction;
import com.sundata.common.util.DateUtil;
import com.sundata.common.util.SessionUtil;
import com.sundata.mobile.model.MobileAlarmModel;
import com.sundata.mobile.service.MobileAlarmService;
@Controller
@RequestMapping("alarm")
public class MobileAlarmAction  extends BaseAction{
	
	
	@Autowired
	private MobileAlarmService mobileAlarmService;
	@Autowired 
	private Deal deal;
	
	@Autowired
	private CarService carService;//查询车辆信息
	
	@RequestMapping("alarm")
	public void alarm(MobileAlarmModel mobileAlarmModel,HttpServletResponse response,HttpServletRequest request){
		mobileAlarmModel.setAlarmTime(DateUtil.getCurTime());
		HttpSession session = request.getSession();
		mobileAlarmModel.setProcessingState("1");
		mobileAlarmService.alarm(mobileAlarmModel);
		SessionUtil.setAttr("licensePlate", mobileAlarmModel.getLicensePlate());
		session.setAttribute("licensePlate", mobileAlarmModel.getLicensePlate());
		deal.findCarAndState(mobileAlarmModel);
		
	
			
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
	@RequestMapping("/alarmTest")
	public void alarmTest(HttpServletResponse response){

		//deal.startSchedule();
	}
	
}
