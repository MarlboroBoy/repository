package com.sundata.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.admin.mapper.MessageMapper;
import com.sundata.admin.model.MessageModel;
import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;

@Service
public class MessageService extends BaseService<MessageModel> {

	@Autowired
	private MessageMapper<MessageModel> messageMapper;
	public List<MessageModel> getAll(){
		return messageMapper.getAll();
	}
	
	public void changeUse(MessageModel model){
		messageMapper.changeUse(model);
		messageMapper.changeNoUse(model);
		
	}
	
	
	
	
	
	@Override
	public BaseMapper<MessageModel> getMapper() {

		return messageMapper;
	}

	
	
}
