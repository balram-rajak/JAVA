package com.balram.custom.service.api.impl;

import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.balram.custom.loggy.Loggy;

@Service
public final class UpdateCall extends ApiCall{

    Loggy logger = Loggy.loggyFactory(UpdateCall.class);
    
    @Value("${update-api.endpoint}")
    private String updateApiurl;

    @Value("${update-api.body}")
    private String bodyTemplate;

    private final UnaryOperator<String> buildBody = query -> String.format(bodyTemplate, query);

    public final UnaryOperator<String> call = query ->{
        String body = buildBody.apply(query);
        logger.payload(body).info("update-api call initiated! to: {}",updateApiurl);
        String response = postApiCall(updateApiurl, body);
        logger.payload(response).info("update-api call response received!");
        
        return response;
    };

}
