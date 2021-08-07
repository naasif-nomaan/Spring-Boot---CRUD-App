package com.example.cruddemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;



@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="did")
	private int did;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "did", referencedColumnName = "id", insertable = false, updatable = false)
    private Department department;
	
	
	
	
	public Employee() {
		
	}


	public Employee(int id, String firstName, String lastName, String email, int did, Department department) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.did = did;
		this.department = department;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}



	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", did=" + did + ", department=" + department + "]";
	}

	


	


	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
