package com.star.employee.service;

import java.util.List;

import javax.el.ELException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.star.employee.VO.Employee;
import com.star.employee.dao.Mapper;

@Service
public class EmployeeService implements IEmployeeService{


	private Mapper empDao;
	
	public Mapper getEmpDao() {
		return empDao;
	}

	@Autowired
	public void setEmpDao(Mapper empDao) {
		this.empDao = empDao;
	}



@Transactional
	public boolean addEmployee(Employee emp) {
		
	
	try {
		if (emp == null) {
			return false;
		}
			this.getEmpDao().save(emp);
		}
		catch (ELException ex) {
			return false;
		}
		
		return true;
	}
	
	
	

	public Employee findById(Integer id) {
		
		try {
			Employee emp = this.getEmpDao().findById(id);
			System.out.println("empServ : " + emp.getFirstname());
			return emp;
		}catch (PersistenceException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
