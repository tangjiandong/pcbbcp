package com.app.transaction.news.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import info.czol.grabage.bean.GrabageSite;

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
public class HrefListWebSite {

	private  WebClient webClient;

	public void setWebClient(WebClient webClient) {
		this.webClient = webClient;
	}

	private GrabageSite xconfig;
	private List list;
	
	public HrefListWebSite(GrabageSite xconfig){
		this.xconfig = xconfig;
		webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.setJavaScriptEnabled(false);
	}
	
	/**
	 * 加载当页面新闻连接
	 * @throws IOException
	 *
	 * @author 汤建东
	 * @date 2013-12-17 下午4:39:42
	 *
	 */
	public void toLoadXlink() throws IOException {
		list=new ArrayList();
		long lasting = System.currentTimeMillis();
		String link = xconfig.getLink();
		HtmlPage page = (HtmlPage) webClient.getPage(link);
		List<DomNode> nodes = (List<DomNode>) page.getByXPath(xconfig.getXlink());
		System.out.println(nodes.size());
		for (DomNode node : nodes) {
			String href = node.getAttributes().getNamedItem("href").getNodeValue();
			
			if (href.startsWith(xconfig.getForward())) {
				list.add(href);
			}else{
				//System.out.println(node.asText() + "\t--2"+xconfig.getForward()+href);
			}
		}
		
		System.out.println("get links cost "+(System.currentTimeMillis()-lasting)/1000+"'s");
	}

	
	
	public void tryToLoadXlink() throws IOException {
		long lasting = System.currentTimeMillis();
		String link = xconfig.getLink();
		HtmlPage page = (HtmlPage) webClient.getPage(link);
		List<DomNode> nodes = (List<DomNode>) page.getByXPath(xconfig.getXlink());
		System.out.println(nodes.size());
		for (DomNode node : nodes) {
			String href = node.getAttributes().getNamedItem("href")
					.getNodeValue();
			System.out.println(href);
			if (href.startsWith(xconfig.getForward())) {
				System.out.println(node.asText() + "\t---1" + href);
			}else{
				System.out.println(node.asText() + "\t--2"+xconfig.getForward()+href);
			}
		}
		System.out.println("get links cost "+(System.currentTimeMillis()-lasting)/1000+"'s");
	}

	public GrabageSite getXconfig() {
		return xconfig;
	}

	public void setXconfig(GrabageSite xconfig) {
		this.xconfig = xconfig;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public WebClient getWebClient() {
		return webClient;
	}

	
	
}
