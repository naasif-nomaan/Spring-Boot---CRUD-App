package com.example.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImp implements EmployeeService{
	
	
	private EmployeeDAO theemployeedao;
	 
	@Autowired
	public EmployeeServiceImp(EmployeeDAO theemployeedao) {
	
		this.theemployeedao = theemployeedao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return theemployeedao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theid) {
		// TODO Auto-generated method stub
		return theemployeedao.findById(theid);
	}

	@Override
	@Transactional
	public void save(Employee theemployee) {
		theemployeedao.save(theemployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theid) {
		theemployeedao.deleteById(theid);
		
	}
	
	
	
	

}
