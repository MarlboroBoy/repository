package com.sundata.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.common.base.BaseAction;
import com.sundata.admin.model.AlarmRecordModel;
import com.sundata.admin.service.AlarmRecordService;

@Controller
@RequestMapping("/alarmRecord")
public class AlarmRecordAction extends BaseAction {
	@Autowired
	private AlarmRecordService alarmRecordService;
	String path = "alarm";

	@RequestMapping("/init")
	public ModelAndView init() {
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("alarm/alarmList", context);
	}
	@RequestMapping("/onAlarmListInit")
	public ModelAndView onAlarmListInit() {
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("alarm/onHandlerAlarmList", context);
	}
//查询正在处理的记录
	@RequestMapping("onAlarmList")
	public void onAlarmList(HttpServletResponse response)
	{
	sendData(response,alarmRecordService.onAlarmList());	
	}
	
	@RequestMapping("manualAlarmInit")
	public ModelAndView manualAlarmInit() {
		Map<String, Object> context = new HashMap<String, Object>();
		return forword("alarm/manualHandlingRecord", context);
	}
	@RequestMapping("manualAlarmList")
	public void manualAlarmList(HttpServletResponse response){
		sendData(response,alarmRecordService.manualAlarmList());
		
	}
	
	
	//查看一条历史记录
	@RequestMapping("alarmDisplay")
	public ModelAndView alarmService(AlarmRecordModel alarmRecordModel) {
		Map<String, Object> context = new HashMap<>();
		context.put("alarmRecordModel", alarmRecordService.alarmDisplay(alarmRecordModel));
		return forword(path + "/alarmTab", context);
	}
	//查询所有历史记录
	@RequestMapping("/alarmList")
	public void alarmList(HttpServletResponse response) {

		sendData(response, alarmRecordService.alarmList());
	}
	//修改处理状态
	@RequestMapping("/changeState")
	public void changeState(HttpServletResponse response,AlarmRecordModel alarmRecordModel){
		alarmRecordService.changeState(alarmRecordModel);
		sendSuccessMessage(response);
	}
	//删除历史
	@RequestMapping("/deleteAlarm")
	public void deleteAlarm(HttpServletResponse response,AlarmRecordModel alarmRecordModel){
		alarmRecordService.deleteAlarm(alarmRecordModel);
		sendSuccessMessage(response);
	}


}
