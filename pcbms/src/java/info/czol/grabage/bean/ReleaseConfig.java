package info.czol.grabage.bean;

import java.util.List;

public class ReleaseConfig {
	private String id;
	private String usable;
	private String check;
	private String send;
	private List<ReleaseParam> params;
	
	public ReleaseConfig(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsable() {
		return usable;
	}
	public void setUsable(String usable) {
		this.usable = usable;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public List<ReleaseParam> getParams() {
		return params;
	}
	public void setParams(List<ReleaseParam> params) {
		this.params = params;
	}
	
}
