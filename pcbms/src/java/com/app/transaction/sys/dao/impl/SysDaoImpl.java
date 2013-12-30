/**
 * @Filename: SysDaoImpl.java
 * @Author：caiqf
 * @Date：2013-7-11
 */
package com.app.transaction.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
import com.app.transaction.sys.dao.SysDao;

/**
 * @Class: SysDaoImpl.java
 * @Description: 系统信息Dao实现
 * @Author：caiqf
 * @Date：2013-7-11
 */
@SuppressWarnings("all")
@Repository("sysDaoImpl")
public class SysDaoImpl extends BaseDaoImpl implements SysDao {
	/**
	 * 新增角色信息
	 */
	@Override
	public void addTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.insert("TTgSysRoleinfo.insertTTgSysRoleinfoByModel", entity);
	}

	/**
	 * 修改角色信息
	 */
	@Override
	public void updateTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.update("TTgSysRoleinfo.updateTTgSysRoleinfoByModel", entity);
	}

	/**
	 * 删除角色信息
	 */
	@Override
	public void deleteTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.delete("TTgSysRoleinfo.deleteTTgSysRoleinfoByModel", entity);
	}

	/**
	 * 查询角色信息
	 */
	@Override
	public Object findTTgSysRoleinfo(EntityBase entity) throws Exception {
		return this.findByProperty(
				"TTgSysRoleinfo.selectTTgSysRoleinfoByModel", entity);
	}

	/**
	 * 查询角色信息列表
	 */
	@Override
	public List listTTgSysRoleinfo(EntityBase entity) throws Exception {
		return this.listByProperty(
				"TTgSysRoleinfo.selectTTgSysRoleinfoByModel", entity);
	}

	/**
	 * 查询角色信息分页列表
	 */
	public ReturnData listTTgSysRoleinfoPage(EntityBase entity)
			throws Exception {
		return this.listDataPaging(
				"TTgSysRoleinfo.selectTTgSysRoleinfo_list_page", entity);
	}

	/**
	 * 新增角色用户关联信息
	 */
	@Override
	public void addTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.insert("TTgSysRoleuserRel.insertTTgSysRoleuserRelByModel", entity);
	}

	/**
	 * 修改角色用户关联信息
	 */
	@Override
	public void updateTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.update("TTgSysRoleuserRel.updateTTgSysRoleuserRelByModel", entity);
	}

	/**
	 * 删除角色用户关联信息
	 */
	@Override
	public void deleteTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.delete("TTgSysRoleuserRel.deleteTTgSysRoleuserRelByModel", entity);
	}

	/**
	 * 查询角色用户关联信息
	 */
	@Override
	public Object findTTgSysRoleuserRel(EntityBase entity) throws Exception {
		return this.findByProperty(
				"TTgSysRoleuserRel.selectTTgSysRoleuserRelByModel", entity);
	}

	/**
	 * 查询角色用户关联信息列表
	 */
	@Override
	public List listTTgSysRoleuserRel(EntityBase entity) throws Exception {
		return this.listByProperty(
				"TTgSysRoleuserRel.selectTTgSysRoleuserRelByModel", entity);
	}

	/**
	 * 新增菜单信息
	 */
	@Override
	public void addTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.insert("TTgSysMenuinfo.insertTTgSysMenuinfoByModel", entity);
	}

	/**
	 * 修改菜单信息
	 */
	@Override
	public void updateTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.update("TTgSysMenuinfo.updateTTgSysMenuinfoByModel", entity);
	}

	/**
	 * 删除菜单信息
	 */
	@Override
	public void deleteTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.delete("TTgSysMenuinfo.deleteTTgSysMenuinfoByModel", entity);
	}

	/**
	 * 查询菜单信息
	 */
	@Override
	public Object findTTgSysMenuinfo(EntityBase entity) throws Exception {
		return this.findByProperty(
				"TTgSysMenuinfo.selectTTgSysMenuinfoByModel", entity);
	}

	/**
	 * 查询菜单信息列表
	 */
	@Override
	public List listTTgSysMenuinfo(EntityBase entity) throws Exception {
		return this.listByProperty(
				"TTgSysMenuinfo.selectTTgSysMenuinfoByModel", entity);
	}

	/**
	 * 查询菜单信息分页列表
	 */
	public ReturnData listTTgSysMenuinfoPage(EntityBase entity)
			throws Exception {
		return this.listDataPaging(
				"TTgSysMenuinfo.selectTTgSysMenuinfo_list_page", entity);
	}

	/**
	 * 新增角色菜单关联信息
	 */
	@Override
	public void addTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.insert("TTgSysRolemenuRel.insertTTgSysRolemenuRelByModel", entity);
	}

	/**
	 * 修改角色菜单关联信息
	 */
	@Override
	public void updateTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.update("TTgSysRolemenuRel.updateTTgSysRolemenuRelByModel", entity);
	}

	/**
	 * 删除角色菜单关联信息
	 */
	@Override
	public void deleteTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.delete("TTgSysRolemenuRel.deleteTTgSysRolemenuRelByModel", entity);
	}

	/**
	 * 查询角色菜单关联信息
	 */
	@Override
	public Object findTTgSysRolemenuRel(EntityBase entity) throws Exception {
		return this.findByProperty(
				"TTgSysRolemenuRel.selectTTgSysRolemenuRelByModel", entity);
	}

	/**
	 * 查询角色菜单关联信息列表
	 */
	@Override
	public List listTTgSysRolemenuRel(EntityBase entity) throws Exception {
		return this.listByProperty(
				"TTgSysRolemenuRel.selectTTgSysRolemenuRelByModel", entity);
	}

	/**
	 * 查询不重复的菜单编号信息列表
	 */
	@Override
	public List listTTgSysRolemenuRelDistinct(EntityBase entity)
			throws Exception {
		return this.listByProperty(
				"TTgSysRolemenuRel.selectTTgSysRolemenuRelByModel_distinct",
				entity);
	}
	
	/**
	 * 新增全国省份城市区县信息
	 */
	public void addTWxSysCityinfo(EntityBase entity) throws Exception {
		this.insert("TWxSysCityinfo.insertTWxSysCityinfoByModel", entity);
	}

	/**
	 * 修改全国省份城市区县信息
	 */
	public void updateTWxSysCityinfo(EntityBase entity) throws Exception {
		this.update("TWxSysCityinfo.updateTWxSysCityinfoByModel", entity);
	}

	/**
	 * 删除全国省份城市区县信息
	 */
	public void deleteTWxSysCityinfo(EntityBase entity) throws Exception {
		this.delete("TWxSysCityinfo.deleteTWxSysCityinfoByModel", entity);
	}

	/**
	 * 查询全国省份城市区县信息
	 */
	public Object findTWxSysCityinfo(EntityBase entity) throws Exception {
		return this.findByProperty(
				"TWxSysCityinfo.selectTWxSysCityinfoByModel", entity);
	}

	/**
	 * 查询全国省份城市区县信息列表
	 */
	public List listTWxSysCityinfo(EntityBase entity) throws Exception {
		return this.listByProperty(
				"TWxSysCityinfo.selectTWxSysCityinfoByModel", entity);
	}

}
