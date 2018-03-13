package com.sundata.login.mobile.mapper;

import java.util.List;

import com.sundata.common.base.BaseMapper;
import com.sundata.login.mobile.model.LoginModel;


public interface LoginMapper<T> extends BaseMapper<T> {

	public List<LoginModel> login(LoginModel loginModel);
	//注册
	
	public int register(LoginModel loginModel);
}
