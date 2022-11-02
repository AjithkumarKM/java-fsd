package com.example.demo.waitingList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.admin.Admin;

@Repository
public interface WaitingList_repo extends JpaRepository<Waitinglist, Integer>{

	@Query(value="select * from waitinglist where cust_id=:cid",nativeQuery = true)
	Waitinglist getApplicationByCid(@Param("cid") int cid);
}
