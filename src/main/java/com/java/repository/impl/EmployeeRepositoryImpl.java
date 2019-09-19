package com.java.repository.impl;

import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
/*@Inject
  public EmployeeRepositoryImpl(AppConfiguration configuration){
  MongoClient mongoClient = new MongoClient(configuration.getMongoHost(), configuration.getMongoPort());
  MongoManaged mongoManaged = new MongoManaged(mongoClient);
  MongoDatabase db = mongoClient.getDatabase(configuration.getMongoDB());
  MongoCollection<Document> collection = db.getCollection(configuration.getCollectionName());
  }*/
/*MessageQueueClient messageQueue = configuration.getMessageQueueFactory().build(environment);*/
MongoCollection<Document> collection;
  @Override
  public void save(Employee employee) {
    final Document saveEmployee =new Document("name", employee.getName())
      .append("address", employee.getAddress())
      .append("employeeId", employee.getEmployeeId());
    collection.insertOne(saveEmployee);
    /*collection.insertOne(employee);*/
    /*MongoCollection<Document> collection = MongoDbConfig;
    collection.insertOne(employee);*/
  }

  @Override
  public List<Employee> getAll() {
    /*collection.find();
    return Employee;*/
    /*Iterable items = (Iterable) collection.find();
    return Lists.newArrayList(items);*/
    return null;
  }
}