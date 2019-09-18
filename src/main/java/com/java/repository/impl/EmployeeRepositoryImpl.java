package com.java.repository.impl;

import com.java.db.MongoDb;
import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements EmployeeRepository {

  public EmployeeRepositoryImpl(MongoDb mongoManager, Class<Employee> clazz) throws Exception {
      super(mongoManager, clazz);
  }
}
