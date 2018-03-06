package com.sundata.login.mobile.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sundata.common.base.BaseAction;
import com.sundata.login.mobile.model.LoginModel;
import com.sundata.login.mobile.service.LoginService;
@Controller
@RequestMapping("/mobileLogin")
public class LoginAction extends BaseAction {
	@Autowired
	private LoginService loginService;
	
	

	@RequestMapping("/login")
	public void login(LoginModel loginModel,HttpServletResponse response){
	System.out.println(loginModel);
	Map<String,Object> result = new HashMap<String,Object>();
	if(loginService.login(loginModel).size()==0)
	{
	result.put("rtn", 1);
	sendSuccessMessage(response, result);
	}
	else{
		result.put("rtn", 0);
		result.put("userName", loginModel.getName());
		result.put("account", loginModel.getAccount());
		result.put("token", true);
		sendSuccessMessage(response,result);
	}
	}
	@RequestMapping("/register")
	public void register(LoginModel loginModel){
		Map<String,Object> result = new HashMap<String,Object>();
		System.out.println(loginModel);
	}
	
}
