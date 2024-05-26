package com.dnc.springboot.cruddemo.service;

import com.dnc.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
