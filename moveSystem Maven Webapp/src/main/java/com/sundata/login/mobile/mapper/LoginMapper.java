package com.sundata.login.mobile.mapper;

import java.util.List;

import com.sundata.common.base.BaseMapper;
import com.sundata.login.mobile.model.LoginModel;


public interface LoginMapper<T> extends BaseMapper<T> {

	public List<LoginModel> login(LoginModel loginModel);
	//注册
	
	public int register(LoginModel loginModel);
	
	//查看用户信息
	
	public LoginModel userInfo(LoginModel loginModel);
	
	public void modifyPassword(LoginModel loginModel);
}
