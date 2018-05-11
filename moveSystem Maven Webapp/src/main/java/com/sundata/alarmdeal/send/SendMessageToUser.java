package com.sundata.alarmdeal.send;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.service.AlarmDealService;
import com.sundata.alarmdeal.service.UserService;
import com.sundata.common.util.sendsms;
import com.sundata.mobile.model.MobileAlarmModel;
@Service
public class SendMessageToUser  implements SendMessageToUserImpl {

	@Autowired
	private AlarmDealService alarmDealService;
	 @Autowired
	 private UserService userService;


	@Override
	public void sendToUser(MobileAlarmModel model) {
		sendsms.sendModel(alarmDealService.queryUserTel(model), model.getLicensePlate());
		//Sendtest.sendModel(alarmDealService.queryUserTel(model), model.getLicensePlate()).equals("2");
	}
	

	@Override
	public String send(MobileAlarmModel model) {
		return userService.findAlarmState(model);
	}

}
