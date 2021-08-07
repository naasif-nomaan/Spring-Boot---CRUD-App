package com.example.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeServ;

	@Autowired
	public EmployeeRestController(EmployeeService employeeserv) {
		this.employeeServ = employeeserv;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeServ.findAll();
	}
	
	@GetMapping("/employees/{emplId}")
	public Employee findById(@PathVariable int emplId) {
		
		Employee theemployee=employeeServ.findById(emplId);
		
		if(theemployee==null) {
			throw new RuntimeException("Employee Id not found :"+theemployee );
		}
		
		return theemployee;
	}
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		System.out.println("inside addemployee:"+employee);
		
		employee.setId(0);
		
		employeeServ.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeServ.save(employee);
		
		return employee;
	}
	
	
	@GetMapping("/employees/del/{emplId}")
	public void deleteById(@PathVariable int emplId) {
		
		employeeServ.deleteById(emplId);
		
	}
	
	

}



