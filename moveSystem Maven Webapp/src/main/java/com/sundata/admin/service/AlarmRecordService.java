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
		// TODO Auto-generated method stub
		return alarmRecordMapper;
	}
	
	
	public List<AlarmRecordModel> queryAlarmRecordList(AlarmRecordModel alarmRecordModel){
		
		return alarmRecordMapper.queryAlarmRecordList(alarmRecordModel);
	}

}
