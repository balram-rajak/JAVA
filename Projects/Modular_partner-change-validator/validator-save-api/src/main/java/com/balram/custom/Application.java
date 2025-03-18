package com.balram.custom;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.balram.custom.config.impl.AppConfig;
import com.balram.custom.loggy.Loggy;
import com.balram.custom.loggy.status.ProcessStatus;

@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Loggy logger = Loggy.loggyFactory(Application.class);

	public static void main(String[] args) {
		
		logger.changeProcessStatus(ProcessStatus.START);
		JSONObject json=AppConfig.getSecret();
		System.setProperty("spring.cloud.config.uri", json.get("configserver.url").toString().substring(13));
		SpringApplication.run(Application.class, args);
		logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
	}

}
