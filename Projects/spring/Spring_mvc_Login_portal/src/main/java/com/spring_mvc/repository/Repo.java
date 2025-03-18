package com.spring_mvc.repository;

import java.util.List;

import com.spring_mvc.repository.entity.EMP_DETAILS;

public interface Repo {

	
	public EMP_DETAILS getEmployeesbyId(int Id);
	
}
