package com.example.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_serv {

	@Autowired
	private Admin_repo adminRepo;
	
	public boolean addAdmin(String username, String password) {
		Admin adminTemp = adminRepo.getAdmin(username);
		if(adminTemp!=null)
			return false;
		else {
			Admin newAdmin = new Admin(username,password);
			adminRepo.save(newAdmin);
			return true;
		}
	}
	
	public List<Admin> getAllAdmin(){
		return (List<Admin>) adminRepo.findAll();
	}
	
	public boolean updatePassword(int id,String password) {
		Admin admin = adminRepo.findById(id).orElse(null);
		if(admin!=null) {
			admin.setPassword(password);
			adminRepo.save(admin);
			return true;
		}
		return false;
	}
	
	public boolean findAdmin(String name, String password) {
		Admin tempAdmin = adminRepo.getAdmin(name);
		
		if(tempAdmin!=null) {
			String fetchedPass = tempAdmin.getPassword();
			System.out.println("ADmin password ::"+fetchedPass + "input password is " + password);
			if(password.equals(fetchedPass)) {
				System.out.println("ADmin found and valid");
				return true;
			}
			else
				return false;
		}
		return false;
	}
}
