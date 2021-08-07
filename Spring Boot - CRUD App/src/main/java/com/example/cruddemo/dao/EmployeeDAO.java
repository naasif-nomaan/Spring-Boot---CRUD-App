package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theid);

}
