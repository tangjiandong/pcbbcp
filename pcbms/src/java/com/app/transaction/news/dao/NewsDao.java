package com.app.transaction.news.dao;

import java.util.List;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;

public interface NewsDao  extends BaseDao{

	
	/**
	 * 新增新闻采集规则
	 */
	public void addTAppWebsiteInfo(EntityBase entity) throws Exception;

	/**
	 * 修改新闻采集规则
	 */
	public void updateTAppWebsiteInfo(EntityBase entity) throws Exception;

	/**
	 * 删除新闻采集规则
	 */
	public void deleteTAppWebsiteInfo(EntityBase entity) throws Exception;

	/**
	 * 查询新闻采集规则
	 */
	public Object findTAppWebsiteInfo(EntityBase entity) throws Exception;

	/**
	 * 查询新闻采集规则列表
	 */
	public List listTAppWebsiteInfo(EntityBase entity) throws Exception;

	/**
	 * 查询新闻采集规则分页列表
	 */
	public ReturnData listTAppWebsiteInfoPage(EntityBase entity) throws Exception;
	
	
	
	
	/**
	 * 新增新闻中心
	 */
	public void addTAppNewscenter(EntityBase entity) throws Exception;

	/**
	 * 修改新闻中心
	 */
	public void updateTAppNewscenter(EntityBase entity) throws Exception;

	/**
	 * 删除新闻中心
	 */
	public void deleteTAppNewscenter(EntityBase entity) throws Exception;

	/**
	 * 查询新闻中心
	 */
	public Object findTAppNewscenter(EntityBase entity) throws Exception;

	/**
	 * 查询新闻中心列表
	 */
	public List listTAppNewscenter(EntityBase entity) throws Exception;

	/**
	 * 查询新闻中心分页列表
	 */
	public ReturnData listTAppNewscenterPage(EntityBase entity) throws Exception;
	
	
	
	
	
}
