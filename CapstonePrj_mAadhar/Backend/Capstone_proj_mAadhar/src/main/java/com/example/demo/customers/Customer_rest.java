package com.example.demo.customers;

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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class Customer_rest {

	@Autowired
	private Customer_serv customer_serv;
	
	@GetMapping("loginCustomer/{cid}/{password}")
	public boolean loginCustomer(@PathVariable String cid, @PathVariable String password) {
		int custId = Integer.parseInt(cid);
		long custPassword = Long.parseLong(password);
		return customer_serv.loginCustomer(custId, custPassword);
	}
	
	@GetMapping("getAllCustomers")
	public List<Customer> getAllCustomers() {
		return customer_serv.getAllCustomers();
	}
	
	@GetMapping("findCustomerById/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		System.out.println("Get customer " + customer_serv.findCustomerById(id));
		return customer_serv.findCustomerById(id);
	}
	
	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
//		if(customer_serv.addCustomer(customer)!=null) {
//			return true;
//		}
//		else {
//			return false;
//		}
		return customer_serv.addCustomer(customer);
	}
	
	@PutMapping("updateCustomer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		if(customer_serv.updateCustomer(customer))
			return true;
		else
			return false;
	}
	
	@DeleteMapping("deleteCustomer/{id}")
	public boolean deleteCustomer(@PathVariable int id) {
		if (customer_serv.deleteCustomer(id))
			return true;
		else
			return false;
			
	}
	
	@GetMapping("getMaxId")
	public int getMaxId() {
		return customer_serv.getMaxId();
	}
}
