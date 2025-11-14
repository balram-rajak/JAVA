package com.balram.custom.service.api.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.balram.custom.service.api.RestApiCall;

public abstract sealed class ApiCall implements RestApiCall permits UpdateCall{

    @Value("${x-api-key}")
    private String xApiKey;

    private HttpHeaders getHeaders(){

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", xApiKey);

        return headers;
    }

    public String postApiCall(String url, String body){

        return postApiCall(url, body, getHeaders());
    }

}
