package com.sundata.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.admin.mapper.AlarmRecordMapper;
import com.sundata.admin.model.AlarmRecordModel;
import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;

@Service
public class AlarmRecordService extends BaseService<AlarmRecordModel> {

	@Autowired
	private AlarmRecordMapper<AlarmRecordModel> alarmRecordMapper;

	@Override
	public BaseMapper<AlarmRecordModel> getMapper() {
		
		return alarmRecordMapper;
	}


	public List<AlarmRecordModel> alarmList() {

		return alarmRecordMapper.alarmList();
	}
	
	public void changeState(AlarmRecordModel alarmRecordModel){
		
		alarmRecordMapper.changeState(alarmRecordModel);
	}

	
	//查看
	public AlarmRecordModel alarmDisplay(AlarmRecordModel alarmRecordModel){
		return alarmRecordMapper.alarmDisplay(alarmRecordModel);
	}
	//删除
	public void deleteAlarm(AlarmRecordModel alarmRecordModel){
		
		alarmRecordMapper.deleteAlarm(alarmRecordModel);
	}
	public List<AlarmRecordModel> onAlarmList(){
		
		return alarmRecordMapper.onAlarmList();
	}
	public List<AlarmRecordModel> manualAlarmList(){
		
		return alarmRecordMapper.manualAlarmList();
	}
	
}
