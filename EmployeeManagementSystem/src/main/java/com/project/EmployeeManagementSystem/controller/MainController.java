package com.project.EmployeeManagementSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EmployeeManagementSystem.entity.Country;
import com.project.EmployeeManagementSystem.entity.Employee;
import com.project.EmployeeManagementSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
   MainService service;
	
	@PostMapping("/addCountry")
	public String addCountry(@RequestBody Country c) {
		
		String msg=service.addCountry(c);
		
		return msg;
	}
	
	@PutMapping("/updatecountry/{id}")
	public String updateCountry(@RequestBody Country c,@PathVariable int id) {
		
		String msg=service.updateCountry(c,id);
		
		return msg;
		
	}
	
	@DeleteMapping("/deletecountry/{id}")
	 public String deleteCountry(@PathVariable int id) {
		 
		String msg=service.deleteCountry(id);
		
		return msg;
	 }
	
	@GetMapping("/getalldata")
	public List<Country> getAllData(){
		
		List<Country> list=service.getAllData();
		
		return list;
		
	}
	
	@GetMapping("/getcountrybyid/{id}")
	public Country  getcountrybyid(@PathVariable int id) {
		
		Country c=service.getcountrybyid(id);
	  
		return c;
	
	}

	@PostMapping("/saveemployee")
     public String addEmployee(@RequestBody Employee emp) {
    	 
		String msg=service.addEmployee(emp);
    	 
		return msg;
		
     }	
	
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee emp) {
		
		String msg=service.updateEmployee(emp);
		
		return msg;
		
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		String msg=service.deleteEmployee(id);
		
		return msg;
	}
	
	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployee(){
		
		List<Employee> list=service.getAllEmployee();
		
		return list;
		}
	
	
	@GetMapping("/getbyid/{id}")
	public Employee getById(@PathVariable int id) {
		
		Employee emp=service.getById(id);
		
		return emp;
		
	}
	
	@GetMapping("/getbystatus/{status}")
	public List<Employee> getByStatus(@PathVariable String status) {
		
		List<Employee> list=service.getByStatus(status);
		
		return list;
	
	}
	@GetMapping("/getbydepartemt/{departemt}")
	public List<Employee> getByDepartemt(@PathVariable String departemt){
		
		List<Employee> list=service.getByDepartemt(departemt);
	     return list;
	     
	}
	
	@GetMapping("/getByCountry/{cid}")
	public List<Employee> getByCountry(@PathVariable int cid){
		
		List<Employee> list=service.getByCountry(cid);
	     return list;
	     
	}
	
	@PostMapping("/login")
	public HashMap loginUser(@RequestBody Employee emp) {
		
		HashMap map=service.loginUser(emp);
		
		return map;
	}
	
	
	}
	


