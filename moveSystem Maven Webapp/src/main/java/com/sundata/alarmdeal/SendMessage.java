package com.sundata.alarmdeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.send.Sendtest;
import com.sundata.alarmdeal.service.AlarmDealService;
import com.sundata.common.util.sendsms;
import com.sundata.mobile.model.MobileAlarmModel;

@Service
public class SendMessage implements SendMessageImpl {

	@Autowired
	private AlarmDealService alarmDealService;

	@Override
	public String sendToCar(MobileAlarmModel model) {
	if (sendsms.sendModel(alarmDealService.queryCarTel(model), model.getAlarmSheetID()).equals("2")) {
		//if (Sendtest.sendModel(alarmDealService.queryCarTel(model), model.getAlarmSheetID()).equals("2")) {
		alarmDealService.setState3(model.getAlarmSheetID());
			return "success";
		} else

			return "error";
	}

	public String SendSuccess(MobileAlarmModel model){
		return alarmDealService.sendSuccess(model);
	}
}
