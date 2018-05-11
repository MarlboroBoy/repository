package com.sundata.login.admin.mapper;

import java.util.List;

import com.sundata.common.base.BaseMapper;
import com.sundata.login.admin.model.AdminLoginModel;


public interface AdminLoginMapper<T> extends BaseMapper<T> {

	public List<AdminLoginModel> login(AdminLoginModel loginModel);
	//注册
}
