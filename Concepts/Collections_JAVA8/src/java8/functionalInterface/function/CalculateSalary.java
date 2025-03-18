package java8.functionalInterface.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CalculateSalary {
	
	static Function<Employee, Double> calaculateSalary=t -> (t.getSalary()+5000.0+5000*0.20);

	static Function<List<Employee>,Double> totalSalary=t -> { 
		Double salary=0.00;
		
		  for(Employee e:t) { /*salary+=e.getSalary();*/ 
		 
		salary+=calaculateSalary.apply(e);
		  }
		return salary;
	
	};
	
	static Predicate<Employee> checkSalary=t -> t.getSalary()>20000.0;
	
	static Function<Employee, Double> incrementSalary=employee -> 
		employee.getSalary()+477.0;

	
	
	public static void main(String[] args) {
		
		ArrayList<Employee> employee=new ArrayList<>();
		populate(employee);
		
		for(Employee e:employee)
			System.out.println(calaculateSalary.apply(e));
		
		System.out.println( "Total Salary: "+totalSalary.apply(employee));
		
		System.out.println("Employee with increamented salary: ");
		for(Employee e:employee) {
			if(checkSalary.test(e)) 
			{
		System.out.printf("%s: %s \n",e.getName(),incrementSalary.apply(e));
			}
		}
	
	}
	
	static void populate(List<Employee> list) {
		
		list.add(new Employee(15000, "Krshna"));
		list.add(new Employee(2000, "Radhe"));
		list.add(new Employee(30000	,"Devki"));
		list.add(new Employee(32000,"Ganesh"));
		list.add(new Employee(60000,"Arjun"));

	}
}

class Employee {
	public Employee(int salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int salary;
	private String name;

}

