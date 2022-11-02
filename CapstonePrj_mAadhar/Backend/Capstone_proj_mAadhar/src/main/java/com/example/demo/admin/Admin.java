package com.example.demo.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public String name;
	public String password;
	public Admin(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public Admin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
