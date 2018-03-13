package com.sundata.common.util.alarmdeal;

import java.util.Timer;
import org.springframework.stereotype.Service;

import com.sundata.common.util.SettingUtil;
import com.sundata.mobile.model.MobileAlarmModel;
@Service
public class AlarmDeal {
	
	
	public void alarmDeal(MobileAlarmModel mobileAlarmModel){
		Timer timer = new Timer();
		AlarmDealService alarmDealService = new AlarmDealService(Integer.parseInt(mobileAlarmModel.getAlarmSheetID()));
	//AlarmDealService alarmDealService = new AlarmDealService(11);
	//alarmDealService.setAlarmSheetID();
	timer.scheduleAtFixedRate(alarmDealService, 0, SettingUtil.time);
	}
	
}
