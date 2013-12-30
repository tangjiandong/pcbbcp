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
public class WebSiteInfoAction extends BaseAction {

	@Resource
	private NewsService newsService;
	private ReturnData rd; // 用户信息分页列表对象
	private TAppWebsiteInfo modelinfo;//实体对象
	private Integer id;//


	/**
	 *goto 进入模板管理页面
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:25:42
	 *
	 */
	public String list() {
		try {
			/** 查询信息分页列表 */
			if(modelinfo ==null){
				modelinfo=new TAppWebsiteInfo();
			}
			this.modelinfo.setPageNumber(this.getPageNumber());
			this.modelinfo.setPageSize(20);
			this.rd = this.newsService.listTAppWebsiteInfoPage(modelinfo);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "list";
	}


	
	/**
	 * 处理点击页面
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String loadNews() {
		String flag="";

		try {
			
			modelinfo=new TAppWebsiteInfo();
			modelinfo.setId(id);
			Object  appObject= this.newsService.findTAppWebsiteInfo(modelinfo);
			if (null != appObject) {
				//加载新闻信息
				TAppWebsiteInfo modelinfotemp=(TAppWebsiteInfo)appObject;
				GrabageSite xconfig = new GrabageSite();
				xconfig.setXlink(modelinfotemp.getPhref());//获取新闻列表连接表达式
				xconfig.setLink(modelinfotemp.getPlink());//新闻列表页面
				xconfig.setForward(modelinfotemp.getForwardlink());//主连接
				HrefListWebSite test = new HrefListWebSite(xconfig);
				test.toLoadXlink();//调用加载连接
				//新闻 列表页面连接
				List hlist=test.getList();
				 xconfig = new GrabageSite();
				xconfig.setForward(modelinfotemp.getForwardlink());//主连接
				//作者
				xconfig.setAuthor(modelinfotemp.getAuthor());
				//标题
				xconfig.setTitle(modelinfotemp.getTitle());
				//内容
				xconfig.setContent(modelinfotemp.getContent());
				//来源
				xconfig.setSource(modelinfotemp.getSource());
				//发布时间
				xconfig.setTimeline(modelinfotemp.getTimeline());
				//简介
				xconfig.setSummary(modelinfotemp.getSummary());
				//	设置连接
				//xconfig.setLink("http://www.pcbbcp.com/?m=news&s=newsd&id=3291");
				for(int i=0;i<hlist.size();i++){
					//设置连接
					xconfig.setLink(hlist.get(i).toString());;//
					NewsObjectWebSite  newsobjs= new NewsObjectWebSite(xconfig);
					newsobjs.toLoadNewsObject();
					
					TAppNewscenter  newsModel=newsobjs.getNewsModel();
				
					newsModel.setAddtime(new Date());
					newsModel.setUserid(getLoginUserId());
					newsModel.setUsername(getLoginUserName());
					newsModel.setIsrelease("0");//未发布的
					//新增
					newsService.addTAppNewscenter(newsModel);
					
				}
			
			}
			
			
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
	 * 处理点击页面
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String loadNews2() {
		String flag="";

		try {
			
			modelinfo=new TAppWebsiteInfo();
			modelinfo.setId(id);
			Object  appObject= this.newsService.findTAppWebsiteInfo(modelinfo);
			if (null != appObject) {
				//加载新闻信息
				TAppWebsiteInfo modelinfotemp=(TAppWebsiteInfo)appObject;
				modelinfotemp.setWebname("柏睿网首页》咨询中中心》企业动态");//网站名称
				modelinfotemp.setPlink("http://www.pcbbcp.com/?m=news&s=news_list&id=96");//新闻列表页面
				modelinfotemp.setForwardlink("http://www.pcbbcp.com");//网站主地址
				modelinfotemp.setPhref("//div[@class='newslist']/li//a[@href]");//获取新闻列表连接表达式
				GrabageSite xconfig = new GrabageSite();
				xconfig.setXlink(modelinfotemp.getPhref());//获取新闻列表连接表达式
				xconfig.setLink(modelinfotemp.getPlink());//新闻列表页面
				xconfig.setForward(modelinfotemp.getForwardlink());//主连接
				HrefListWebSite test = new HrefListWebSite(xconfig);
				test.toLoadXlink();//调用加载连接
				System.out.println(test.getList());
				//新闻 列表页面连接
				List hlist=test.getList();
				 xconfig = new GrabageSite();
				xconfig.setForward(modelinfotemp.getForwardlink());//主连接
				//作者
				modelinfotemp.setAuthor("//div[@class='newstime']");
				xconfig.setAuthor(modelinfotemp.getAuthor());
				//标题
				modelinfotemp.setTitle("//div[@class='newstitle']");
				xconfig.setTitle(modelinfotemp.getTitle());
				//内容
				modelinfotemp.setContent("id('newscon')");
				xconfig.setContent(modelinfotemp.getContent());
				//来源
				modelinfotemp.setSource("//div[@class='newstime']");
				xconfig.setSource(modelinfotemp.getSource());
				//发布时间
				modelinfotemp.setTimeline("//div[@class='newstime']");
				xconfig.setTimeline(modelinfotemp.getTimeline());
				//简介
				modelinfotemp.setSummary("//div[@class='newstime']");
				xconfig.setSummary(modelinfotemp.getSummary());
				//	设置连接
				//xconfig.setLink("http://www.pcbbcp.com/?m=news&s=newsd&id=3291");
				for(int i=0;i<hlist.size();i++){
					//设置连接
					xconfig.setLink(hlist.get(i).toString());;//
					NewsObjectWebSite  newsobjs= new NewsObjectWebSite(xconfig);
					newsobjs.toLoadNewsObject();
					
					TAppNewscenter  newsModel=newsobjs.getNewsModel();
				
					newsModel.setAddtime(new Date());
					newsModel.setUserid(getLoginUserId());
					newsModel.setUsername(getLoginUserName());
					newsModel.setIsrelease("0");//未发布的
					//新增
					newsService.addTAppNewscenter(newsModel);
					
				}
			
			}
			
			
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
	 *goto 添加模板页面
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String gotoAdd() {
		return "add";
	}
	
	/**
	 * 添加操作
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String doAdd() {
		String flag="";

		try {
			modelinfo.setAddtime(new Date());
			modelinfo.setUserid(getLoginUserId());
			modelinfo.setUsername(getLoginUserName());
			this.newsService.addTAppWebsiteInfo(modelinfo);
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
	 *goto 修改页面
	 * @return
	 *
	 * @author 汤建东
	 * @throws Exception 
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String gotoUpdate() throws Exception {
		modelinfo=new TAppWebsiteInfo();
		modelinfo.setId(id);
		Object  appObject= this.newsService.findTAppWebsiteInfo(modelinfo);
		if (null != appObject) {
			modelinfo=(TAppWebsiteInfo)appObject;
		}
		return "update";
	}
	
	/**
	 * 修改操作
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String doUpdate() {
		String flag="";
		try {
			//modelinfo.setAddtime(new Date());
			modelinfo.setUserid(getLoginUserId());
			modelinfo.setUsername(getLoginUserName());
			this.newsService.updateTAppWebsiteInfo(modelinfo);
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
	 * 删除
	 * @return
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午3:26:01
	 *
	 */
	public String doDele() {
		String flag="";

		try {
			modelinfo=new TAppWebsiteInfo();
			modelinfo.setId(id);
			
			this.newsService.deleteTAppWebsiteInfo(modelinfo);
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
	public TAppWebsiteInfo getModelinfo() {
		return modelinfo;
	}
	public void setModelinfo(TAppWebsiteInfo modelinfo) {
		this.modelinfo = modelinfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	

	
}
