package com.mdm.OPSI_details;

/**
 * POJO class to hold OAuth 2.0 authentication token details.
 * Maps the JSON response from the Reltio authentication API.
 * 
 * @author Balram Rajak
 */
public class Token {

	/** OAuth 2.0 access token string */
	private String access_token;
	
	/** Token type (typically "Bearer") */
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
