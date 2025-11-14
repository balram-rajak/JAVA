package com.balram.custom.config.impl;

import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.balram.custom.config.DataSourceCreation;

@Configuration
@Profile("!test")
@EnableTransactionManagement
public class DataSourceCreationImpl implements DataSourceCreation{

	@Override
	@Primary
	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource customerDataSource(@Qualifier("secretHandler") JSONObject json) throws JSONException {
		return DataSourceBuilder.create().password(json.getString("ods.db.secret")).username(json.getString("ods.db.username")).build();
	}
}
