package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.Employee_repo;

@Service
public class Employee_serv {

	@Autowired
	private Employee_repo employee_repo;
	
	public Employee addEmployee(Employee employee){
		return employee_repo.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		
		return employee_repo.findAll();
	}
	
	public boolean updateEmployee(Employee employee) {
		Employee emp =  employee_repo.findById(employee.id).orElse(null);
		System.out.println("Updating");
		if(emp!=null) {
			emp.setName(employee.name);
			emp.setEmail(employee.email);
			emp.setDesignation(employee.designation);
			emp.setSalary(employee.salary);
			employee_repo.save(emp);
			return true;
		}
		return false;
	}
	
	public Employee getEmployeeById(int id){
		return employee_repo.findById(id).orElse(null);
	}
	
	public boolean deleteEmployeeById(int id) {
		Employee emp =  employee_repo.findById(id).orElse(null);
		if(emp!=null)
			{
				employee_repo.deleteById(id);
				return true;
			}
		return false;
	}
}
