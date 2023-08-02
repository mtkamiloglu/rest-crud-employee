package com.mtkamiloglu.springboot.cruddemo.controller;

import com.mtkamiloglu.springboot.cruddemo.entity.Employee;
import com.mtkamiloglu.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // in case they pass an id JSON set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{theId}")
    public String deleteEmployee(@PathVariable int theId){

        Employee dbEmployee = employeeService.findById(theId);

        if (dbEmployee == null){
            throw new RuntimeException("Employee id not found: " + theId);
        }

        employeeService.deleteById(theId);

        return "Employee deleted with the id: " + theId;
    }

}
