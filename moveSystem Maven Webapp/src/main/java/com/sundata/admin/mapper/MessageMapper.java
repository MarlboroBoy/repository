package com.sundata.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sundata.admin.model.MessageModel;
import com.sundata.common.base.BaseMapper;

@Mapper
public interface MessageMapper<T> extends BaseMapper<T> {
          public List<MessageModel> getAll();
          public void changeNoUse(MessageModel model);
          public void changeUse(MessageModel model);
	
}
