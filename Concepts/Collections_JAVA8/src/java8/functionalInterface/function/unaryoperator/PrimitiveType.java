package java8.functionalInterface.function.unaryoperator;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public class PrimitiveType {

	static IntUnaryOperator number=operand -> operand*operand;
	
	static LongUnaryOperator getid=operand -> operand*41434;
	
	static DoubleUnaryOperator getsalary=operand -> operand*23.423543;
	
	public static void main(String[] args) {
		
		System.out.println(number.applyAsInt(4));
		System.out.println(getid.applyAsLong(56));
		System.out.println(getsalary.applyAsDouble(43.56));
	}
}
