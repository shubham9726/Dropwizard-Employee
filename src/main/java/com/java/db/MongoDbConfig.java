package com.java.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.configuration.MessageQueueFactory;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MongoDbConfig extends Configuration {

  @Valid
  @NotNull
  private MessageQueueFactory messageQueue = new MessageQueueFactory();

  @JsonProperty("messageQueue")
  public MessageQueueFactory getMessageQueueFactory() {
    return messageQueue;
  }

  @JsonProperty("messageQueue")
  public void setMessageQueueFactory(MessageQueueFactory factory) {
    this.messageQueue = factory;
  }
}