package com.sundata.alarmdeal.send;

import com.sundata.mobile.model.MobileAlarmModel;

public interface SendMessageToUserImpl {
public String send(MobileAlarmModel model);
public void sendToUser(MobileAlarmModel model);
}
