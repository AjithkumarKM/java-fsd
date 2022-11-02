package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.Employee_serv;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class Employee_rest {
	
	@Autowired
	private Employee_serv employee_serv;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employee_serv.addEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		System.out.println("getting all employees");
		return employee_serv.getAllEmployee();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		System.out.println(id);
		return employee_serv.getEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public boolean updateEmployee(@RequestBody Employee employee) {
		System.out.println("updating "+employee.id);
		if( employee_serv.updateEmployee(employee)==true)
			return true;
		return false;
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public boolean deleteEmployeeById(@PathVariable int id) {
		return employee_serv.deleteEmployeeById(id);
	}
}
