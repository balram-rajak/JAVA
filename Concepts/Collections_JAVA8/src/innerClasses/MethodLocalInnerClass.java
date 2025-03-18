package innerClasses;

public class MethodLocalInnerClass {

	int x = 1000;
	int z = 4000;
	final static int y = 0;

	public void m1() {
		Integer i2 = 4;
		int x = 100;// can't be accessed by inner class directly due to 
		            // name collision
		int num1 = 3; // final by default all variables
		int num2 = 5;
		class Inner {
			int x = 10;

			// In new versions of java inner class main functions can
			// run without declaring main function in outer class
			public static void main(String[] args) {
				System.out.println("method local inner main");
			}

			void innerMethod() {
				int innerVar=0;
				System.out.println(x);
				/* Same thing if x variable (int x=0;)
				 * not declared locally inside innerMethod() fn-> */ System.out.println(this.x);
				
				System.out.println("inner method y variable: "+innerVar);

				/*
				 * can't access the outer function variables 
				 * directly if there is name collision
				 * MethodLocalInnerClass.this.m1();
				 */

				System.out.println(MethodLocalInnerClass.this.x);

				System.out.println(num1);
				System.out.println(i2);
				System.out.println(num2);

				// System.out.println(x); // can't call if method is static
				System.out.println(y);
			}

			/*
			 * static void innerMethod() { System.out.println(x); //Error: instance type
			 * accessed as static System.out.println(y); }
			 */
		}

		Inner i1 = new Inner();
		i1.innerMethod();

	}

	static void m2() {
		int x=100;
		class Inner{
			int y=10;
			void innerMethod() {
				System.out.println(x);
				System.out.println(this.y);
				
				/* can't be accessed statically the 
				 * outer class instance variables
				 * System.out.println(MethodLocalInnerClass.this.x); 
				System.out.println(z);*/
			}
			
		}
		Inner i=new Inner();
		i.innerMethod();
	
	}

	public static void main(String[] args) {

		MethodLocalInnerClass local = new MethodLocalInnerClass();
		local.m1();
		local.m2();

	}

}