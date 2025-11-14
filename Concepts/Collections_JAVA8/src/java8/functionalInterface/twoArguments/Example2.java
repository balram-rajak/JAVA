package java8.functionalInterface.twoArguments;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Example2 {

	static private BiFunction<Employee, TimeSheet, Double> getWage=(t, u) -> t.getDailyWage()*u.getWorkDays();
	
	static private BiFunction<String, Integer, Employee> getEmployeeObject=(t, u) -> new Employee(t,u,200);
	
	static private BiFunction<Employee, Double, TimeSheet> getTimeSheetObject=(t, u) -> 
	new TimeSheet(u,t.getEno());
	
	static private BiConsumer<Employee,Double> printWage=(t,wage) -> 
	System.out.printf("Employee:%s Wage:%s\n",t.getEmpName(),wage);
	
	public static void main(String[] args) {
		
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(getEmployeeObject.apply("Subhadra", 200));
		employeeList.add(getEmployeeObject.apply("Krishna", 101));
		
		for(Employee e:employeeList)
		printWage.accept(e, getWage.apply(e, getTimeSheetObject.apply(e, 40d))); 
	}
	
	
}

class Employee{
	public Employee(String empName, int eno, double dailyWage) {
		super();
		this.empName = empName;
		this.eno = eno;
		this.dailyWage = dailyWage;
	}
	private String empName;
	private int eno;
	private double dailyWage;
	public String getEmpName() {
		return empName;
	}
	public int getEno() {
		return eno;
	}
	public double getDailyWage() {
		return dailyWage;
	}
	
	
}

class TimeSheet{
	public TimeSheet(Double workDays, Integer eno) {
		super();
		this.workDays = workDays;
		this.eno = eno;
	}

	private Double workDays;
	private Integer eno;

	public Integer getEno() {
		return eno;
	}

	public Double getWorkDays() {
		return workDays;
	}
	
	
}