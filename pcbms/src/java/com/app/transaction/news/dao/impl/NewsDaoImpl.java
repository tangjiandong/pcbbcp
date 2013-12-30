package com.app.transaction.news.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.dao.BaseDao;
import com.app.transaction.common.impl.dao.BaseDaoImpl;
import com.app.transaction.news.dao.NewsDao;
@SuppressWarnings("all")
@Repository("newsDaoImpl")
public class NewsDaoImpl  extends BaseDaoImpl implements NewsDao {

	
	/**
	 * 新增新闻采集规则
	 */
	@Override
	public void addTAppWebsiteInfo(EntityBase entity) throws Exception {
		this.insert("TAppWebsiteInfo.insertTAppWebsiteInfoByModel", entity);
	}

	/**
	 * 修改新闻采集规则
	 */
	@Override
	public void updateTAppWebsiteInfo(EntityBase entity) throws Exception {
		this.update("TAppWebsiteInfo.updateTAppWebsiteInfoByModel", entity);
	}

	/**
	 * 删除新闻采集规则
	 */
	@Override
	public void deleteTAppWebsiteInfo(EntityBase entity) throws Exception {
		this.delete("TAppWebsiteInfo.deleteTAppWebsiteInfoByModel", entity);
	}

	/**
	 * 查询新闻采集规则
	 */
	@Override
	public Object findTAppWebsiteInfo(EntityBase entity) throws Exception {
		return this.findByProperty("TAppWebsiteInfo.selectTAppWebsiteInfoByModel",
				entity);
	}

	/**
	 * 查询新闻采集规则列表
	 */
	@Override
	public List listTAppWebsiteInfo(EntityBase entity) throws Exception {
		return this.listByProperty("TAppWebsiteInfo.selectTAppWebsiteInfoByModel",
				entity);
	}

	/**
	 * 
	 * 查询新闻采集规则分页列表
	 */
	@Override
	public ReturnData listTAppWebsiteInfoPage(EntityBase entity) throws Exception {
		return this.listDataPaging("TAppWebsiteInfo.selectTAppWebsiteInfoByModel_list_page",
				entity);
	}
	
	
	/**
	 * 新增新闻中心
	 */
	@Override
	public void addTAppNewscenter(EntityBase entity) throws Exception {
		this.insert("TAppNewscenter.insertTAppNewscenterByModel", entity);
	}

	/**
	 * 修改新闻中心
	 */
	@Override
	public void updateTAppNewscenter(EntityBase entity) throws Exception {
		this.update("TAppNewscenter.updateTAppNewscenterByModel", entity);
	}

	/**
	 * 删除新闻中心
	 */
	@Override
	public void deleteTAppNewscenter(EntityBase entity) throws Exception {
		this.delete("TAppNewscenter.deleteTAppNewscenterByModel", entity);
	}

	/**
	 * 查询新闻中心
	 */
	@Override
	public Object findTAppNewscenter(EntityBase entity) throws Exception {
		return this.findByProperty("TAppNewscenter.selectTAppNewscenterByModel",
				entity);
	}

	/**
	 * 查询新闻中心列表
	 */
	@Override
	public List listTAppNewscenter(EntityBase entity) throws Exception {
		return this.listByProperty("TAppNewscenter.selectTAppNewscenterByModel",
				entity);
	}

	/**
	 * 
	 * 查询新闻中心分页列表
	 */
	@Override
	public ReturnData listTAppNewscenterPage(EntityBase entity) throws Exception {
		return this.listDataPaging("TAppNewscenter.selectTAppNewscenter_list_page",
				entity);
	}
	
	
	
}
