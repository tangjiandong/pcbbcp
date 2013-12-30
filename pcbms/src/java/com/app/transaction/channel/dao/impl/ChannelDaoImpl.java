package com.app.transaction.channel.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.channel.dao.ChannelDao;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
@Repository("channelDaoImpl")
public class ChannelDaoImpl extends BaseDaoImpl implements ChannelDao{

	@Override
	public Object findChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		return this.findByProperty("TTgChannelInfo.findTTgChannelInfoByModel", entity);
	}

	@Override
	public ReturnData getChannelList(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		return this.listDataPaging("TTgChannelInfo.selectTTgChannelInfoByModel", entity);
	}

	@Override
	public void saveChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		this.insert("TTgChannelInfo.insertTTgChannelInfoByModel", entity);
	}

	@Override
	public void upChannel(EntityBase entity) throws Exception {
		// TODO Auto-generated method stub
		this.update("TTgChannelInfo.updateTTgChannelInfoByModel", entity);
	}

}
