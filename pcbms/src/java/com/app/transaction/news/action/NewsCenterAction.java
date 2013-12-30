package com.app.transaction.news.action;

import info.czol.grabage.bean.GrabageSite;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.app.common.model.ReturnData;
import com.app.module.news.dto.TAppNewscenter;
import com.app.module.news.dto.TAppWebsiteInfo;
import com.app.module.user.dto.TTgUserinfo;
import com.app.transaction.common.action.BaseAction;
import com.app.transaction.news.service.NewsService;
import com.app.utils.constant.MD5;

@SuppressWarnings("all")
public class NewsCenterAction extends BaseAction {

	@Resource
	private NewsService newsService;
	private ReturnData rd; // 用户信息分页列表对象
	private TAppNewscenter modelinfo;// 实体对象
	private Integer id;//

	/**
	 * goto 新闻管理列表
	 * 
	 * @return
	 * 
	 * @author 汤建东
	 * @date 2013-12-17 下午3:25:42
	 * 
	 */
	public String list() {
		try {
			/** 查询信息分页列表 */
			if (modelinfo == null) {
				modelinfo = new TAppNewscenter();
			}
			this.modelinfo.setPageNumber(this.getPageNumber());
			this.modelinfo.setPageSize(10);
			this.rd = this.newsService.listTAppNewscenterPage(modelinfo);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "list";
	}

	/**
	 * 审核新闻
	 * 
	 * @return
	 * 
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 * 
	 */
	public String doRate() {
		String flag = "";

		try {
			modelinfo = new TAppNewscenter();
			modelinfo.setId(id);
			modelinfo.setIsrelease("1");
			this.newsService.updateTAppNewscenter(modelinfo);
			flag = "0000";
		} catch (Exception e) {
			flag = "1111"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			this.setAjaxMessage(flag);
		}

		return "ajax";
	}

	/**
	 * 查看新闻
	 * 
	 * @return
	 * 
	 * @author 汤建东
	 * @throws Exception
	 * @date 2013-12-17 下午6:06:33
	 * 
	 */
	public String gotoView() throws Exception {

		try {
			modelinfo = new TAppNewscenter();
			modelinfo.setId(id);
			Object appObject = this.newsService.findTAppNewscenter(modelinfo);
			// List listaa=this.newsService.listTAppNewscenter(modelinfo);
			if (null != appObject) {
				modelinfo = (TAppNewscenter) appObject;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "view";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * 
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 * 
	 */
	public String doDele() {
		String flag = "";

		try {
			modelinfo = new TAppNewscenter();
			modelinfo.setId(id);
			this.newsService.deleteTAppNewscenter(modelinfo);
			flag = "0000";
		} catch (Exception e) {
			flag = "1111"; // 失败
			log.error(e.getMessage(), e);
		} finally {
			this.setAjaxMessage(flag);
		}

		return "ajax";
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public ReturnData getRd() {
		return rd;
	}

	public void setRd(ReturnData rd) {
		this.rd = rd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TAppNewscenter getModelinfo() {
		return modelinfo;
	}

	public void setModelinfo(TAppNewscenter modelinfo) {
		this.modelinfo = modelinfo;
	}

}
