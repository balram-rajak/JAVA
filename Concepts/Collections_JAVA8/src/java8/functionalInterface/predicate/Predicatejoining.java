package java8.functionalInterface.predicate;

import java.util.function.Predicate;

public class Predicatejoining {

	public static void main(String[] args) {
		Predicate<Integer> p1=t -> t>10;
		Predicate<Integer> p2=t -> t%2==0;
		System.out.println(p1.test(20));
		System.out.println(p1.negate().test(4));
		System.out.println(p1.negate().test(10));
		
		System.out.println(p1.and(p2).test(74));
		System.out.println(p1.and(p2).test(87));
		
		System.out.println(p1.negate().or(p2).test(29));
		System.out.println(p1.or(p2).test(29));
		
		int x[] = {4,6,24,35,79,46,1,345};
		m1(p1,x);
		
		m1(p2,x);
		
		m1(p1.negate(),x);
		m1(p1.and(p2),x);
		m1(p1.negate().or(p2),x);
		m1(p1.negate().and(p2),x);
		
		System.out.println("number not even or greater than 10");
		m1(p2.negate().or(p2),x);
		
		System.out.println("number not greater than 10 or not even");
		m1(p1.negate().or(p2.negate()),x);
		
		System.out.println("number not greater than 10 and not even");
		m1(p1.negate().and(p2.negate()),x);
		
		System.out.println(p1.negate().test(4));
		System.out.println(p1.negate());
		System.out.println(p1.negate());
		System.out.println(Predicate.not(p1).test(4));
		System.out.println(Predicate.not(p1));
		System.out.println(Predicate.not(p1));
		
	}
	
	static void m1(Predicate<Integer> predicate, int[] intArray) {
		
		for(int num:intArray) {
		if(predicate.test(num))
			System.out.printf("%s ",num);
		}
		
		System.out.println();
	}
}
