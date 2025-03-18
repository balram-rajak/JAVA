package com.springproject1.project1.scope;

public class EmployeeDao implements DAO{
	

	private Jdbcconnection jdbcconnection;

	public Jdbcconnection getJdbcconnection() {
		return jdbcconnection;
	}

	public void setJdbcconnection(Jdbcconnection jdbcconnection) {
		this.jdbcconnection = jdbcconnection;
	}

	
	
	
}
