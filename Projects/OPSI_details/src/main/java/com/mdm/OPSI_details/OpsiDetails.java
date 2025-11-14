package com.mdm.OPSI_details;

public class OpsiDetails {

	private String uri;
	private String type;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "OpsiDetails [uri=" + uri + ", type=" + type + "]";
	}
	
}
