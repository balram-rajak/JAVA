package com.balram.custom.config.impl;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;

@Configuration
@EnableAsync
@Profile("!test")
public class AppConfig {

	public static final JSONObject getSecret(){

        String secretName= "Secret-Name";
		final Regions regionName = Regions.US_EAST_1;

		final AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(regionName).build();

		String secret = null;
		final GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
		GetSecretValueResult getSecretValueResult = null;

        getSecretValueResult = client.getSecretValue(getSecretValueRequest);

		if (getSecretValueResult.getSecretString() != null) {
			secret = getSecretValueResult.getSecretString();
		} 

		return new JSONObject(secret);
	}

	@Bean(name = "secretHandler")
	public JSONObject setCloudConfig() {
		return getSecret();
	}

}

