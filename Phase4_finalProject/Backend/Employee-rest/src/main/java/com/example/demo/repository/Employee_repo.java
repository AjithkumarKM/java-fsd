package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface Employee_repo extends JpaRepository<Employee, Integer>{

}
