package com.spring_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring_mvc.repository.entity.EMP_DETAILS;

@Repository
@Transactional
public class EmployeeRepository implements Repo{

	@PersistenceContext
	EntityManager entitymanager;
	
public EMP_DETAILS getEmployeesbyId(int S_NO){
		
		//List<EMP_DETAILS> e1=new ArrayList<EMP_DETAILS>();
		
		return entitymanager.find(EMP_DETAILS.class, S_NO);
		
		
	}

public List<EMP_DETAILS> getallEmployees(){
	
	TypedQuery<EMP_DETAILS> query=entitymanager.createNamedQuery("SELECT * FROM EMP_DETAILS;", EMP_DETAILS.class);

return query.getResultList();
}
}
