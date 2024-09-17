package com.project.EmployeeManagementSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EmployeeManagementSystem.dao.MainDao;
import com.project.EmployeeManagementSystem.entity.Country;
import com.project.EmployeeManagementSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country c) {
		
		String msg=dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country  Is Not Addaded...";
		}
		
		return msg;
	}

	public String updateCountry(Country c, int id) {
		
		String msg=dao.updateCountry(c,id);
		
		if(Objects.isNull(msg)) {
			
			msg="Country Is Not Addaded..";
		}
		
			return msg;
	}

	public String deleteCountry(int id) {
		
		String msg=dao.deleteCountry(id);
		
		if(Objects.isNull(msg)) {
			msg="Country Is Not Deleted..";
		}
		
		return msg;
	}

	public List<Country> getAllData() {
		
		List<Country> list=dao.getAllData();
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}

	public Country getcountrybyid(int id) {
		
		Country c=dao.getcountrybyid(id);
		
		if(Objects.isNull(c)) {
			c=null;
		}
		
		return c;
	}

	public String addEmployee(Employee emp) {
		
		String msg=dao.addEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg="Employee Is Not Addaded..";
		}
		
		return msg;
	}

	public String updateEmployee(Employee emp) {
		
		String msg=dao.updateEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg="Employee Is Not Updated... ";
		}
		
		return msg;
	}

	public String deleteEmployee(int id) {
	
		String msg=dao.deleteEmployee(id);
		
			if(Objects.isNull(msg)) {
			
				msg="Employee Is Not Deleted...";
			}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		List<Employee> list=dao.getAllEmployee();
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}

	public Employee getById(int id) {
		
		Employee emp=dao.getById(id);
		
		if(Objects.isNull(emp)) {
			
			emp=null;
		}
		return emp;
	}

	public List<Employee> getByStatus(String status) {
		
		List<Employee> list=dao.getByStatus(status);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}

	public List<Employee> getByDepartemt(String departemt) {
		
		List<Employee> list=dao.getByDepartemt(departemt);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}

	public List<Employee> getByCountry(int cid) {

		List<Employee> list=dao.getByCountry(cid);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		
		return list;
	}

	public HashMap loginUser(Employee emp) {
		
		Employee e=dao.loginUser(emp);
		 
		HashMap map=new HashMap();
		
		if(Objects.isNull(e)) {
			//invalid user
		
			map.put("msg","Invalid User");
			map.put("user",e);
		}else {
			//valid user
			map.put("msg","Valid User");
			map.put("user",e);
			
		}
		return map;
	}

	
	}

	

	
	
	
	

	
	
	


