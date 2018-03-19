package com.sundata.login.mobile.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sundata.common.base.BaseAction;
import com.sundata.common.util.DateUtil;
import com.sundata.login.mobile.model.LoginModel;
import com.sundata.login.mobile.service.LoginService;

@Controller
@RequestMapping("/mobileLogin")
public class LoginAction extends BaseAction {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public void login(LoginModel loginModel, HttpServletResponse response) {
		System.out.println(loginModel);
		Map<String, Object> result = new HashMap<String, Object>();
		if (loginService.login(loginModel).size() == 0) {
			result.put("rtn", 1);
			sendSuccessMessage(response, result);
		} else {
			result.put("rtn", 0);
			result.put("userName", loginModel.getName());
			result.put("account", loginModel.getAccount());
			result.put("token", true);
			sendSuccessMessage(response, result);
		}
	}

	@RequestMapping("/register")
	public void register(LoginModel loginModel, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		loginModel.setUptime(DateUtil.getCurTime());
		loginModel.setSex("1");
		loginService.register(loginModel);
		result.put("rtn", "0");
		result.put("account", loginModel.getAccount());
		sendSuccessMessage(response, result);
	}
	
	@RequestMapping("/userInfo")
	public void userInfo(HttpServletResponse response,LoginModel loginModel){
		sendData(response, loginService.userInfo(loginModel));
	}
	//修改密码
	@RequestMapping("/modifyPassword")
	public void modifyPassword(HttpServletResponse response,String account,String oldPassword,String newPassword){
		LoginModel loginModel = new LoginModel();
		loginModel.setAccount(account);
		loginModel.setPassword(oldPassword);
		Map<String, Object> result = new HashMap<String, Object>();
		if (loginService.login(loginModel).size() == 0) {
			result.put("msg", "密码不正确");
			sendSuccessMessage(response, result);
		} else {
			loginModel.setPassword(newPassword);
			loginService.modifyPassword(loginModel);
			result.put("msg", "密码修改成功");
			result.put("token", true);
			sendSuccessMessage(response, result);
		}
		
	}

}
