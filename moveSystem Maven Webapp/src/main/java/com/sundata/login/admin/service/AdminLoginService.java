package com.sundata.login.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;
import com.sundata.login.admin.mapper.AdminLoginMapper;
import com.sundata.login.admin.model.AdminLoginModel;


@Service
public class AdminLoginService extends BaseService<AdminLoginModel> {

	@Autowired
	private AdminLoginMapper<AdminLoginModel> loginMapper;
	
	
	@Override
	public BaseMapper<AdminLoginModel> getMapper() {
		
		return loginMapper;
	}

	public List<AdminLoginModel> login(AdminLoginModel loginModel){
		
		return loginMapper.login(loginModel);
	}

	
	
}
