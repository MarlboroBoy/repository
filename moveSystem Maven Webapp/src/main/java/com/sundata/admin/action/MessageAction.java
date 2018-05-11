package com.sundata.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.common.base.BaseAction;
import com.sundata.common.util.SettingUtil;
import com.sundata.admin.model.AlarmRecordModel;
import com.sundata.admin.model.MessageModel;
import com.sundata.admin.model.ParamSettingModel;
import com.sundata.admin.service.AlarmRecordService;
import com.sundata.admin.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageAction extends BaseAction {
	String path = "alarm";
	//设置界面跳转
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/init")
	public ModelAndView paramSettingInit() {
		Map<String, Object> context = new HashMap<>();
	
		return forword(path + "/messageModel", context);
	}
	@RequestMapping("/getAll")
	public void getAll(HttpServletResponse response){
		
		sendData(response,messageService.getAll());
	}
	
	
	@RequestMapping("/changeUse")
public void changeUse(HttpServletResponse response,MessageModel model){
		messageService.changeUse(model);
		sendSuccessMessage(response);
	}
	
}
