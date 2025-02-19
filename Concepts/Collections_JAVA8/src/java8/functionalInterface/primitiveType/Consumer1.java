package java8.functionalInterface.primitiveType;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjDoubleConsumer;

import rough_work.Employee;

public class Consumer1 {

	static IntConsumer printSquare=value -> System.out.println(value*value);
	
	static Consumer<String> printName=t -> System.out.println(t);
	
	static ObjDoubleConsumer<Employee> getSalary=(t, value) -> System.out.println( t.getSalary()*value);
	
	public static void main(String[] args) {
		
		getSalary.accept(new Employee("Krishna",21,20000), 6);
		
	}
}
