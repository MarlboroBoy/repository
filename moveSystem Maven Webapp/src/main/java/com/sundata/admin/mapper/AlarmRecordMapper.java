package com.sundata.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sundata.common.base.BaseMapper;

@Mapper
public interface AlarmRecordMapper<T> extends BaseMapper<T> {
          
	public List<T> onAlarmList();
	public List<T> alarmList();
	public void changeState(T cont);
	public T alarmDisplay(T cont);
	public void deleteAlarm(T cont);
	public List<T> manualAlarmList();
}
