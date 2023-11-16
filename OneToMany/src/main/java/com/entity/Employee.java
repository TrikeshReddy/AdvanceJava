package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Employee {
	@Id
	private int EmpId;
	private String EmpName;
	private int Sal;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Laptop> listOfLaptops;
	
	public List<Laptop> getListOfLaptops() {
		return listOfLaptops;
	}
	public void setListOfLaptops(List<Laptop> listOfLaptops) {
		this.listOfLaptops = listOfLaptops;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public int getSal() {
		return Sal;
	}
	public void setSal(int sal) {
		Sal = sal;
	}
	
	
}
