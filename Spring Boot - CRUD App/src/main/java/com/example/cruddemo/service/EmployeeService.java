package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theemployee);
	
	public void deleteById(int theid);

}
