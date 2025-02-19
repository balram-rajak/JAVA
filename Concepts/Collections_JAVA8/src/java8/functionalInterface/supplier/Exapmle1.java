package java8.functionalInterface.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class Exapmle1 {

	static Supplier<Date> getSystemDate=() -> new Date();
	public static void main(String[] args) {
		
		System.out.println(getSystemDate.get());
		
	}
}
