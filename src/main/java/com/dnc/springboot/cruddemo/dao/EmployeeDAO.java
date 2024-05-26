package com.dnc.springboot.cruddemo.dao;

import com.dnc.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
