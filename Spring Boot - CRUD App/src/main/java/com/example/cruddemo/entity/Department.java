package com.example.cruddemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="did")
	private int did;
	
	
	@Column(name="department_name")
	private String departName;


	



   public Department() {
		
	}




public Department(int did, String departName) {
	
	this.did = did;
	this.departName = departName;
	
}




public int getDid() {
	return did;
}




public void setDid(int did) {
	this.did = did;
}




public String getDepartName() {
	return departName;
}




public void setDepartName(String departName) {
	this.departName = departName;
}






@Override
public String toString() {
	return "Department [did=" + did + ", departName=" + departName + "]";
}
	
   
	
	



	

}
