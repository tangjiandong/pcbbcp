package info.czol.grabage.bean;

public class BrowserConfig {
	private String version;
	private boolean javascript=false;
	
	public BrowserConfig(){
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isJavascript() {
		return javascript;
	}

	public void setJavascript(boolean javascript) {
		this.javascript = javascript;
	}

}
