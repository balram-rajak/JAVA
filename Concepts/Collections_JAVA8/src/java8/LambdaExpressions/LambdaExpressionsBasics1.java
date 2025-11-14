package java8.LambdaExpressions;

public class LambdaExpressionsBasics1 {

	int x=1000;
	//public static void main(String[] args) {
		
	void m1() {
		int y=100;
		//λ-expressions
		main1 f1= (i) -> { // also this whole code can we declared inside main function
			
			/*
			 * int y=10; Error: as already exist with same name inside m1() any local
			 * variable referenced from inside λ-expressions is always
			 * final whether we declare it or not so a final variable cannot be
			 * assigned with another value
			 */
			
			int x=10; // local variable not instance type
				
			System.out.println(x);
			System.out.println(this.x); //1000
			/*
			 *this keyword will always refer to current outer class 
			 *(where λ-expressions declared) variables only
			 */
			System.out.println(LambdaExpressionsBasics1.this.x); //1000
			System.out.println(y);
			
			/* Unreachable code
			 * class Test{ }
			 */ 
			System.out.println("λ-expressions local variable x: "+x);
			return i*i;
		};
		
		/*Lamba expressions can't override default or static methods
		 * main1 f2=m2(x) -> {System.out.println(x); return x;};
		 */
		
		System.out.println(f1.squareOf(4));
		
		System.out.println(f1.squareOf(75));
	}
	
		public static void main(String[] args) {
			
			LambdaExpressionsBasics1 l1=new LambdaExpressionsBasics1();
			l1.m1();
		
		
		}
			
		
		
	//}

	
}
