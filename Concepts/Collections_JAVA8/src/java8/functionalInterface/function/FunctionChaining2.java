package java8.functionalInterface.function;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionChaining2 {
	
	static Predicate<String> searchJava=t -> t.contains("JAVA");
	static Predicate<String> checkCase=t -> t.contains("[A-Z]");
	static Predicate<String> checkpass=t -> t.equals("JAVAK");
	
	public static void main(String[] args) {
		
		Function<String, String> filterPass=t -> searchJava.and(checkCase).test(t)
				? t.substring(0, 5) : ""  ;
		
		Function<String,Boolean> checkUname=t -> t.substring(0,7)
				.contentEquals("Balram@");
		
		Scanner sc1=new Scanner(System.in);
		
		System.out.println( (checkUname.apply(sc1.nextLine()) && 
				(checkpass.test(filterPass.apply(sc1.nextLine())))  ? 
						"success" : "Unsuccess"));
		
		sc1.close();
	}
}
