package com.sundata.common.util.alarmdeal.mapper;


import com.sundata.common.base.BaseMapper;
public interface AlarmDealMapper<T> extends BaseMapper<T>{
public String queryAlarmState();
public String queryAlarmState(int alarmSheetID);
}
