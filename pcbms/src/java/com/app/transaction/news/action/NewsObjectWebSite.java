package com.app.transaction.news.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import info.czol.grabage.bean.GrabageSite;
import info.czol.grabage.logic.UtilTools;
import info.czol.grabage.read.TestReadPageXpathDemoNew;

import com.app.module.news.dto.TAppNewscenter;
import com.app.utils.tool.String_Util;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
@SuppressWarnings("all")
/**
 * 加载新闻列表页面连接
 * @author admin
 *
 */
public class NewsObjectWebSite {
	private  WebClient webClient;

	public WebClient getWebClient() {
		return webClient;
	}

	public void setWebClient(WebClient webClient) {
		this.webClient = webClient;
	}
	private  GrabageSite xconfig;
	
	public GrabageSite getXconfig() {
		return xconfig;
	}

	public void setXconfig(GrabageSite xconfig) {
		this.xconfig = xconfig;
	}
	//新闻对象
	private TAppNewscenter  newsModel;
	
	
	
	public TAppNewscenter getNewsModel() {
		return newsModel;
	}

	public void setNewsModel(TAppNewscenter newsModel) {
		this.newsModel = newsModel;
	}

	public NewsObjectWebSite(GrabageSite xconfig) {
		this.xconfig = xconfig;
		webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.setJavaScriptEnabled(false);
		//webClient.setCssEnabled(false);
	}

	/**
	 * 加载新闻
	 * @throws IOException
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午4:53:53
	 *
	 */
	public void toLoadNewsObject() throws IOException {
		
		newsModel=new TAppNewscenter();
		
		HtmlPage page = (HtmlPage) webClient.getPage(xconfig.getLink());
		////原地址
		newsModel.setOldhref(xconfig.getLink());//原地址
		
		
//		private String isrelease;// 是否发布[1是0否]
//		private Integer userid;// 发布人编号
//		private String username;// 发布人姓名
//		private Date addtime;// 添加时间
		
		if (xconfig.getLink().startsWith(xconfig.getForward())){
			//标题
			if(!String_Util.checkObjectIsBank(xconfig.getTitle())){
				newsModel.setTitle(getNodeValues(page,xconfig.getTitle()));
			}
			//作者
			if(!String_Util.checkObjectIsBank(xconfig.getAuthor())){
				newsModel.setAuthor(getNodeValues(page,xconfig.getAuthor()));
			}
			//来源
			if(!String_Util.checkObjectIsBank(xconfig.getSource())){
				newsModel.setComefrom(getNodeValues(page,xconfig.getSource()));
			}
			//发布时间
			if(!String_Util.checkObjectIsBank(xconfig.getSource())){
				String timeline = getNodeValue(page,xconfig.getTimeline());
				newsModel.setTimeline(UtilTools.getTimeLine(timeline));
			}	
			//正文
			if(!String_Util.checkObjectIsBank(xconfig.getContent())){
				newsModel.setContent(getNodeHtmlValues(page,xconfig.getContent()));
			}
			//简介
			if(!String_Util.checkObjectIsBank(xconfig.getSummary())){
				newsModel.setSummary(getNodeHtmlValues(page,xconfig.getSummary()));
			}
		}
		
		
		
		
	}
	
	
	public void tryToLoadXlink() throws IOException {
		long lasting = System.currentTimeMillis();
		HtmlPage page = (HtmlPage) webClient.getPage(xconfig.getLink());
		removeAdvert(page,xconfig);
		String timeline = getNodeValue(page,xconfig.getTimeline());
		
		System.out.println(timeline);
		System.out.println(UtilTools.getTimeLine(timeline));
		if(UtilTools.isNotEmpty(xconfig.getSplitpath())){
			String content="";
			do{
				String str=getNodeValues(page,xconfig.getContent());
				content+=str;
				String nextpage=getNodeHref(page,xconfig.getSplitpath());
				
				String link = xconfig.getForward()+nextpage;
			
				System.out.println(">>>NEXTLINK>>>"+link+"\n"+str);
				
				String title=getNodeValues(page,xconfig.getTitle());
				System.out.println(title+"--1");
				if(UtilTools.isEmpty(nextpage)) break;
				page = (HtmlPage) webClient.getPage(link);
				removeAdvert(page,xconfig);
			}while(page!=null);
			System.out.println(content);
		}else{
			String str=getNodeValues(page,xconfig.getContent());
			System.out.println(str);
			String title=getNodeValues(page,xconfig.getTitle());
			System.out.println(title+"--2");
		}
		
		System.out.println("get page cost "+(System.currentTimeMillis()-lasting)/1000+"'s");
		
	}
	
	
	private void removeAdvert(HtmlPage page,GrabageSite xcon){
		if(xcon.hasAdvert()){
			HashSet<DomNode> adset = new HashSet<DomNode>();
			for(String xadvert : xcon.getAdvert()){
				adset.addAll((List<DomNode>)page.getByXPath(xadvert));
			}
			for(DomNode node : adset){
				DomNode pnode = node.getParentNode();
				pnode.removeChild(node);
			}
		}
		
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GrabageSite xconfig = new GrabageSite();

			//分页测试--带去除广告
			xconfig.setForward("http://www.pcbbcp.com");
			xconfig.setContent("id('newscon')");
			xconfig.setTitle("//div[@class='newstitle']");
			xconfig.setSource("//div[@class='newstime']");
			xconfig.setTimeline("//div[@class='newstime']");
			
			xconfig.setLink("http://www.pcbbcp.com/?m=news&s=newsd&id=3291");
		
			
		TestReadPageXpathDemoNew test = new TestReadPageXpathDemoNew(xconfig);
		test.tryToLoadXlink();
	}
	
	private String getNodeHref(HtmlPage page, String xpath){
		if(UtilTools.isEmpty(xpath))
			return "";
		List<DomNode> nodes = (List<DomNode>)page.getByXPath(xpath);
		if(nodes!=null && !nodes.isEmpty()) for(DomNode node : nodes){
			if(node.getAttributes().getLength()>0){
				return node.getAttributes().getNamedItem("href").getNodeValue();
			}
		}
		return "";
	}
	
	private String getNodeValue(HtmlPage page, String xpath){
		if(UtilTools.isEmpty(xpath))
			return "";
		List<DomNode> nodes = (List<DomNode>)page.getByXPath(xpath);
		if(nodes!=null && !nodes.isEmpty()) for(DomNode node : nodes){
			if(UtilTools.isNotEmpty(node.asText())){
				return node.asText().trim();
			}
		}
		return "";
	}
	private String getNodeValues(HtmlPage page, String xpath){
		if(UtilTools.isEmpty(xpath))
			return "";
		String str="";
		List<DomNode> nodes = (List<DomNode>)page.getByXPath(xpath);
		if(nodes!=null && !nodes.isEmpty()) for(DomNode node : nodes){
			if(UtilTools.isNotEmpty(node.asText())){
				str+=node.asText().trim();
			}
		}
		return str;
	}
	
	private String getNodeHtmlValues(HtmlPage page, String xpath){
		if(UtilTools.isEmpty(xpath))
			return "";
		String str="";
		List<DomNode> nodes = (List<DomNode>)page.getByXPath(xpath);
		if(nodes!=null && !nodes.isEmpty()) for(DomNode node : nodes){
			if(UtilTools.isNotEmpty(node.asXml())){
				//str+=node.asText().trim();
				str+=node.asXml();
			}
		}
		return str;
	}
	
}
