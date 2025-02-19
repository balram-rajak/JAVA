package com;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import functionality.Display;

public class Employee_data{
	
 static Predicate<Data> filterByDepartment=t -> t.getDepartment().contentEquals("support");
 
 static Predicate<Data> filterManagers=t -> t.getDesignation().contentEquals("Manager");
	
	static Display listAllManager=(t, l) -> l.stream().
			map(list ->  t.test(list) ? list+"\n": "")
			.forEach(System.out::print);
	
	public static void main(String[] emp_no) {
				
		ArrayList<Data> employeeList=new ArrayList<>();
		populateList(employeeList);
		System.out.println(employeeList);
		
		
		System.out.println("All managers");
		listAllManager.display(filterManagers, employeeList);
		
		
		System.out.println("All Employee from Support department");
		listAllManager.display(filterByDepartment, employeeList);
		
		System.out.println("All managers in support department");
		listAllManager.display(filterManagers.and(filterByDepartment), employeeList);
		
		System.out.println("All employee who are not managers "	);
		listAllManager.display(filterManagers.negate(), employeeList);
		
		System.out.println("*****************");
		listAllManager.display(Predicate.not(filterByDepartment), employeeList);
		
		Predicate<Data> engineer=Predicate.isEqual(new Data(7,"Devki","e","support",15000));
		System.out.println(engineer.test(new Data(1,"balram","e","support",15000)));
		System.out.println(engineer.test(new Data(9,"Arjun","m","Testing",15000)));
		Data d=new Data(7,"Devki","e","support",15000);
		System.out.println(engineer.test(d));
		
	}
	
	static void populateList(List<Data> l) {
		l.add(new Data(1,"balram","e","support",15000));
		l.add(new Data(2,"Krishna","c","developer",15000));
		l.add(new Data(3,"Sing","k","delivery",15000));
		l.add(new Data(4,"Chaitanya","r","functional",15000));
		l.add(new Data(5,"Tarun","m","support",15000));
		l.add(new Data(6,"Radhe","k","Ideas",15000));
		l.add(new Data(7,"Devki","e","support",15000));
		l.add(new Data(8,"Hiranyakashayapu","c","Application dev",15000));
		l.add(new Data(9,"Arjun","m","Testing",15000));
		l.add(new Data(10,"Bheem","r","maintenence",15000));
	}
	
	
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

