package com.example.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class Admin_rest {
	
	@Autowired
	private Admin_serv admin_serv;
	
	@GetMapping("getAllAdmin")
	public List<Admin> getAllAdmin() {
		return admin_serv.getAllAdmin();
	}
	
	@PostMapping("addAdmin/{name}/{password}")
	public boolean addAdmin(@PathVariable String name,@PathVariable String password) {
		return admin_serv.addAdmin(name,password);
	}
	
	@PutMapping("updateAdmin")
	public String updateAdmin(@RequestBody Admin admin) {
		if(admin_serv.updatePassword(admin.getId(), admin.getPassword()))
			return "password changed successfully";
		return "Password cannot be changed!! check admin id";
	}
	
	@GetMapping("getAdmin/{name}/{password}")
	public boolean findAdmin(@PathVariable String name,@PathVariable String password) {
		return admin_serv.findAdmin(name, password);
	}
}
