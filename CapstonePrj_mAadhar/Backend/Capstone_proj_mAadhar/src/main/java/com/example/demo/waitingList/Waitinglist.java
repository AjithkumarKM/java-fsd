package com.example.demo.waitingList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waitinglist")
public class Waitinglist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int appId;
	public int custId;
	public String status;
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Waitinglist [appId=" + appId + ", custId=" + custId + ", status=" + status + "]";
	}
	public Waitinglist(int custId, String status) {
		super();
		this.custId = custId;
		this.status = status;
	}
	public Waitinglist() {
		super();
	}
	
}
