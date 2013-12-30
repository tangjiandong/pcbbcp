package info.czol.grabage.read;

import info.czol.grabage.bean.GrabageSite;

import java.io.IOException;
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
public class TestReadLinkXpath {

	private final WebClient webClient;

	private GrabageSite xconfig;

	public TestReadLinkXpath(GrabageSite xconfig) {
		this.xconfig = xconfig;
		webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.setJavaScriptEnabled(false);
		//webClient.setCssEnabled(false);
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

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		GrabageSite xconfig = new GrabageSite();
		xconfig.setXlink("//div[@class='newslist']/li//a[@href]");
		xconfig.setLink("http://www.pcbbcp.com/?m=news&s=news_list&id=96");
		xconfig.setForward("http://www.pcbbcp.com");
		TestReadLinkXpath test = new TestReadLinkXpath(xconfig);
		test.tryToLoadXlink();
	}

}
