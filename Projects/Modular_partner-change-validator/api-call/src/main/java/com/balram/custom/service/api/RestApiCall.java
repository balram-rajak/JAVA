package com.balram.custom.service.api;

import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.balram.custom.loggy.Loggy;

public interface RestApiCall {

    static final Loggy logger = Loggy.loggyFactory(RestApiCall.class);

    default String postApiCall(String url, String body, HttpHeaders headers){
        
        WebClient webClient = WebClient.create();
        String responseBody = webClient.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        MDC.put("payload", responseBody);
        logger.info("Api response received!");
        
		return responseBody;
    }
}
