package com.balram.custom.service.sqs;

import java.util.function.Function;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.balram.custom.loggy.Loggy;

/**
 * Class to handle the formatting of the update query
 */
@Service
public class QueryFormator {

    Loggy logger = Loggy.loggyFactory(QueryFormator.class);
    @Value("${PartnerHierarchyChange.query}")
    private String queryTemplate;

    private static final Function<String,String[]> splitMessage = s -> s.split("[|]{2}");

    public String formatQuery(String message){

        logger.payload(message).info("Query Formator initiated!");
        JSONObject json = new JSONObject(message);

        String[] values = splitMessage.apply(json.getString("Message"));
        String query= String.format(queryTemplate,values[2],values[0]);
        logger.payload(query).info("Query Formatted!");

        return query;
    }
}
