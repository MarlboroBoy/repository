package com.sundata.login.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.common.base.BaseAction;
import com.sundata.common.util.ActiveUser;
import com.sundata.common.util.SessionUtil;
import com.sundata.common.util.StringUtil;
import com.sundata.login.admin.model.AdminLoginModel;
import com.sundata.login.admin.service.AdminLoginService;

@Controller
@RequestMapping("/adminLogin")
public class AdminLoginAction extends BaseAction {
	@Autowired
	private AdminLoginService loginService;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> context = new HashMap<String, Object>();
		ActiveUser user = SessionUtil.getUser(request);
		if(user!=null){
			context.put("user", user);
		return forword("/index", context);
	}return forword("alarm/login", context);
		}

	@RequestMapping("/toLogin")
	public void toLogin(AdminLoginModel model, HttpServletResponse response,HttpServletRequest request) {
		if (loginService.login(model).size() == 0) {
			
			sendSuccessMessage(response, "账号或密码不正确");

		} else {
			ActiveUser user = new ActiveUser();
			user.setAccount(model.getAccount());
			SessionUtil.setUser(request, user);
			sendSuccessMessage(response, "登录成功");
		}
	}

}
