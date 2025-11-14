package java8.functionalInterface.function;

import java.util.function.Function;

public class Example2 {

	public static void main(String[] args) {
		
		Function<String, String> removeSpaces=t -> t.replaceAll(" ", "");
		System.out.println(removeSpaces.apply("Krishna Radhe"));;
		
		Function<String, Integer> countSpaces=t -> t.length()-t.replaceAll(" ", "").length();
		
		System.out.println(countSpaces.apply("Krishna Radhe kanha kanhaya"));
		
		
	}
}
