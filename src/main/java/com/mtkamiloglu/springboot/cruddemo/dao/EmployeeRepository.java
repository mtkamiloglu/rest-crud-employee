package com.mtkamiloglu.springboot.cruddemo.dao;

import com.mtkamiloglu.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // there is no need for the implementation class
}
