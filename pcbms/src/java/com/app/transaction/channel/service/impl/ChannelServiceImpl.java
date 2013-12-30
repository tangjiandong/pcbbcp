package com.app.transaction.channel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.channel.dao.ChannelDao;
import com.app.transaction.channel.service.ChannelService;
import com.app.transaction.common.impl.service.BaseServiceImpl;
@Service("channelServiceImpl")
public class ChannelServiceImpl extends BaseServiceImpl implements ChannelService{

	@Resource
	private ChannelDao channelDao;
	@Override
	public Object findChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		return this.channelDao.findChannel(entity);
	}

	@Override
	public ReturnData getChannelList(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		return this.channelDao.getChannelList(entity);
	}

	@Override
	public void saveChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		this.channelDao.saveChannel(entity);
	}

	@Override
	public void upChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		this.channelDao.upChannel(entity);
	}

}
