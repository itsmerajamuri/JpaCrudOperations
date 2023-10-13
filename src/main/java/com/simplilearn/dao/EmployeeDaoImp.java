package com.simplilearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Employee;
@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeEmail(rs.getString(3));
				return employee;
			}
			
		});	
	}


	
	public int addEmployee(Employee employee) {
		
		return jdbcTemplate.update("insert into employee (employeeName,employeeEmail) values(?,?)",
				new Object[] {employee.getEmployeeName(),employee.getEmployeeEmail()});
		
		
	}

		


	
	public int updateEmployee(Employee employee) {
		return jdbcTemplate.update("update employee set employeeName=?,employeeEmail=?  where employeeId=?", 
				new Object[] {employee.getEmployeeName(),employee.getEmployeeEmail(),employee.getEmployeeId()});
		
		
	}



	
	public int deleteEmployee(int id) {
		return jdbcTemplate.update("delete from employee where employeeId=?", id);
		
	}



	@Override
	public List<Employee> getById(int id) {
	return	jdbcTemplate.query("select * from employee where EmployeeId=?", new RowMapper<Employee>() {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Employee employee=new Employee();
			employee.setEmployeeEmail(rs.getString(3));
			employee.setEmployeeName(rs.getString(2));
			employee.setEmployeeId(rs.getInt(1));
			return employee;
		}
		
	},id);
		
	}
	
	
	
	

}
