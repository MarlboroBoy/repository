package com.sundata.common.util.alarmdeal;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.common.util.SettingUtil;
import com.sundata.common.util.car.service.CarService;
import com.sundata.mobile.model.MobileAlarmModel;
@Service
public class AlarmDeal {
	
	
	public void alarmDeal(MobileAlarmModel mobileAlarmModel){
		Timer timer = new Timer();
		AlarmDealService alarmDealService = new AlarmDealService(Integer.parseInt(mobileAlarmModel.getAlarmSheetID()));
	timer.scheduleAtFixedRate(alarmDealService, 0, SettingUtil.time);
	}
	
}
