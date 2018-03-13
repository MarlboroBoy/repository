package com.sundata.common.util.alarmdeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.common.util.alarmdeal.mapper.AlarmDealMapper;
import com.sundata.common.util.alarmdeal.service.impl.AlarmDealServiceImpl;

public class AlarmDealService implements AlarmDealServiceImpl{

	@Autowired
	private AlarmDealMapper alarmDealMapper;
	
	
	public String queryAlarmState(int alarmSheetID){
	return alarmDealMapper.queryAlarmState(alarmSheetID);
}
	
}
