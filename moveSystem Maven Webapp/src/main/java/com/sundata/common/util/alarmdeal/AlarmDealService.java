package com.sundata.common.util.alarmdeal;

import java.util.TimerTask;

import org.springframework.stereotype.Service;

import com.sundata.common.util.ApplicationContextUtil;
import com.sundata.common.util.alarmdeal.service.impl.AlarmDealServiceImpl;

@Service
public class AlarmDealService extends TimerTask{

	
	
	 int alarmSheetID;

	public AlarmDealService(int alarmSheetID) {
		super();
		this.alarmSheetID = alarmSheetID;
	}


	public static int sendMoveMessage=1;
	SendMessage sendMessage  = new SendMessage();
	
	
	public void run() {	
		AlarmDealServiceImpl alarmDealService = (AlarmDealServiceImpl) ApplicationContextUtil.getBean("alarmDealService");
		
	String AlarmState = ""; 
	//	queryAlarmState(alarmSheetID);
		if(sendMoveMessage<=5||AlarmState.equals("2"))
			try {
				{
					sendMessage.c();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		else
			this.cancel();
		
		sendMoveMessage++;
	}




}
