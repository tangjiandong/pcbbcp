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
public class TestReadPageXpathDemoNew {

	private final WebClient webClient;

	private GrabageSite xconfig;

	public TestReadPageXpathDemoNew(GrabageSite xconfig) {
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
		
		System.out.println("timeline:"+timeline);
		System.out.println(UtilTools.getTimeLine(timeline));
		
		

			String str=getNodeHtmlValues(page,xconfig.getContent());
			System.out.println("content:"+str);
			String title=getNodeValues(page,xconfig.getTitle());
			System.out.println("title:"+title);
		
		
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
