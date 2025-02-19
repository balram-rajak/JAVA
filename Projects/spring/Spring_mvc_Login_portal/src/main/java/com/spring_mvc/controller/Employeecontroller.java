package com.spring_mvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.repository.Repo;
import com.spring_mvc.repository.entity.EMP_DETAILS;
@Controller
public class Employeecontroller {
	
	@Autowired
	private Repo repository;
	
	@RequestMapping(value="/Employee",method = RequestMethod.GET) 
	@ResponseBody
	public Object displayEmployee() {
		
		
		EMP_DETAILS e1=new EMP_DETAILS(1,"fer","fer","fer",true);
		return e1;
		
	}
	
	@RequestMapping(value="/Employee/{EmployeeId}")
	@ResponseBody
	public Object displaybyId(@PathVariable Integer EmployeeId) {
		return repository.getEmployeesbyId(EmployeeId);
	}
	
	@RequestMapping(value="/Employee/delete/{EmployeeId}",method = RequestMethod.GET) 
	@ResponseBody
	public boolean deleteEmployeebyId(@PathVariable Integer EmployeeId) {
		EMP_DETAILS e1=new EMP_DETAILS(1,"fer","fer","fer",true);
		return true;
		
	}
	
	
}
