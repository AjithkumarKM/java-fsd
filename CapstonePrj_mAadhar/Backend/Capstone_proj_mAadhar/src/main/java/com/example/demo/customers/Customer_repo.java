package com.example.demo.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_repo extends JpaRepository<Customer, Integer>{

	@Query(value = "select max(cust_id) from customers",nativeQuery = true)
	public int getMaxId();
}
