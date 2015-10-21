package com.star.employee.service;

import java.util.List;

import com.star.employee.VO.Employee;

public interface IEmployeeService {

	
	boolean addEmployee(Employee emp);
	
	Employee findById(Integer id);
	
	List<Employee> findAll();

	void saveOrUpdate(Employee emp);
	
	void delete(int id);
	
	
	
}
