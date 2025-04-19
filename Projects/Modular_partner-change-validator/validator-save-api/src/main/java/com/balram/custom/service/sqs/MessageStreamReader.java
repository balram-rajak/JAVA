package com.balram.custom.service.sqs;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.balram.custom.loggy.Loggy;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

@Service
public class MessageStreamReader {

    Loggy logger = Loggy.loggyFactory(MessageStreamReader.class);
    private static final Region regionName = Region.US_EAST_1;

    @Value("${queue.name}")
    private String queueName;

    public List<Message> streamMessages(){

        SqsClient sqsClient = SqsClient.builder()
                .region(regionName)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
        GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder()
                .queueName(queueName)
                .build();
        ReceiveMessageResponse messageResponse = sqsClient.receiveMessage(ReceiveMessageRequest.builder().queueUrl(sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl()).build());
        
        return messageResponse.messages();
    }
}
