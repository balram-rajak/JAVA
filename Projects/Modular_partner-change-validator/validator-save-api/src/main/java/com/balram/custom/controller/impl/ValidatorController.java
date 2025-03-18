package com.balram.custom.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.balram.custom.controller.ValidatorSaver;
import com.balram.custom.loggy.Loggy;
import com.balram.custom.loggy.status.ProcessStatus;
import com.balram.custom.model.MessageRecorder;
import com.balram.custom.service.api.impl.UpdateCall;
import com.balram.custom.service.sqs.MessageStreamReader;
import com.balram.custom.service.sqs.QueryFormator;

import software.amazon.awssdk.services.sqs.model.Message;

@RestController
public class ValidatorController implements ValidatorSaver {

    Loggy logger = Loggy.loggyFactory(ValidatorController.class);

    @Autowired
    MessageStreamReader messageStreamReader;

    @Autowired
    QueryFormator queryFormator;

    @Autowired
    UpdateCall updateCall;

    @Scheduled(cron = "${validator.saver.cron}")
    public void validateAndProcess() {

        logger.changeProcessStatus(ProcessStatus.START);
        logger.info("Cron Job started!");

        logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
        List<Message> messages = messageStreamReader.streamMessages();

        logger.info("Messages received: {}", messages.size());
        messages.stream()
        .map(message -> new MessageRecorder(message, queryFormator.formatQuery(message.body())))
        .map(m -> m.query())
        .map(updateCall.call)
        .forEach(response -> logger.info("Message processed successfully: {}", response));
        logger.changeProcessStatus(ProcessStatus.END);
        logger.info("Cron Job ended!");

    }

}
