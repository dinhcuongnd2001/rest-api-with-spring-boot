package com.dnc.springboot.cruddemo.rest;

import com.dnc.springboot.cruddemo.dao.EmployeeDAO;
import com.dnc.springboot.cruddemo.entity.Employee;
import com.dnc.springboot.cruddemo.service.EmployeeService;
import com.dnc.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //    quick and dirty: inject employee dao
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = this.employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return this.employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee theEmployee) {
        return this.employeeService.save(theEmployee);
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee foundEmployee = this.employeeService.findById(employeeId);
        if(foundEmployee == null) {
            throw new RuntimeException("Not Found Employee - " + employeeId);
        }
        this.employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
