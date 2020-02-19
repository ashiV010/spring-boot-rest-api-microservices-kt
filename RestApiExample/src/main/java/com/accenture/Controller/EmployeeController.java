package com.accenture.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.DAO.EmployeeDAO;
import com.accenture.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	/* save an employee */

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp ) {
		
		System.out.println("create emp");
		return employeeDAO.Save(emp);
	}

	/* get all employee */

	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		System.out.println("controller class");
		return employeeDAO.findAll();
	}

	/*
	 * get employee by empid*/
	 
	  @GetMapping("/notes/{id}")
	  public ResponseEntity<Optional<Employee>>
	  getEmployeeId(@PathVariable(value="id") Long empid)
	  {  
		  Optional<Employee> emp=employeeDAO.findOne(empid); 
		  if(emp==null) { 
		  return ResponseEntity.notFound().build(); } 
		  return ResponseEntity.ok().body(emp);
	 }
///*update an employee by empid */
//	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails) {
//		Employee emp=employeeDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();		}
//		emp.setName(empDetails.getName());
//		emp.setDesignation(empDetails.getDesignation());
//		emp.setExpertise(empDetails.getExpertise());
//		
//		Employee updateEmployee=employeeDAO.Save(emp);
//		return ResponseEntity.ok().body(updateEmployee);
//	}
//	
//	/* Delete an Employee */
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid) {
//		Employee emp=employeeDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();		}
//		
//		employeeDAO.delete(emp);
//		return ResponseEntity.ok().body(emp);
//	}
//	

}
