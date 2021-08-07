package com.example.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Employee;


@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO {
	
	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeJpaDAOImpl(EntityManager theentitymanager){
		this.entityManager=theentitymanager;
		
	}

	
	@Override
	public List<Employee> findAll() {
		
		Query thequery=entityManager.createQuery("from Employee");
		
		List<Employee> employees=thequery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theid) {
		
		Employee theemployee=entityManager.find(Employee.class, theid);
		
		return theemployee;
	}

	@Override
	public void save(Employee theEmployee) {
	
		Employee employee=entityManager.merge(theEmployee);
		
		theEmployee.setId(employee.getId());
		
		
	}

	@Override
	public void deleteById(int theid) {
	
		Query query=entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theid);
		query.executeUpdate();
		
		
	}

}
