package info.czol.grabage.bean;

/**
 * 为广大采集工具添砖加瓦，提供客户端的运行平台 
 * @作者 Gabriel 
 * @博客 http://blog.csdn.net/zdsdiablo
 */
public enum PageInfoMark {
	LINK("link"),//链接
	FORWARD("forward"),
	SUMMARY("summary"),//简介
	TITLE("title"),//标题
	TIMELINE("timeline"),//发布时间
	AUTHOR("author"),//作者
	SOURCE("source"),//来源
	SPLIT("splitpath"),//分页标志
	CONTENT("content"), //正文
	
	XLINK("xlink"),
	XPATH("xpath"),	
	USABLE("usable"),
	GRABAGE_ARRAY("grabage-array"),
	GRABAGE("grabage"),
	
	CONFIG("config"),
	JAVASCRIPT("javascript"),
	
	RELEASE_ARRAY("release-array"),
	RELEASE("release"),
	ID("id"),
	CHECK("check"),
	SEND("send"),
	PARAM("param"),
	NAME("name"),
	FROM("from"),
	RELEASEID("releaseid"),
	;
	private String value;
	
	private PageInfoMark(String v){
		this.value=v;
	}
	
	public String toString(){
		return value;
	}
	
	public boolean equals(String v){
		if(value.equalsIgnoreCase(v))
			return true;
		return false;
	}
}
