/**
 * @Filename: SysServiceImpl.java
 * @Author：caiqf
 * @Date：2013-7-11
 */
package com.app.transaction.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
import com.app.transaction.sys.dao.SysDao;
import com.app.transaction.sys.service.SysService;

/**
 * @Class: SysServiceImpl.java
 * @Description: 系统信息Service实现
 * @Author：caiqf
 * @Date：2013-7-11
 */
@SuppressWarnings("all")
@Service("sysServiceImpl")
public class SysServiceImpl extends BaseDaoImpl implements SysService {
	@Resource
	private SysDao sysDao;

	/**
	 * 新增角色信息
	 */
	@Override
	public void addTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.sysDao.addTTgSysRoleinfo(entity);
	}

	/**
	 * 修改角色信息
	 */
	@Override
	public void updateTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.sysDao.updateTTgSysRoleinfo(entity);
	}

	/**
	 * 删除角色信息
	 */
	@Override
	public void deleteTTgSysRoleinfo(EntityBase entity) throws Exception {
		this.sysDao.deleteTTgSysRoleinfo(entity);
	}

	/**
	 * 查询角色信息
	 */
	@Override
	public Object findTTgSysRoleinfo(EntityBase entity) throws Exception {
		return this.sysDao.findTTgSysRoleinfo(entity);
	}

	/**
	 * 查询角色信息列表
	 */
	@Override
	public List listTTgSysRoleinfo(EntityBase entity) throws Exception {
		return this.sysDao.listTTgSysRoleinfo(entity);
	}

	/**
	 * 查询角色信息分页列表
	 */
	public ReturnData listTTgSysRoleinfoPage(EntityBase entity)
			throws Exception {
		return this.sysDao.listTTgSysRoleinfoPage(entity);
	}

	/**
	 * 新增角色用户关联信息
	 */
	@Override
	public void addTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.sysDao.addTTgSysRoleuserRel(entity);
	}

	/**
	 * 修改角色用户关联信息
	 */
	@Override
	public void updateTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.sysDao.updateTTgSysRoleuserRel(entity);
	}

	/**
	 * 删除角色用户关联信息
	 */
	@Override
	public void deleteTTgSysRoleuserRel(EntityBase entity) throws Exception {
		this.sysDao.deleteTTgSysRoleuserRel(entity);
	}

	/**
	 * 查询角色用户关联信息
	 */
	@Override
	public Object findTTgSysRoleuserRel(EntityBase entity) throws Exception {
		return this.sysDao.findTTgSysRoleuserRel(entity);
	}

	/**
	 * 查询角色用户关联信息列表
	 */
	@Override
	public List listTTgSysRoleuserRel(EntityBase entity) throws Exception {
		return this.sysDao.listTTgSysRoleuserRel(entity);
	}

	/**
	 * 新增菜单信息
	 */
	@Override
	public void addTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.sysDao.addTTgSysMenuinfo(entity);
	}

	/**
	 * 修改菜单信息
	 */
	@Override
	public void updateTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.sysDao.updateTTgSysMenuinfo(entity);
	}

	/**
	 * 删除菜单信息
	 */
	@Override
	public void deleteTTgSysMenuinfo(EntityBase entity) throws Exception {
		this.sysDao.deleteTTgSysMenuinfo(entity);
	}

	/**
	 * 查询菜单信息
	 */
	@Override
	public Object findTTgSysMenuinfo(EntityBase entity) throws Exception {
		return this.sysDao.findTTgSysMenuinfo(entity);
	}

	/**
	 * 查询菜单信息列表
	 */
	@Override
	public List listTTgSysMenuinfo(EntityBase entity) throws Exception {
		return this.sysDao.listTTgSysMenuinfo(entity);
	}

	/**
	 * 查询菜单信息分页列表
	 */
	public ReturnData listTTgSysMenuinfoPage(EntityBase entity)
			throws Exception {
		return this.sysDao.listTTgSysMenuinfoPage(entity);
	}

	/**
	 * 新增角色菜单关联信息
	 */
	@Override
	public void addTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.sysDao.addTTgSysRolemenuRel(entity);
	}

	/**
	 * 修改角色菜单关联信息
	 */
	@Override
	public void updateTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.sysDao.updateTTgSysRolemenuRel(entity);
	}

	/**
	 * 删除角色菜单关联信息
	 */
	@Override
	public void deleteTTgSysRolemenuRel(EntityBase entity) throws Exception {
		this.sysDao.deleteTTgSysRolemenuRel(entity);
	}

	/**
	 * 查询角色菜单关联信息
	 */
	@Override
	public Object findTTgSysRolemenuRel(EntityBase entity) throws Exception {
		return this.sysDao.findTTgSysRolemenuRel(entity);
	}

	/**
	 * 查询角色菜单关联信息列表
	 */
	@Override
	public List listTTgSysRolemenuRel(EntityBase entity) throws Exception {
		return this.sysDao.listTTgSysRolemenuRel(entity);
	}

	/**
	 * 查询不重复的菜单编号信息列表
	 */
	@Override
	public List listTTgSysRolemenuRelDistinct(EntityBase entity)
			throws Exception {
		return this.sysDao.listTTgSysRolemenuRelDistinct(entity);
	}
	
	/**
	 * 新增全国省份城市区县信息
	 */
	public void addTWxSysCityinfo(EntityBase entity) throws Exception {
		this.sysDao.addTWxSysCityinfo(entity);
	}

	/**
	 * 修改全国省份城市区县信息
	 */
	public void updateTWxSysCityinfo(EntityBase entity) throws Exception {
		this.sysDao.updateTWxSysCityinfo(entity);
	}

	/**
	 * 删除全国省份城市区县信息
	 */
	public void deleteTWxSysCityinfo(EntityBase entity) throws Exception {
		this.sysDao.deleteTWxSysCityinfo(entity);
	}

	/**
	 * 查询全国省份城市区县信息
	 */
	public Object findTWxSysCityinfo(EntityBase entity) throws Exception {
		return this.sysDao.findTWxSysCityinfo(entity);
	}

	/**
	 * 查询全国省份城市区县信息列表
	 */
	public List listTWxSysCityinfo(EntityBase entity) throws Exception {
		return this.sysDao.listTWxSysCityinfo(entity);
	}

}
