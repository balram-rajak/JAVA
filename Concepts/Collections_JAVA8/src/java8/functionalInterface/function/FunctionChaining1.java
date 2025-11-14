package java8.functionalInterface.function;

import java.util.function.Function;

public class FunctionChaining1 {

	static Function<String, String> toUppercase=t -> t.toUpperCase();
	static Function<String, String> firstNineCharacters=t -> t.substring(0, 9);
	public static void main(String[] args) {
		
		System.out.println(
				toUppercase.andThen(firstNineCharacters).
				apply("Radhe Krishna"));
		
		System.out.println(
				toUppercase.compose(firstNineCharacters).apply("Radhe krishna"));
		
	}
	
}
