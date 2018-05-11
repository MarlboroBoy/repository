package com.sundata.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.common.base.BaseAction;
import com.sundata.common.util.SettingUtil;

import com.sundata.admin.model.ParamSettingModel;


@Controller
@RequestMapping("/paramSetting")
public class ParamSettingAction extends BaseAction {
	String path = "alarm";
	//设置界面跳转
	@RequestMapping("paramSettingInit")
	public ModelAndView paramSettingInit() {
		Map<String, Object> context = new HashMap<>();
		context.put("workType", SettingUtil.workType);
		context.put("timeOut", SettingUtil.timeOut);
		context.put("resendTimes", SettingUtil.resendTimes);
		context.put("messageId", SettingUtil.messageId);
		context.put("callTimeOut", SettingUtil.callTimeOut);
		context.put("callTimes", SettingUtil.callTimes);
		context.put("callTimeLater", SettingUtil.callTimeLater);
		
		return forword(path + "/paramSetting", context);
	}

	@RequestMapping("setting")
	public void setting(HttpServletResponse response,ParamSettingModel model){
	SettingUtil.workType = model.getWorkType();
	SettingUtil.timeOut=model.getTimeOut();
	SettingUtil.resendTimes=model.getResendTimes();
	SettingUtil.messageId = model.getMessageId();
	SettingUtil.callTimeOut = model.getCallTimeOut();
	SettingUtil.callTimes = model.getCallTimes();
	SettingUtil.callTimeLater = model.getCallTimeLater();
	sendSuccessMessage(response);
	}
}
