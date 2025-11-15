package com.mdm.OPSI_details;

/**
 * POJO class representing OPSI (Organization, Party, Site, Individual) entity details.
 * Stores basic information about an OPSI entity from Reltio MDM.
 * 
 * @author Balram Rajak
 */
public class OpsiDetails {

	/** Unique resource identifier (URI) of the OPSI entity */
	private String uri;
	
	/** Entity type from Reltio configuration */
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
