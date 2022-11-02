package com.example.demo.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_repo extends JpaRepository<Admin, Integer>{

	@Query( value = "SELECT * FROM admin WHERE admin.name = :name", 
			  nativeQuery = true)
	Admin getAdmin(@Param("name") String name);
}
