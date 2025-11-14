package com.balram.custom.model;

import software.amazon.awssdk.services.sqs.model.Message;

public record MessageRecorder(Message message, String query) {

}
