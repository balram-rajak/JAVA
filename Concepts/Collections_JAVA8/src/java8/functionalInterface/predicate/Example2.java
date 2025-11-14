package java8.functionalInterface.predicate;

import java.util.function.Predicate;

public class Example2 {

	public static void main(String[] args) {
		Predicate<String> p=t -> t.length()>10;
		System.out.println(p.test("Krishna"));
		System.out.println(p.test("Radha Rani"));
		System.out.println(p.test("Sri krishna chaitanya"));
	}
}
