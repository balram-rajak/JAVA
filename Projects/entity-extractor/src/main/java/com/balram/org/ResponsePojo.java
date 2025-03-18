package com.balram.org;
public class ResponsePojo {

	private Long id;
	private String error;
	private String error_description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError_description() {
		return error_description;
	}
	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
	
	@Override
	public String toString() {
		String structure=String.format("id=%s, error=%s, "
				+ "error_description=%s",id,error,error_description);
		return structure;
	}
	
	
}
