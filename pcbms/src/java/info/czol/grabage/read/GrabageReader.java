package info.czol.grabage.read;

import info.czol.grabage.bean.GrabageSite;
import info.czol.grabage.bean.PageInfo;
import info.czol.grabage.bean.PageInfoMark;
import info.czol.grabage.bean.ReleaseConfig;
import info.czol.grabage.bean.ReleaseParam;
import info.czol.grabage.logic.UtilTools;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 为广大采集工具添砖加瓦，提供客户端的运行平台 
 * @作者 Gabriel 
 * @博客 http://blog.csdn.net/zdsdiablo
 */
public class GrabageReader {
	
	private static final String CONFIGFILEPATH = "grabage-config.xml";
	
	private final List<GrabageSite> grabageSites;
	private final Map<GrabageSite,List<PageInfo>> grabageMap;
	private final Map<String,ReleaseConfig> releaseMap;
	
	public GrabageReader(List<GrabageSite> grabageSites, Map<GrabageSite, List<PageInfo>> grabageMap, Map<String, ReleaseConfig> releaseMap) {
		//webClient= new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		//webClient.setJavaScriptEnabled(false);
		this.grabageSites= grabageSites;
		this.grabageMap = grabageMap;
		this.releaseMap = releaseMap;
		
	}

	//重新加载订阅信息
	public void reLoadConfig() {
		long lasting = System.currentTimeMillis();
		System.out.println("[config]start:"+lasting);
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(CONFIGFILEPATH);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			//解析htmlunit配置
			//Element configItem = root.element(PageInfoMark.CONFIG.toString());
			//String jsenabled = configItem.element(PageInfoMark.JAVASCRIPT.toString()).attributeValue(ENABLED).trim();
			
			//解析发布栏目的配置
			reLoadReleaseConfig(root);
			
			//解析采集站点的配置
			reLoadGrabageConfig(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		lasting = System.currentTimeMillis();
		System.out.println("[config]complete:"+lasting);
	}
	
	private void reLoadReleaseConfig(Element root) throws Exception{
		List<Element> raItems = root.element(PageInfoMark.RELEASE_ARRAY.toString()).elements(PageInfoMark.RELEASE.toString());
		releaseMap.clear();
		for(Element raItem : raItems){
			ReleaseConfig rc = new ReleaseConfig();
			String id = raItem.attributeValue(PageInfoMark.ID.toString()).trim();
			rc.setId(id);
			rc.setUsable(raItem.attributeValue(PageInfoMark.USABLE.toString()).trim());
			rc.setCheck(raItem.attributeValue(PageInfoMark.CHECK.toString()).trim());
			rc.setSend(raItem.attributeValue(PageInfoMark.SEND.toString()).trim());
			
			List<Element> params = raItem.elements(PageInfoMark.PARAM.toString());
			List<ReleaseParam> paramList = new ArrayList<ReleaseParam>();
			for(Element paramItem : params){
				ReleaseParam rp = new ReleaseParam();
				rp.setName(paramItem.attributeValue(PageInfoMark.NAME.toString()).trim());
				rp.setFrom(paramItem.attributeValue(PageInfoMark.FROM.toString()));
				rp.setValue(paramItem.getTextTrim());
				paramList.add(rp);
			}
			rc.setParams(paramList);
			releaseMap.put(id, rc);
		}
	}
	
	private void reLoadGrabageConfig(Element root) throws Exception{
		List<Element> gaItems = root.element(PageInfoMark.GRABAGE_ARRAY.toString()).elements(PageInfoMark.GRABAGE.toString());
		grabageSites.clear();
		
		for(Element gaItem : gaItems){
			GrabageSite gs = new GrabageSite();
			String releaseid =gaItem.attributeValue(PageInfoMark.RELEASEID.toString()); 
			if(releaseid!=null)	gs.setReleaseID(releaseid.trim());
			gs.setUsable(gaItem.attributeValue(PageInfoMark.USABLE.toString()).trim());
			gs.setForward(gaItem.attributeValue(PageInfoMark.FORWARD.toString()).trim());
			gs.setLink(gaItem.attributeValue(PageInfoMark.LINK.toString()).trim());
			//
			Element title = gaItem.element(PageInfoMark.TITLE.toString());
			if(title!=null) gs.setTitle(title.attributeValue(PageInfoMark.XPATH.toString()));
			
			Element author = gaItem.element(PageInfoMark.AUTHOR.toString());
			if(author!=null) gs.setAuthor(author.attributeValue(PageInfoMark.XPATH.toString()));
			//来源为固定值，从配置中获取
			Element source = gaItem.element(PageInfoMark.SOURCE.toString());
			if(source!=null) {
				String src=source.attributeValue(PageInfoMark.XPATH.toString());
				if(UtilTools.isEmpty(src))
					src=source.getTextTrim();
				gs.setSource(src);
			}
			
			Element timeline = gaItem.element(PageInfoMark.TIMELINE.toString());
			if(timeline!=null) gs.setTimeline(timeline.attributeValue(PageInfoMark.XPATH.toString()));
			
			Element summary = gaItem.element(PageInfoMark.SUMMARY.toString());
			if(summary!=null) gs.setSummary(summary.attributeValue(PageInfoMark.XPATH.toString()));
			
			Element content = gaItem.element(PageInfoMark.CONTENT.toString());
			if(content!=null) {
				gs.setContent(content.attributeValue(PageInfoMark.XPATH.toString()));
			}
			
			
			Element splitpath = gaItem.element(PageInfoMark.SPLIT.toString());
			if(splitpath!=null) gs.setSplitpath(splitpath.attributeValue(PageInfoMark.XPATH.toString()));
			
			//暂时只做一层，理论上可多层深入
			Element xlink = gaItem.element(PageInfoMark.XLINK.toString());
			if(xlink!=null) gs.setXlink(xlink.attributeValue(PageInfoMark.XPATH.toString()));
			
			grabageSites.add(gs);
		}
	}
	
	
	
}