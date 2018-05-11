package com.sundata.alarmdeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.mapper.AlarmDealMapper;

import com.sundata.alarmdeal.service.impl.UserServiceImpl;
import com.sundata.mobile.model.MobileAlarmModel;
@Service
public class UserService {

	@Autowired
	private AlarmDealMapper<MobileAlarmModel> alarmDealMapper;
	
	public String findAlarmState(MobileAlarmModel model) {
		return alarmDealMapper.findAlarmState(model);
	}

}
