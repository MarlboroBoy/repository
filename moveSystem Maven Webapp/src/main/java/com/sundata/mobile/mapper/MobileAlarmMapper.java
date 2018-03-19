package com.sundata.mobile.mapper;



import java.util.List;

import com.sundata.common.base.BaseMapper;
import com.sundata.mobile.model.MobileAlarmModel;
public interface MobileAlarmMapper<T> extends BaseMapper<T>{
	
	public void alarm(MobileAlarmModel mobileAlarmModel);
	public List<MobileAlarmModel> queryOnAlarm(MobileAlarmModel mobileAlarmModel);
	public MobileAlarmModel queryOneAlarm(MobileAlarmModel mobileAlarmModel);
	public List<MobileAlarmModel> alarmHistory(MobileAlarmModel mobileAlarmModel);
	public void alarmFinish(MobileAlarmModel mobileAlarmModel);
}
