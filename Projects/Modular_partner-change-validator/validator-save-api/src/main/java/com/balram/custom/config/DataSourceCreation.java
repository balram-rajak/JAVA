package com.balram.custom.config;

import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;

public interface DataSourceCreation{
	
	public DataSource customerDataSource(JSONObject json) throws JSONException;

}
