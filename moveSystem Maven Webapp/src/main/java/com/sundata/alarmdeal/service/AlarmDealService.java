package com.sundata.alarmdeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.mapper.AlarmDealMapper;
import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;
import com.sundata.common.util.SessionUtil;
import com.sundata.mobile.model.MobileAlarmModel;


@Service
public class AlarmDealService extends BaseService<MobileAlarmModel>{

	@Autowired
	private AlarmDealMapper<MobileAlarmModel> alarmDealMapper;
	public void setState2(String alarmSheetId){
		alarmDealMapper.setState2(alarmSheetId);
	}
	
	public void setState3(String alarmSheetId){
		alarmDealMapper.setState3(alarmSheetId);
	}
	
	public void setState4(String alarmSheetId){
		alarmDealMapper.setState4(alarmSheetId);
	}
	public void setStat5(String alarmSheetId){
		alarmDealMapper.setState5(alarmSheetId);
	}
	
	public String queryUserTel(MobileAlarmModel model){
		return alarmDealMapper.queryUserTel(model);
	}
	public String queryCarTel(MobileAlarmModel model){
		return alarmDealMapper.queryCarTel(model);
	}
	
	public String sendSuccess(MobileAlarmModel model){
		
		return alarmDealMapper.sendSuccess(model);
	}
	
	
	@Override
	public BaseMapper<MobileAlarmModel> getMapper() {
		return alarmDealMapper;
	}

	

	
	
}
