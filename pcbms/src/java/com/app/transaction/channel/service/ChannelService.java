package com.app.transaction.channel.service;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.service.BaseService;

public interface ChannelService extends BaseService{
	
	void saveChannel(EntityBase entity)throws Exception;
	
	void upChannel(EntityBase entity)throws Exception;
	
	Object findChannel(EntityBase entity)throws Exception;
	
	ReturnData getChannelList(EntityBase entity)throws Exception;
}
