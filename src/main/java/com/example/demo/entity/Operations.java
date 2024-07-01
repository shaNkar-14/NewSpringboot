package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Operations {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String company;
	private String salary;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Operations(long id, String name, String email, String company, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.company = company;
		this.salary = salary;
	}
	public Operations() {
		super();
	}
	@Override
	public String toString() {
		return "Operations [id=" + id + ", name=" + name + ", email=" + email + ", company=" + company + ", salary="
				+ salary + "]";
	}
	
}
