package com.project.EmployeeManagementSystem.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cid")
	Country country;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  int id;
	  String name;
	  String phoneno;
	  // developer,marketing,testing
	  String departemt;
	  // status =>active , inactive ,suspended.
	  String status;
	  Date crerateddate;
	  String createdby; 
	  Date updateddate;
	  String updatedby;    
	  		
	 
	 
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	
	
}
