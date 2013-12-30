package info.czol.grabage.read;

import info.czol.grabage.bean.GrabageSite;
import info.czol.grabage.bean.PageInfo;
import info.czol.grabage.bean.PageInfoMark;
import info.czol.grabage.bean.ReleaseConfig;
import info.czol.grabage.bean.ReleaseParam;
import info.czol.grabage.logic.ParsePageTools;
import info.czol.grabage.logic.UtilTools;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class PageParse{
	
	private static final int DEBUG_COUNT=10;
	private static final String HREF="href";
	
	private WebClient webClient;
	private final GrabageSite gsite;
	private final Map<String,ReleaseConfig> releaseMap;
	private final List<PageInfo> pageInfoList;
	
	public PageParse(Map<String,ReleaseConfig> releaseMap, Map<GrabageSite,List<PageInfo>> map, GrabageSite gsite){
		//TODO: 需要通过配置传过来参数
		webClient= buildWebClient();
		this.gsite=gsite;
		this.releaseMap=releaseMap;
		pageInfoList = new ArrayList<PageInfo>();
	}
	
	private WebClient buildWebClient(){
		WebClient client = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		client.setJavaScriptEnabled(true);
		return client;
	}

	//采集
	public void read() throws Exception{
		HtmlPage page = (HtmlPage)webClient.getPage(gsite.getLink());
		
		//解析规则
		HashSet<String> linkSet = new HashSet<String>();
		
		List<DomNode> linkNodes = (List<DomNode>)page.getByXPath(gsite.getXlink());			
		if(linkNodes!=null && !linkNodes.isEmpty()) for(DomNode node : linkNodes){
			String href = node.getAttributes().getNamedItem(HREF).getNodeValue();
			
			if (href.startsWith(gsite.getForward())) {
				linkSet.add(href);
			}
			//取消外部链接
			else if(href.startsWith("http:") || href.startsWith("https:")){
				continue;
			}
			//保留相对链接
			else{
				linkSet.add(gsite.getForward()+href);
			}
		}
		int i=0;
		for(String link : linkSet){
			i++;
			if(i>DEBUG_COUNT) break;
			PageInfo pb = new PageInfo();
			pb.setLink(link);
			try{
				page = (HtmlPage)webClient.getPage(pb.getLink());
				//移除广告
				ParsePageTools.removeAdvert(page,gsite);
				//标题
				pb.setTitle(ParsePageTools.getNodeValue(page, gsite.getTitle()));
				//作者
				pb.setAuthor(ParsePageTools.getNodeValue(page, gsite.getAuthor()));
				//来源 首先尝试从页面获取，这里未区分xpath，暂时就不改了
				String src=ParsePageTools.getNodeValue(page, gsite.getSource());
				if(UtilTools.isEmpty(src))
					src=gsite.getSource();
				pb.setSource(src);
				//发布时间
				pb.setTimeline(UtilTools.getTimeLine(
						ParsePageTools.getNodeValue(page, gsite.getTimeline())));
				//简介
				pb.setSummary(ParsePageTools.getNodeValue(page, gsite.getSummary()));
				//内容
				pb.setContent(ParsePageTools.getContent(page, gsite.getContent()));
				
				//分页
				searchNextPage(page,pb,gsite);
				
				pageInfoList.add(pb);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println(">>>TITLE>>>"+pb.getTitle()+"\t>>>LINK>>>"+pb.getLink()+"\n"+pb.getContent());
		}
	}
	
	//发布
	public void release() throws Exception{
		String releaseID=gsite.getReleaseID();
		ReleaseConfig config = releaseMap.get(releaseID);
		if(config==null || config.getUsable()==null 
				|| "false".equalsIgnoreCase(config.getUsable())) return;
		
		for(PageInfo pageInfo : pageInfoList){
			//检查
			URL url = new URL(config.getCheck());
			WebRequestSettings reqSet = new WebRequestSettings(url, HttpMethod.POST);
			reqSet.setCharset("UTF-8");
			
			List reqParam = new ArrayList();
			for(ReleaseParam rp : config.getParams()){
				String name = rp.getName();
				if(UtilTools.isEmpty(name)) continue;
				String from = rp.getFrom();
				String value = rp.getValue();
				
				if(UtilTools.isNotEmpty(value)){
					reqParam.add(new NameValuePair(name, value));
				}
				//增加标题参数
				else if(UtilTools.isNotEmpty(from) && from.equalsIgnoreCase(PageInfoMark.TITLE.toString())){
					value = pageInfo.getTitle();
					//System.out.println(">>>"+name+">>>"+value);
					reqParam.add(new NameValuePair(name, value));
				}
				
			}
			reqSet.setRequestParameters(reqParam);
			//要创建新的WebClient,否则传送的数据会出问题
			webClient=buildWebClient();
			HtmlPage mypage = (HtmlPage) webClient.getPage(reqSet);
			String result = mypage.asText();
			System.out.println(">>>RESULT>>>CHECK>>>"+result);
			
			//传送
			if(result.indexOf("[no]")>=0){
				url = new URL(config.getSend());
				reqSet = new WebRequestSettings(url, HttpMethod.POST);
				reqSet.setCharset("UTF-8");
				
				reqParam.clear();
				for(ReleaseParam rp : config.getParams()){
					try{
						String name = rp.getName();
						if(UtilTools.isEmpty(name)) continue;
						String from = rp.getFrom();
						String value = rp.getValue();
						
						if(UtilTools.isNotEmpty(value)){
							reqParam.add(new NameValuePair(name, value));
						}
						//增加采集参数
						else if(UtilTools.isNotEmpty(from)){
							String methodName="get"+from.toUpperCase().substring(0,1)+from.toLowerCase().substring(1);
							Method m = pageInfo.getClass().getDeclaredMethod(methodName, null);
							Object obj = m.invoke(pageInfo, null);
							if(obj==null) continue;
							
							value = obj.toString();
							System.out.println(">>>"+name+">>>"+value);
							reqParam.add(new NameValuePair(name, value));
						}
					}catch(Exception ex){
						//ex.printStackTrace();
					}
					
				}
				
				
				reqSet.setRequestParameters(reqParam);
				webClient=buildWebClient();
				mypage = (HtmlPage) webClient.getPage(reqSet);
				result = mypage.asText();
				System.out.println(">>>RESULT>>>SEND>>>"+result);
			}
		}
	}
	

	/**
	 * 寻找次页
	 * @param page
	 * @param pb
	 * @param gsite
	 */
	private void searchNextPage(HtmlPage page, final PageInfo pb, final GrabageSite gsite){
		if(UtilTools.isNotEmpty(gsite.getSplitpath())){
			String href=ParsePageTools.getNodeHref(page,gsite.getSplitpath());			
			if(UtilTools.isEmpty(href))	return;
			String nextlink="";
			if (href.startsWith(gsite.getForward())) {
				nextlink=href;
			}else{
				nextlink=gsite.getForward()+href;
			}
			try{
				page = (HtmlPage) webClient.getPage(nextlink);
				pb.setContent(pb.getContent()+ParsePageTools.getContent(page, gsite.getContent()));
				
				searchNextPage(page,pb,gsite);
			}catch(Exception ex){
				return;
			}
		}
	}
	
}
