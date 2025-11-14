package com;

import java.util.Objects;

/**
 * Data model class representing an employee's information.
 * This class encapsulates employee details including personal information,
 * department, designation, and salary components.
 * 
 * @author Balram Rajak
 */
public class Data {
	
	@Override
	public int hashCode() {
		return Objects.hash(basicSalary, da, department, designation, designationcode, emp_name, emp_no, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return basicSalary == other.basicSalary && da == other.da && Objects.equals(department, other.department)
				&& Objects.equals(designation, other.designation)
				&& Objects.equals(designationcode, other.designationcode) && Objects.equals(emp_name, other.emp_name)
				&& emp_no == other.emp_no && salary == other.salary;
	}

	/** Employee number - unique identifier */
	private int emp_no;
	
	/** Employee name */
	private String emp_name;

	/** Designation code - single character code representing job role */
	private String designationcode;
	
	/** Department name where employee works */
	private String department;
	
	/** Basic salary component */
	private int basicSalary;
	
	/** Dearness Allowance - calculated based on designation */
	private int da;
	
	/** Total salary (basicSalary + da) */
	private int salary;
	
	/** Full designation/job title */
	private String designation;

	/**
	 * Constructor to create an employee data object.
	 * Automatically calculates DA and total salary based on designation code.
	 * 
	 * @param emp_no Employee number
	 * @param emp_name Employee name
	 * @param designationcode Single character code for designation (e, c, k, r, m)
	 * @param department Department name
	 * @param basicSalary Basic salary amount
	 */
	public Data(int emp_no, String emp_name, String designationcode, String department, int basicSalary) {
		super();
		
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.designationcode = designationcode;
		this.department = department;
		this.basicSalary = basicSalary;
		DA(designationcode);
		salary=basicSalary+da;
	}


public Data() {
	// TODO Auto-generated constructor stub
}

	public int getEmp_no() {
	return emp_no;
}


public String getEmp_name() {
	return emp_name;
}


public String getDepartment() {
	return department;
}


public int getSalary() {
	return salary;
}


public String getDesignation() {
	return designation;
}


	/**
	 * Calculates Dearness Allowance (DA) and sets designation based on designation code.
	 * DA amounts: Engineer(20k), Consultant(32k), Clerk(12k), Receptionist(12k), Manager(40k)
	 * 
	 * @param designationcode Single character designation code
	 */
	private void DA(String designationcode) {
		
		
		switch (designationcode){
			case "e" :
				da=20000;
				designation="Engineer";
			break;
			
			case "c":
				da=32000;
				designation="consultant";
				break;
		
			case "k":
				da=12000;
				designation="clerk";
				break;
				
			case "r":
				da=12000;
				designation="Receptionist";
				break;
				
			case "m":
				da=40000;
				designation="Manager";
				break;
				
			default:
				da=0;
				designation="nil";
				break;
	}
		
		
	}

	@Override
		public String toString() {
			String s=String.format("(%s %s %s %.2f %s)",emp_no,emp_name,department,(float)salary,designation);
			return s;
		}
	
}