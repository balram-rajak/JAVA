package com.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RegisterServlet {
	
 private Integer number=0;
	@RequestMapping(value="/Register",method=RequestMethod.GET)
	public String set_newEmployee() {
				
		return "Register";
	}

	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public String newEmployee(@RequestParam String EMP_NAME,ModelMap Employee_name) {
				Employee_name.put("Emp_name",EMP_NAME);
		return "inserted";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public boolean updateEmployee() {
		
		
		return true;
	}

}
