package com.java.repository;


import com.java.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
  void save(Employee employee);

  List<Employee> getAll();
  /*T save(T model);
  List<T> getAll();*/
}
