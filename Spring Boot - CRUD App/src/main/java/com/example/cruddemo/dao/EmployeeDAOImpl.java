package com.example.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	private EntityManager entityManager;
	

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	public List<Employee> findAll() {
		
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employees=theQuery.getResultList();
		
		return employees;
	}



	@Override
	public Employee findById(int theid) {
		

		Session currentSession=entityManager.unwrap(Session.class);
		
		Employee theEmployee=currentSession.get(Employee.class, theid);
		
		
		return theEmployee;
	}



	@Override
	public void save(Employee theEmployee) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
	}



	@Override
	public void deleteById(int theid) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query thequery=currentSession.createQuery("delete from Employee where id=:employeeId");
		thequery.setParameter("employeeId", theid);
		thequery.executeUpdate();
		
	}

}
