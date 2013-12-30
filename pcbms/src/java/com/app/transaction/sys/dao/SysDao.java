/**
 * @Filename: SysDao.java
 * @Author：caiqf
 * @Date：2013-7-11
 */
package com.app.transaction.sys.dao;

import java.util.List;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;

/**
 * @Class: SysDao.java
 * @Description: 系统信息Dao
 * @Author：caiqf
 * @Date：2013-7-11
 */
@SuppressWarnings("all")
public interface SysDao extends BaseDao {
	/**
	 * 新增角色信息
	 */
	public void addTTgSysRoleinfo(EntityBase entity) throws Exception;

	/**
	 * 修改角色信息
	 */
	public void updateTTgSysRoleinfo(EntityBase entity) throws Exception;

	/**
	 * 删除角色信息
	 */
	public void deleteTTgSysRoleinfo(EntityBase entity) throws Exception;

	/**
	 * 查询角色信息
	 */
	public Object findTTgSysRoleinfo(EntityBase entity) throws Exception;

	/**
	 * 查询角色信息列表
	 */
	public List listTTgSysRoleinfo(EntityBase entity) throws Exception;

	/**
	 * 查询角色信息分页列表
	 */
	public ReturnData listTTgSysRoleinfoPage(EntityBase entity)
			throws Exception;

	/**
	 * 新增角色用户关联信息
	 */
	public void addTTgSysRoleuserRel(EntityBase entity) throws Exception;

	/**
	 * 修改角色用户关联信息
	 */
	public void updateTTgSysRoleuserRel(EntityBase entity) throws Exception;

	/**
	 * 删除角色用户关联信息
	 */
	public void deleteTTgSysRoleuserRel(EntityBase entity) throws Exception;

	/**
	 * 查询角色用户关联信息
	 */
	public Object findTTgSysRoleuserRel(EntityBase entity) throws Exception;

	/**
	 * 查询角色用户关联信息列表
	 */
	public List listTTgSysRoleuserRel(EntityBase entity) throws Exception;

	/**
	 * 新增菜单信息
	 */
	public void addTTgSysMenuinfo(EntityBase entity) throws Exception;

	/**
	 * 修改菜单信息
	 */
	public void updateTTgSysMenuinfo(EntityBase entity) throws Exception;

	/**
	 * 删除菜单信息
	 */
	public void deleteTTgSysMenuinfo(EntityBase entity) throws Exception;

	/**
	 * 查询菜单信息
	 */
	public Object findTTgSysMenuinfo(EntityBase entity) throws Exception;

	/**
	 * 查询菜单信息列表
	 */
	public List listTTgSysMenuinfo(EntityBase entity) throws Exception;

	/**
	 * 查询菜单信息分页列表
	 */
	public ReturnData listTTgSysMenuinfoPage(EntityBase entity)
			throws Exception;

	/**
	 * 新增角色菜单关联信息
	 */
	public void addTTgSysRolemenuRel(EntityBase entity) throws Exception;

	/**
	 * 修改角色菜单关联信息
	 */
	public void updateTTgSysRolemenuRel(EntityBase entity) throws Exception;

	/**
	 * 删除角色菜单关联信息
	 */
	public void deleteTTgSysRolemenuRel(EntityBase entity) throws Exception;

	/**
	 * 查询角色菜单关联信息
	 */
	public Object findTTgSysRolemenuRel(EntityBase entity) throws Exception;

	/**
	 * 查询角色菜单关联信息列表
	 */
	public List listTTgSysRolemenuRel(EntityBase entity) throws Exception;

	/**
	 * 查询不重复的菜单编号信息列表
	 */
	public List listTTgSysRolemenuRelDistinct(EntityBase entity)
			throws Exception;
	
	
	/**
	 * 新增全国省份城市区县信息
	 */
	public void addTWxSysCityinfo(EntityBase entity) throws Exception;

	/**
	 * 修改全国省份城市区县信息
	 */
	public void updateTWxSysCityinfo(EntityBase entity) throws Exception;

	/**
	 * 删除全国省份城市区县信息
	 */
	public void deleteTWxSysCityinfo(EntityBase entity) throws Exception;

	/**
	 * 查询全国省份城市区县信息
	 */
	public Object findTWxSysCityinfo(EntityBase entity) throws Exception;

	/**
	 * 查询全国省份城市区县信息列表
	 */
	public List listTWxSysCityinfo(EntityBase entity) throws Exception;

}
