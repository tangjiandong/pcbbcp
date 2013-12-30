package com.app.transaction.channel.dao;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;

public interface ChannelDao extends BaseDao{

	void saveChannel(EntityBase entity)throws Exception;
	
	void upChannel(EntityBase entity)throws Exception;
	
	Object findChannel(EntityBase entity)throws Exception;
	
	ReturnData getChannelList(EntityBase entity)throws Exception;
}
