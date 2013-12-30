package com.app.transaction.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.common.model.EntityBase;
import com.app.common.model.ReturnData;
import com.app.transaction.common.impl.service.BaseServiceImpl;
import com.app.transaction.news.dao.NewsDao;

import com.app.transaction.news.service.NewsService;
@SuppressWarnings("all")
@Service("newsServiceImpl")
public class NewsServiceImpl extends BaseServiceImpl implements NewsService {
	@Resource
	private  NewsDao newsDao;
	
	/**
	 * 新增新闻采集规则
	 */

	public void addTAppWebsiteInfo(EntityBase entity) throws Exception {
		newsDao.addTAppWebsiteInfo(entity);
	}

	/**
	 * 修改新闻采集规则
	 */
	@Override
	public void updateTAppWebsiteInfo(EntityBase entity) throws Exception {
		newsDao.updateTAppWebsiteInfo(entity);
	}

	/**
	 * 删除新闻采集规则
	 */
	@Override
	public void deleteTAppWebsiteInfo(EntityBase entity) throws Exception {
	
		newsDao.deleteTAppWebsiteInfo(entity);
	}

	/**
	 * 查询新闻采集规则
	 */
	@Override
	public Object findTAppWebsiteInfo(EntityBase entity) throws Exception {
		return newsDao.findTAppWebsiteInfo(entity);
	}

	/**
	 * 查询新闻采集规则列表
	 */
	@Override
	public List listTAppWebsiteInfo(EntityBase entity) throws Exception {
		return newsDao.listTAppWebsiteInfo(entity);
	}

	/**
	 * 
	 * 查询新闻采集规则分页列表
	 */
	@Override
	public ReturnData listTAppWebsiteInfoPage(EntityBase entity) throws Exception {
		return newsDao.listTAppWebsiteInfoPage(entity);
	}
	
	
	/**
	 * 新增新闻中心
	 */
	@Override
	public void addTAppNewscenter(EntityBase entity) throws Exception {
		 newsDao.addTAppNewscenter(entity);
	}

	/**
	 * 修改新闻中心
	 */
	@Override
	public void updateTAppNewscenter(EntityBase entity) throws Exception {
		 newsDao.updateTAppNewscenter(entity);
	}

	/**
	 * 删除新闻中心
	 */
	@Override
	public void deleteTAppNewscenter(EntityBase entity) throws Exception {
		 newsDao.deleteTAppNewscenter(entity);
	}

	/**
	 * 查询新闻中心
	 */
	@Override
	public Object findTAppNewscenter(EntityBase entity) throws Exception {
		return newsDao.findTAppNewscenter(entity);
	}

	/**
	 * 查询新闻中心列表
	 */
	@Override
	public List listTAppNewscenter(EntityBase entity) throws Exception {
		return newsDao.listTAppNewscenter(entity);
	}

	/**
	 * 
	 * 查询新闻中心分页列表
	 */
	@Override
	public ReturnData listTAppNewscenterPage(EntityBase entity) throws Exception {
		return newsDao.listTAppNewscenterPage(entity);
	}
	
	
	
	
	
}
