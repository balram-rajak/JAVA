package java8.functionalInterface.function.unaryoperator;

import java.util.function.UnaryOperator;

public class ObjectType {

	static UnaryOperator<Integer> getNumber=t -> (int)(Math.random()*10)*t;
	
	public static void main(String[] args) {
		
		System.out.println(getNumber.apply(8));
	}
}
