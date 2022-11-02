package com.example.demo.waitingList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("application")
public class Waiting_rest {

	@Autowired
	private WaitingList_serv waitingList_serv;
	
	@GetMapping("getAllApplication")
	public List<Waitinglist> getAllApplication() {
		return waitingList_serv.getAllApplication();
	}
	
	@GetMapping("getApplicationById/{cid}")
	public Waitinglist getApplicationById(@PathVariable String cid) {
		return waitingList_serv.getApplicationById(cid);
	}
	
	@PostMapping("addNewApplication/{cid}")
	public boolean addNewApplication(@PathVariable String cid) {
		System.out.println("addNewApplication called");
		return waitingList_serv.addApplication(cid, "Applied");
	}
	
	@DeleteMapping("deleteApplication/{cid}")
	public boolean deleteApplication(@PathVariable int cid) {
		return waitingList_serv.deleteApplication(cid);
	}
	
	@PutMapping("acceptAppl/{cid}")
	public boolean acceptAppl(@PathVariable int cid) {
		System.out.println("Accepting customer " + cid);
		return waitingList_serv.acceptStatus(cid);
	}
	
	@PutMapping("rejectAppl/{cid}")
	public boolean rejectAppl(@PathVariable int cid) {
		System.out.println("Rejecting customer " + cid);
		return waitingList_serv.rejectStatus(cid);
	}
}
