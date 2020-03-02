package com.example.springbootproject.dao;

import com.example.springbootproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //public List<Employee> findAllByOrderByFirstNameAsc();
}
