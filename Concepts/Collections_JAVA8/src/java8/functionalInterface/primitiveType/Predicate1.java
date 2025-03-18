package java8.functionalInterface.primitiveType;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

public class Predicate1 {

	static IntPredicate numbergreaterThan10=i -> i>10;
	
	static LongPredicate isNumberlower=value ->  value<29.66;
	
	static DoublePredicate isNumbereqaul=value -> value==163.88766;
	
	public static void main(String[] args) {
		
		System.out.println(numbergreaterThan10.test(20));
		System.out.println(isNumberlower.test(27));
		System.out.println(isNumbereqaul.test(3452.837848));
		
		
		
	}
}
