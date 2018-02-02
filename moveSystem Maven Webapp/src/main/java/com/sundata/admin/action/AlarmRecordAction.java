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
public class AlarmRecordAction extends BaseAction{
	@Autowired
	private AlarmRecordService alarmRecordService;
	String path="";
	@RequestMapping("/init")
public ModelAndView init(){
	Map<String,Object> context = new HashMap<String,Object>();
	return forword("alarmList", context);
}
	
	
@RequestMapping("/queryAlarmRecordList")
public void AlarmRecordModel(AlarmRecordModel alarmRecordModel,HttpServletResponse response){
		sendData(response, alarmRecordService.queryAlarmRecordList(alarmRecordModel));
	}


@RequestMapping("alarmService")
public ModelAndView alarmService(AlarmRecordModel alarmRecordModel){
	
	Map<String,Object> context = new HashMap<>();
	return forword("alarmListService", context);
	
}



	
}
	

	
	

