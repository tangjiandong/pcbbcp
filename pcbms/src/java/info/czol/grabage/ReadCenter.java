package info.czol.grabage;

import info.czol.grabage.bean.GrabageSite;
import info.czol.grabage.bean.PageInfo;
import info.czol.grabage.bean.ReleaseConfig;
import info.czol.grabage.logic.UtilTools;
import info.czol.grabage.read.GrabageReader;
import info.czol.grabage.read.PageParse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 为广大采集工具添砖加瓦，提供客户端的运行平台 
 * @作者 Gabriel 
 * @博客 http://blog.csdn.net/zdsdiablo
 */
public class ReadCenter {
	
	static {
		//禁止后台输出日志
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        Logger.getLogger("org.apache.commons.httpclient.HttpMethodBase").setLevel(Level.OFF);
    }
	
	private final List<GrabageSite> grabageSites;
	private final Map<GrabageSite,List<PageInfo>> grabageMap;
	private final Map<String,ReleaseConfig> releaseMap;
	
	
	private final GrabageReader configReader;
	
	public ReadCenter(){
		grabageSites= new ArrayList<GrabageSite>();
		grabageMap = new HashMap<GrabageSite,List<PageInfo>>();
		releaseMap = new HashMap<String,ReleaseConfig>();
		
		configReader= new GrabageReader(grabageSites,grabageMap,releaseMap);
		
	}
	
	public void reload(){
		configReader.reLoadConfig();
	}
	
	//重新读取页面
	public void startReadPage(){
		long lasting = System.currentTimeMillis();
		System.out.println("[grabage]start:"+lasting);
		try {
			for(GrabageSite gsite : grabageSites){
				if(UtilTools.isNotEmpty(gsite.getUsable()) && gsite.getUsable().equals("false")) continue;
				
				PageParse page = new PageParse(releaseMap, grabageMap, gsite);
				//读取
				page.read();
				//发布
				page.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		lasting = System.currentTimeMillis();
		System.out.println("[grabage]complete:"+lasting);
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ReadCenter center = new ReadCenter();
		center.reload();
		center.startReadPage();
	}
}
