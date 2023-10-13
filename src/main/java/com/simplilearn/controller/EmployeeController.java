package com.simplilearn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.dao.EmployeeDaoImp;
import com.simplilearn.entity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDaoImp daoImp;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return daoImp.getAllEmployees();	
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		return daoImp.addEmployee(employee)+"successfully added";
	}
	
	@PutMapping("/employee/{id}")
	public String UpdateEmployee(@RequestBody Employee employee,@PathVariable int id) {
		
		return daoImp.updateEmployee(employee)+"updated successfully";	
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		return daoImp.deleteEmployee(id)+"deleted successfully";
		
	}
	
	@GetMapping("/employee/{id}")
	public List<Employee> getById(@PathVariable int id){
		
		return daoImp.getById(id);
	}
	
	
}
