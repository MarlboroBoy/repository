package com.sundata.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.admin.model.AlarmRecordModel;
import com.sundata.common.base.BaseAction;

@Controller
@RequestMapping("/test")
public class ActionTest extends BaseAction {
	
@RequestMapping("/hello")
public void hello(HttpServletResponse response){
	sendSuccessMessage(response);
	sendData(response, "213");
	System.out.println("hello");
}

@RequestMapping("/queryAlarmRecordList")
public void AlarmRecordModel(AlarmRecordModel alarmRecordModel,HttpServletResponse response){
		sendData(response, "");
	}
@RequestMapping("test1")
public ModelAndView test1(){
	Map<String,Object> con = new HashMap<>();
	  ModelAndView mv = new ModelAndView();  
      mv.setViewName("html500"); 
return mv;
}


}
