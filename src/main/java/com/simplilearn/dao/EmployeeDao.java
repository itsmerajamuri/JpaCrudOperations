package com.simplilearn.dao;

import java.util.List;
import com.simplilearn.entity.Employee;

public interface EmployeeDao {
	
	  
	  public List<Employee> getAllEmployees();
	  
	  public int addEmployee(Employee employee);
	  
	  public int updateEmployee(Employee employee);
	  
	  public int deleteEmployee(int id);
	  
	  public List<Employee> getById(int id);

}
