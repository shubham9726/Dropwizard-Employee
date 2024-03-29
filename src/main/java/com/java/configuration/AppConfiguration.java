package com.java.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class AppConfiguration  {
  @JsonProperty
  @NotEmpty
  public String mongoHost;

  @JsonProperty
  @Min(1)
  @Max(65535)
  public int mongoPort;

  @JsonProperty
  @NotEmpty
  public String mongoDB;

  @JsonProperty
  @NotEmpty
  public String collectionName;

  public String getMongoHost() {
    return mongoHost;
  }

  public void setMongoHost(String mongoHost) {
    this.mongoHost = mongoHost;
  }

  public int getMongoPort() {
    return mongoPort;
  }

  public void setMongoPort(int mongoPort) {
    this.mongoPort = mongoPort;
  }

  public String getMongoDB() {
    return mongoDB;
  }

  public void setMongoDB(String mongoDB) {
    this.mongoDB = mongoDB;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  /* public AppConfigurationClient build(Environment environment) {
     AppConfigurationClient client = new AppConfigurationClient(getCollectionName(),getMongoDB(),getMongoHost(),getMongoPort());
      environment.lifecycle().manage(new Managed() {
      @Override
      public void start() {
      }

      @Override
      public void stop() {
      }
    });
    return client;
  }

  } */


    /*public MongoConfiguration getMongoConfiguration() {
        return mongoConfiguration;
    }

    public void setMongoConfiguration(MongoConfiguration mongoConfiguration) {
        this.mongoConfiguration = mongoConfiguration;
    }

    @Valid
    @JsonProperty("mongoserver")
    public MongoConfiguration mongoConfiguration;
*/
    /*@JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }*/

}
