package com.sundata.alarmdeal.mapper;


import com.sundata.common.base.BaseMapper;
import com.sundata.mobile.model.MobileAlarmModel;
public interface AlarmDealMapper<T> extends BaseMapper<T>{

	public String findAlarmState(T cont);
	public void setState2(String alarmSheetId);
	public void setState3(String alarmSheetId);
	public void setState4(String alarmSheetId);
	public void setState5(String alarmSheetId);
	public String queryUserTel(MobileAlarmModel model);
	public String queryCarTel(MobileAlarmModel model);
	public String sendSuccess(MobileAlarmModel model);
	}
