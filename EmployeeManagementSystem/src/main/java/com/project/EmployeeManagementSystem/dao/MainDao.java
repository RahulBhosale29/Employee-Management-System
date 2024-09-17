package com.project.EmployeeManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.EmployeeManagementSystem.entity.Country;
import com.project.EmployeeManagementSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
		
		session=factory.openSession();
	    tx=session.beginTransaction();
		
	    session.persist(c);
	    tx.commit();
	    msg="Data Addaded Successfully...";
		} catch (Exception e) {
			if(tx!=null) {
				
				tx.rollback();
			
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}	
		}
		
		return msg;
		
		}

	public String updateCountry(Country c, int id) {
	
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
		
		session=factory.openSession();
		
		tx=session.beginTransaction();
		
		Country con=session.get(Country.class, id);
		
		 con.setCname(c.getCname());
		
		 session.merge(con);
		 tx.commit();
		 msg="Country Is Updated Successfully..";
		} catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
		
		return msg;
	}

	public String deleteCountry(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Country con=session.get(Country.class, id);
		
		session.remove(con);
		tx.commit();
		msg="Country Deleted Successfully... ";
		
		} catch (Exception e) {
			// TODO: handle exception
		  e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Country> getAllData() {
		
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		String hqlQuery="from Country";
		
		try {
			   session=factory.openSession();
			   tx=session.beginTransaction();
			 
			Query<Country> query =session.createQuery(hqlQuery,Country.class);
			   
			list=query.list();
			
			tx.commit();
			   
		} catch (Exception e) {

			if(tx!=null) {
			tx.rollback();	
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Country getcountrybyid(int id) {
		
		Session session=null;
		Transaction tx=null;
		Country con=null;
		
		try {
			
			session=factory.openSession();
			session.beginTransaction();
			
			con =session.get(Country.class, id);
		 
			tx.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			e.printStackTrace();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return con;
	}

	public String addEmployee(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
		
		session=factory.openSession();
		tx=session.beginTransaction();
		
		session.persist(emp);
		tx.commit();
		msg="Employee Addaded Successfully...";
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			
			e.printStackTrace();
		}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String updateEmployee(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Employee e=session.get(Employee.class,emp.getId());
		     
		e.setName(emp.getName());
		e.setDepartemt(emp.getDepartemt());
		e.setPhoneno(emp.getPhoneno());
		e.setStatus(emp.getStatus());
		
		session.merge(e);
		tx.commit();
		msg="Employee Is Updated Successfully...";
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.commit();
				e.printStackTrace();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
	
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Employee emp=session.get(Employee.class, id);
		
		session.remove(emp);
		tx.commit();
		msg="Employee Is Deleted Successful..";
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		
		String hqlQuery="from Employee";
		
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
		
		list=query.list();
		tx.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public Employee getById(int id) {
		
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		
		emp=session.get(Employee.class, id);
		tx.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return emp;
	}

	public List<Employee> getByStatus(String status) {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where status=:status";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("status", status);
			
			list=query.list();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return list;
	}

	public List<Employee> getByDepartemt(String departemt) {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where departemt=:departemt";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("departemt", departemt);
			
			list=query.list();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public List<Employee> getByCountry(int cid) {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where country.cid=:cid";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("cid", cid);
			
			list=query.list();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public Employee loginUser(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String hqlQuery="from Employee where name=:name and phoneno=:phoneno";
		Employee employee=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("name", emp.getName());
			query.setParameter("phoneno", emp.getPhoneno());
			
			employee=query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return  employee;
	}


	}
