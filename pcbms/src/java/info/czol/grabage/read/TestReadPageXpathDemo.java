package info.czol.grabage.read;

import info.czol.grabage.bean.GrabageSite;
import info.czol.grabage.logic.UtilTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 为广大采集工具添砖加瓦，提供客户端的运行平台 
 * @作者 Gabriel 
 * @博客 http://blog.csdn.net/zdsdiablo
 */
public class TestReadPageXpathDemo {

	private final WebClient webClient;

	private GrabageSite xconfig;

	public TestReadPageXpathDemo(GrabageSite xconfig) {
		this.xconfig = xconfig;
		webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.setJavaScriptEnabled(false);
		//webClient.setCssEnabled(false);
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
			xconfig.setForward("http://news.sina.com.cn");
			xconfig.setContent("id('artibody')");
			xconfig.setTitle("//div[@class='blkContainerSblk']/h1");
			//xconfig.setSplitpath("//div[@class='pagination']/a[@class='next_page']");
			xconfig.setLink("http://news.sina.com.cn/pl/2013-12-17/100629005609.shtml");
			List<String> adList=new ArrayList<String>();
			adList.add("id('hunter_recommended')");
			adList.add("id('related_topics')");
			
			//xconfig.setAdvert(adList);
		
		TestReadPageXpathDemo test = new TestReadPageXpathDemo(xconfig);
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
}
