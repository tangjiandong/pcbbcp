/**
 * 文件名: UserService.java
 * 作者：caiqf
 * 完成日期：2012-12-13
 * 维护人员：
 * 维护日期：
 * 维护原因：
 */
package com.app.transaction.user.service;

import java.util.List;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.service.BaseService;

/**
 * Class: UserService.java Description: 用户信息Service
 * 
 * @author caiqf
 * @date 2012-12-13
 */
@SuppressWarnings("all")
public interface UserService extends BaseService {
	/**
	 * 新增用户信息
	 */
	public void addTTgUserinfo(EntityBase entity) throws Exception;

	/**
	 * 修改用户信息
	 */
	public void updateTTgUserinfo(EntityBase entity) throws Exception;

	/**
	 * 删除用户信息
	 */
	public void deleteTTgUserinfo(EntityBase entity) throws Exception;

	/**
	 * 查询用户信息
	 */
	public Object findTTgUserinfo(EntityBase entity) throws Exception;

	/**
	 * 查询用户信息列表
	 */
	public List listTTgUserinfo(EntityBase entity) throws Exception;

	/**
	 * 查询用户信息分页列表
	 */
	public ReturnData listTTgUserinfoPage(EntityBase entity) throws Exception;
	
}
