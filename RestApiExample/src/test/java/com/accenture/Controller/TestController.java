package com.accenture.Controller;




import static org.junit.Assert.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.Employee;


/**
 * Junit test class for EventController
 * 
 */
public class TestController {

	private Employee createEmployee;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession session;
	private EmployeeController controller;


	/**
	 * Sets up initial objects required in other methods
	 * @return 
	 * 
	 * @throws Exception
	 */
	@org.junit.Before
	public  void setUp() throws Exception {
	createEmployee = new Employee();
		session = new MockHttpSession();
		response = new MockHttpServletResponse();
		request= new MockHttpServletRequest();
		controller=new EmployeeController();
		
		
	}

	/**
	 * Deallocate the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null
		 */
		createEmployee = null;
		request=null;
		response=null;
		controller=null;
		
		
	}

	/**
	 * Test case to test the positive scenario for getAvailableEvents method
	 */
	@Test
	public void testcreateEmployee() {

		try {
		
//			MockHttpServletRequest request = new MockHttpServletRequest("POST", "/company/employees/");
//			request.setParameter("name", "ashish");
//			request.setParameter("designation", "ase");
//			request.setParameter("expertise", "java");
			MockHttpServletResponse response= new MockHttpServletResponse();
			 Employee employee = new Employee("vats","ase","kuch bhi ni",null);
			 controller.createEmployee(employee);
		       
		     assertNotNull(employee);
		       
		       		} catch (Exception exception) {
			
		}
		
	}
}
