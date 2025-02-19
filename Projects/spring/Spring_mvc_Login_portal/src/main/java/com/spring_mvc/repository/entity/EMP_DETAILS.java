package com.spring_mvc.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EMP_DETAILS {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int S_NO;
	
	@Column(unique = true)
	private int EMP_NO;
	
	private String EMP_NAME;
    private String DEPT;
    private String PROJECT;
    private boolean STATUS;
    
	public EMP_DETAILS() {
		
		
	}
	
	public int getS_NO() {
		return S_NO;
	}

	public void setS_NO(int s_NO) {
		S_NO = s_NO;
	}

	public int getEMP_NO() {
		return EMP_NO;
	}

	public void setEMP_NO(int eMP_NO) {
		EMP_NO = eMP_NO;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public String getDEPT() {
		return DEPT;
	}

	public void setDEPT(String dEPT) {
		DEPT = dEPT;
	}

	public String getPROJECT() {
		return PROJECT;
	}

	public void setPROJECT(String pROJECT) {
		PROJECT = pROJECT;
	}

	public boolean isSTATUS() {
		return STATUS;
	}

	public void setSTATUS(boolean sTATUS) {
		STATUS = sTATUS;
	}
	public EMP_DETAILS(int id,String name, String dept,String project,boolean status) {
	    super();
	    
	    this.EMP_NO=id;
	    this.EMP_NAME = name;
	    this.DEPT = dept;
	    this.PROJECT = project;
	    this.STATUS=status;
	    
	}
	    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+EMP_NO+EMP_NAME+DEPT+PROJECT+STATUS;
	}
}
