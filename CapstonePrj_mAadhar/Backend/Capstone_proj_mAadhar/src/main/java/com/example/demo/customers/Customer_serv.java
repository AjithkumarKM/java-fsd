package com.example.demo.customers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customer_serv {

	@Autowired
	private Customer_repo customer_repo;
	
	public Customer addCustomer(Customer customer) {
		//address_repo.save(customer.getAddress());
		System.out.println(customer);
		return customer_repo.save(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return customer_repo.findAll();
	}
	
	public boolean deleteCustomer(int id) {
		Customer cust =  customer_repo.findById(id).orElse(null);
		if(cust!=null) {
			customer_repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Customer findCustomerById(int id) {
		return customer_repo.findById(id).orElse(null);
	}
	
	public boolean updateCustomer(Customer customer) {
		Customer cust = customer_repo.findById(customer.getId()).orElse(null);
		System.out.println("Updating customer details " + customer);
		if(cust!=null) {
			cust.setName(customer.getName());
			cust.setEmail(customer.getEmail());
			cust.setPhoneNo(customer.getPhoneNo());
			cust.setDob(customer.getDob());
			cust.setGender(customer.getGender());
			cust.setAddressLine(customer.getAddressLine());
			cust.setCity(customer.getCity());
			cust.setDistrict(customer.getDistrict());
			cust.setState(customer.getState());
			cust.setPincode(customer.getPincode());
			customer_repo.save(cust);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean loginCustomer(int custId,Long password) {
		Customer customer = customer_repo.findById(custId).orElse(null);
		if(customer!=null) {
			if(password==customer.getPhoneNo())
				return true;
		}
		return false;
	}
	
	public int getMaxId() {
		return customer_repo.getMaxId();
	}
}
