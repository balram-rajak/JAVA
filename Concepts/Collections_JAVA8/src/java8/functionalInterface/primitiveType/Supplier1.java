package java8.functionalInterface.primitiveType;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class Supplier1 {

	static IntSupplier randomNumber=() -> (int)(Math.random()*10);
	
	static IntConsumer printNumber=value -> System.out.println(value);
	public static void main(String[] args) {
		printNumber.accept(randomNumber.getAsInt());
		
	}
}
