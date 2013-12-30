package com.app.transaction.news.action;

import java.io.IOException;
import java.util.List;

import info.czol.grabage.bean.GrabageSite;


import com.app.module.news.dto.TAppWebsiteInfo;



public class TestInfoSQLInfo163Rank {


	/**
	 * @param args
	 *
	 * @author 汤建东
	 * @throws IOException 
	 * @date 2013-12-17 下午4:26:51
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		//加载新闻信息
		TAppWebsiteInfo modelinfo=new TAppWebsiteInfo();
		modelinfo.setWebname("柏睿网");//网站名称
		modelinfo.setPlink("http://www.pcbbcp.com/?m=news&s=news_list&id=96");//新闻列表页面
		modelinfo.setForwardlink("http://www.pcbbcp.com");//网站主地址
		modelinfo.setPhref("//div[@class='newslist']/li//a[@href]");//获取新闻列表连接表达式
		GrabageSite xconfig = new GrabageSite();
		xconfig.setXlink(modelinfo.getPhref());//获取新闻列表连接表达式
		xconfig.setLink(modelinfo.getPlink());//新闻列表页面
		xconfig.setForward(modelinfo.getForwardlink());//主连接
		HrefListWebSite test = new HrefListWebSite(xconfig);
		test.toLoadXlink();//调用加载连接
		System.out.println(test.getList());
		
		List hlist=test.getList();
		
//		private String title;//标题
//		private String author;//作者
//		private String source;//来源
//		private String timeline;//发布时间
//		private String content;//正文
//		private String splitpath;//分页
//		private String summary;//简介
		
		 xconfig = new GrabageSite();
		xconfig.setForward(modelinfo.getForwardlink());//主连接
		
		//作者
		modelinfo.setAuthor("//div[@class='newstime']");
		xconfig.setAuthor(modelinfo.getAuthor());
		//标题
		modelinfo.setTitle("//div[@class='newstitle']");
		xconfig.setTitle(modelinfo.getTitle());
		//内容
		modelinfo.setContent("id('newscon')");
		xconfig.setContent(modelinfo.getContent());
		//来源
		modelinfo.setSource("//div[@class='newstime']");
		xconfig.setSource(modelinfo.getSource());
		//发布时间
		modelinfo.setTimeline("//div[@class='newstime']");
		xconfig.setTimeline(modelinfo.getTimeline());
		//简介
		modelinfo.setSummary("//div[@class='newstime']");
		xconfig.setSummary(modelinfo.getSummary());
		//	设置连接
		//xconfig.setLink("http://www.pcbbcp.com/?m=news&s=newsd&id=3291");
		for(int i=0;i<hlist.size();i++){
			//设置连接
			xconfig.setLink(hlist.get(i).toString());;//
			NewsObjectWebSite  newsobjs= new NewsObjectWebSite(xconfig);
			newsobjs.toLoadNewsObject();
			System.out.println(newsobjs.getNewsModel().toString());
			
		}
	
	
	
		
		

	}
	

	

}
