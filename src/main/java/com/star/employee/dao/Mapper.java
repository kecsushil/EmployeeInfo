package com.star.employee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

import com.star.employee.VO.Employee;

public interface Mapper {

	@Select("select * from employeeinfo where employee_id = ${id}")
	//@ResultMap("employee")
	Employee findById(Integer id) throws PersistenceException;

	
	List<Employee> findAll();
	
	@Insert("INSERT INTO EMPLOYEEINFO (first_name, last_name, street, city , state, zipcode,country) VALUES (#{firstname},#{lastname},#{street},#{city},#{state},#{zipcode},#{country})")
	@Options(useGeneratedKeys=true, keyProperty="employee_id", flushCache=true, keyColumn="employee_id")
	public boolean save(Employee emp) throws PersistenceException;

	void update(Employee emp);

	void delete(Integer id);
	
	
	
}
