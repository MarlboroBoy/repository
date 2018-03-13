package com.sundata.mobile.mapper;



import java.util.List;

import com.sundata.common.base.BaseMapper;
import com.sundata.mobile.model.MobileAlarmModel;
public interface MobileAlarmMapper<T> extends BaseMapper<T>{
	
	public void alarm(MobileAlarmModel mobileAlarmModel);
	public List<MobileAlarmModel> quertOnAlarm(MobileAlarmModel mobileAlarmModel);
}
