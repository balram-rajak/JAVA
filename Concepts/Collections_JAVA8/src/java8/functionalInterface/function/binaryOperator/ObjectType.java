package java8.functionalInterface.function.binaryOperator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import rough_work.Employee;

public class ObjectType {

	static BinaryOperator<String> finalString=(t, u) -> t+" "+u;
	
	static UnaryOperator<String> printSalary=t -> "Salary "+t;
	
	public static void main(String[] args) {
		
		System.out.println(finalString.apply("Radhe", "Krishna"));
		
		Employee e1=new Employee("Krishna", 21,345);
		Employee e2=new Employee("Balbhadra", 101,341);
		Employee e3=new Employee("Radhe", 1,5100);
		
		List<Employee> employeelist=new ArrayList<>();
		employeelist.add(e1);
		employeelist.add(e2);
		employeelist.add(e3);
		
		
		for(int i=0; i<employeelist.size()-1;i++) {
		System.out.println(BinaryOperator.maxBy(new Mycomparator()).
				apply(employeelist.get(i), employeelist.get(i+1)));
		
		
		}
		
		System.out.println(BinaryOperator
				.minBy(new Mycomparator()).apply(e2, e3));
		
		System.out.println((finalString.andThen(printSalary)).apply(e1.get_name(), e1.getSalary()+""));
		
		}
}



class Mycomparator implements Comparator<Employee> {

	
	public int compare(Employee o1, Employee o2) {
		
	String n1=o1.get_name();
	String n2=o2.get_name();
		
		return n1.compareTo(n2);
		/*if (n1.length() > n2.length())
			return +1;
		else if (s1.length() == s2.length())
			return s1.compareTo(s2);
		else
			return -1;*/

	}

}
