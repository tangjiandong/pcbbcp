/**
 * 文件名: UserServiceImpl.java
 * 作者：caiqf
 * 完成日期：2012-12-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.service.BaseServiceImpl;
import com.app.transaction.user.dao.UserDao;
import com.app.transaction.user.service.UserService;

/**
 * Class: UserServiceImpl.java Description: 用户信息Service实现
 * 
 * @author caiqf
 * @date 2012-12-13
 */
@SuppressWarnings("all")
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	/**
	 * 新增用户基本信息
	 */
	@Override
	public void addTTgUserinfo(EntityBase entity) throws Exception {
		this.userDao.addTTgUserinfo(entity);
	}

	/**
	 * 修改用户基本信息
	 */
	@Override
	public void updateTTgUserinfo(EntityBase entity) throws Exception {
		this.userDao.updateTTgUserinfo(entity);
	}

	/**
	 * 删除用户基本信息
	 */
	@Override
	public void deleteTTgUserinfo(EntityBase entity) throws Exception {
		this.userDao.deleteTTgUserinfo(entity);
	}

	/**
	 * 查询用户基本信息
	 */
	@Override
	public Object findTTgUserinfo(EntityBase entity) throws Exception {
		return this.userDao.findTTgUserinfo(entity);
	}

	/**
	 * 查询用户基本信息列表
	 */
	@Override
	public List listTTgUserinfo(EntityBase entity) throws Exception {
		return this.userDao.listTTgUserinfo(entity);
	}

	/**
	 * 查询用户信息分页列表
	 */
	@Override
	public ReturnData listTTgUserinfoPage(EntityBase entity) throws Exception {
		return this.userDao.listTTgUserinfoPage(entity);
	}

	
}
