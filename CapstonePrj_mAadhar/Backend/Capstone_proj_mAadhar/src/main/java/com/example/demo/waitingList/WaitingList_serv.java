package com.example.demo.waitingList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitingList_serv {

	@Autowired
	private WaitingList_repo waitingList_repo;
	
	public boolean addApplication(String cid, String status) {
		int custId = Integer.parseInt(cid);
		Waitinglist tempAppl = waitingList_repo.getApplicationByCid(custId);
		if(tempAppl==null) {
			Waitinglist newAppl = new Waitinglist(custId, status);
			waitingList_repo.save(newAppl);			
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Waitinglist> getAllApplication() {
		return waitingList_repo.findAll();
	}
	
	public Waitinglist getApplicationById(String cid) {
		int custId = Integer.parseInt(cid);
		return waitingList_repo.findById(custId).orElse(null);
	}
	
	public boolean deleteApplication(int cid) {
		//int custId = Integer.parseInt(cid);
		Waitinglist tempAppl = waitingList_repo.getApplicationByCid(cid);
		if(tempAppl!=null) {
			waitingList_repo.deleteById(tempAppl.getAppId());
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean acceptStatus(int cid) {
		Waitinglist tempAppl = waitingList_repo.getApplicationByCid(cid);
		if(tempAppl!=null) {
			System.out.println(tempAppl);
			tempAppl.setStatus("Accepted");
			waitingList_repo.save(tempAppl);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean rejectStatus(int cid) {
		Waitinglist tempAppl = waitingList_repo.getApplicationByCid(cid);
		if(tempAppl!=null) {
			System.out.println(tempAppl);
			tempAppl.setStatus("Rejected");
			waitingList_repo.save(tempAppl);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
