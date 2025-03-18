package java8.functionalInterface.function.binaryOperator;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class PrimitiveType {

	static IntBinaryOperator getproduct=(left, right) -> left*right;
	
	static LongBinaryOperator getProductNumber=(left, right) -> right+right;
	
	static DoubleBinaryOperator getProductPrice=(left, right) -> left+right;
	
	public static void main(String[] args) {
		
		System.out.println(getproduct.applyAsInt(46, 27));
	}
}
