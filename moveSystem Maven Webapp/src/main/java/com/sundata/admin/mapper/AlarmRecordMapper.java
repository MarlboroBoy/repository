package com.sundata.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sundata.common.base.BaseMapper;

@Mapper
public interface AlarmRecordMapper<T> extends BaseMapper<T> {
          
	public List<T> queryAlarmRecordList(T cont);
}
