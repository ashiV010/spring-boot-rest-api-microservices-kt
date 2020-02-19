package com.accenture.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accenture.Repository.EmployeeRepository;
import com.accenture.model.Employee;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/* Save an Employee */
	
	public Employee Save(Employee emp) {
		System.out.println("save dao class");
		return employeeRepository.save(emp);
	}
	
	/* Search all Employee */
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	/* get an Employee */
	public Optional<Employee> findOne(Long empid) {
		
		return employeeRepository.findById(empid);
	
	}
	
	
	/* delete an Employee */
	public void delete(Employee emp)
	{
		employeeRepository.delete(emp);
	}
	
}
