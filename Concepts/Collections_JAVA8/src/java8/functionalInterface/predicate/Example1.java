package java8.functionalInterface.predicate;

import java.util.function.Predicate;

public class Example1 {

	public static void main(String[] args) {
		Predicate<Integer> p=t -> t>100;
		System.out.println(p.test(100));
		System.out.println(p.test(1000));
		System.out.println(p.test(40));
	}
}
