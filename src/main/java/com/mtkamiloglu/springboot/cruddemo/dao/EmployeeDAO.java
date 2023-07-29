package com.mtkamiloglu.springboot.cruddemo.dao;

import com.mtkamiloglu.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
