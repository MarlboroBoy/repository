package com.sundata.login.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;
import com.sundata.login.mobile.mapper.LoginMapper;
import com.sundata.login.mobile.model.LoginModel;
@Service
public class LoginService extends BaseService<LoginModel> {

	@Autowired
	private LoginMapper<LoginModel> loginMapper;
	
	
	@Override
	public BaseMapper<LoginModel> getMapper() {
		
		return loginMapper;
	}

	public List<LoginModel> login(LoginModel loginModel){
		
		System.out.println("3");
		return loginMapper.login(loginModel);
		
	}
	
}
