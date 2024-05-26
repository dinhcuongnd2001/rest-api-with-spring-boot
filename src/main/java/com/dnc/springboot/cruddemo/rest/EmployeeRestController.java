package com.dnc.springboot.cruddemo.rest;

import com.dnc.springboot.cruddemo.dao.EmployeeDAO;
import com.dnc.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //    quick and dirty: inject employee dao
    private EmployeeDAO employeeDAO;

//    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

}
