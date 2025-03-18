package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream1 {
	
	static Predicate<Integer> isEven=t -> t%2==0;

	public static void main(String[] args) {
	
		List<Integer> list=new ArrayList<>();
		
		list.add(4); list.add(5); list.add(46);
		list.add(39); list.add(72); list.add(835);
		
		// using predicate = even
		Stream<Integer> s=list.stream();
		s.filter(isEven).forEach(System.out::println);
		
		// using lambdas = even
		list.stream().filter(number -> number%2!=0)
		.forEach(System.out::println);
		
		// using predicate negate = odd
		list.stream().filter(isEven.negate())
		.forEach(System.out::println);
		
		//using method reference = factor of 5
		list.stream().filter(Stream1::divisibleBy5).
		forEach(System.out::println);
		
		// using filter and map both at same time to print even numbers square
		list.stream().filter(isEven)
		.map(number -> number * number)
		.forEach(System.out::println);
	}
	
	static boolean divisibleBy5(Integer number) {
		return number%5==0;
	}
}


