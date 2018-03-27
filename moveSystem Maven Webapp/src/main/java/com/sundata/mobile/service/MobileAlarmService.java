package com.sundata.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.mapper.AlarmDealMapper;
import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;

import com.sundata.mobile.mapper.MobileAlarmMapper;
import com.sundata.mobile.model.MobileAlarmModel;
@Service
public class MobileAlarmService extends BaseService<MobileAlarmModel> {
	
	@Autowired
	private AlarmDealMapper alarmDealMapper;

	@Autowired
	private MobileAlarmMapper<MobileAlarmModel> mobileAlarmMapper;
	/*
	 * 报警功能
	 * */
	public void alarm(MobileAlarmModel mobileAlarmModel){
		mobileAlarmMapper.alarm(mobileAlarmModel);
		
	}
	/*
	 * 查询状态是正在处理
	 * */
	public List<MobileAlarmModel> queryOnAlarm(MobileAlarmModel mobileAlarmModel){
		
		return mobileAlarmMapper.queryOnAlarm(mobileAlarmModel);
	}
	public List<MobileAlarmModel> alarmHistory(MobileAlarmModel mobileAlarmModel){
		
		return mobileAlarmMapper.queryOnAlarm(mobileAlarmModel);
	}
	
	public MobileAlarmModel queryOneAlarm(MobileAlarmModel mobileAlarmModel){
		return mobileAlarmMapper.queryOneAlarm(mobileAlarmModel);
	}
	
	
	public BaseMapper<MobileAlarmModel> getMapper() {
		return mobileAlarmMapper;
	}
	public void alarmFinish(MobileAlarmModel mobileAlarmModel){
		mobileAlarmMapper.alarmFinish(mobileAlarmModel);
	}
	
	

}
