package java8.functionalInterface.twoArguments;

import java.util.function.BiPredicate;

public class Example1 {

	static BiPredicate<Integer, Integer> checkSumEven=(t, u) -> (t+u)%2==0;
	
	public static void main(String[] args) {
		
		System.out.println(checkSumEven.test(4, 16));
	}
}
