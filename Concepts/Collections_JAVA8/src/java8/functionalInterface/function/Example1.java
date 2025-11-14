package java8.functionalInterface.function;

import java.util.function.Function;

public class Example1 {

	public static void main(String[] args) {
		
		Function<String, Integer> lengthofString=String -> String.length();
		
		System.out.println(lengthofString.apply("Krishna"));
		
		Function<Integer, Integer> squareOfNumber=t -> t*t;
		System.out.println(squareOfNumber.apply(4));
	}
}
