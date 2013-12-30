/**
 * 文件名: UserDaoImpl.java
 * 作者：caiqf
 * 完成日期：2012-12-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
import com.app.transaction.user.dao.UserDao;

/**
 * Class: UserDaoImpl.java Description: 用户信息Dao实现
 * 
 * @author caiqf
 * @date 2012-12-13
 */
@SuppressWarnings("all")
@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	/**
	 * 新增用户信息
	 */
	@Override
	public void addTTgUserinfo(EntityBase entity) throws Exception {
		this.insert("TTgUserinfo.insertTTgUserinfoByModel", entity);
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public void updateTTgUserinfo(EntityBase entity) throws Exception {
		this.update("TTgUserinfo.updateTTgUserinfoByModel", entity);
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public void deleteTTgUserinfo(EntityBase entity) throws Exception {
		this.delete("TTgUserinfo.deleteTTgUserinfoByModel", entity);
	}

	/**
	 * 查询用户信息
	 */
	@Override
	public Object findTTgUserinfo(EntityBase entity) throws Exception {
		return this.findByProperty("TTgUserinfo.selectTTgUserinfoByModel",
				entity);
	}

	/**
	 * 查询用户信息列表
	 */
	@Override
	public List listTTgUserinfo(EntityBase entity) throws Exception {
		return this.listByProperty("TTgUserinfo.selectTTgUserinfoByModel",
				entity);
	}

	/**
	 * 
	 * 查询用户信息分页列表
	 */
	@Override
	public ReturnData listTTgUserinfoPage(EntityBase entity) throws Exception {
		return this.listDataPaging("TTgUserinfo.selectTTgUserinfo_list_page",
				entity);
	}

}
