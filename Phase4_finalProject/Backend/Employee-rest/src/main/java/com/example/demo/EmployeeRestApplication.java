package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.services.Employee_serv;

@SpringBootApplication
public class EmployeeRestApplication implements CommandLineRunner{

	@Autowired
	private Employee_serv employee_serv;
	
	public static void main(String[] args){
		SpringApplication.run(EmployeeRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//employee_serv.addEmployee(new Employee("Ajith","ajith@gmail.com","FSD",30000));
	}

}
