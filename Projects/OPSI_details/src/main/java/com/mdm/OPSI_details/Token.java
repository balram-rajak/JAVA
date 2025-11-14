package com.mdm.OPSI_details;

public class Token {

	private String access_token;
	private String token_type;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	@Override
	public String toString() {
		String s=String.format("(access_token=%s, token_type=%s)", access_token,token_type);
		return s;
	}
	
	
}
