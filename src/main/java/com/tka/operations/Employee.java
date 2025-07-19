package com.tka.operations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee",schema = "capgemini")
public class Employee {
	
	@Id
	private int id;
	private String name;
    private String profile;
    private String email;
    private int salary;
    private int age;
    private int experiance;
    @Column(name = "branch_loc")
    private String loc;
    
    
	public Employee() {
		super();
	}
	
	
	public Employee(int id, String name, String profile, String email, int salary, int age, int experiance,
			String loc) {
		super();
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.email = email;
		this.salary = salary;
		this.age = age;
		this.experiance = experiance;
		this.loc = loc;
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperiance() {
		return experiance;
	}
	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", profile=" + profile + "]";
	}
    
    
	 

}
