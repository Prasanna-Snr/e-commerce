package com.spring.myProject.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user" )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String email;
	private Date dob;
	private String uname;
	private String psw;
	private String gender;
	private String phone;
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getEmail() {
		return email;
	}
	public Date getDob() {
		return dob;
	}
	public String getUname() {
		return uname;
	}
	public String getPsw() {
		return psw;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
