package com.example.demo.customers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="customers")
public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int custId;
	public String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	public Date dob;
	public String email;
	public long phoneNo;
	public String gender;
	public String addressLine;
	public String city;
	public String district;
	public String state;
	public long pincode;
	public int getId() {
		return custId;
	}
	public void setId(int id) {
		this.custId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public Customer(int id, String name, Date dob, String email, long phoneNo, String gender, String addressLine,
			String city, String district, String state, long pincode) {
		super();
		this.custId = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.addressLine = addressLine;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	public Customer(String name, Date dob, String email, long phoneNo, String gender, String addressLine,
			String city, String district, String state, long pincode) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.addressLine = addressLine;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + custId + ", name=" + name + ", dob=" + dob + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", gender=" + gender + ", addressLine=" + addressLine + ", city=" + city + ", district=" + district
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

	
}
