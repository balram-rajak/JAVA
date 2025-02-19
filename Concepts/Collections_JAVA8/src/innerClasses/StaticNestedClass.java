package innerClasses;

public class StaticNestedClass {

	int x=10;
	static public class Nested {

		public void m1() {
			System.out.println("Nested static class");
		}

		public static void m2() {
			System.out.println("Nested static funtion");
		}

		public static void main(String[] args) {
			/* System.out.println(x); 
			 * can't access instance type in static class*/ 
			System.out.println("nested main method");
		}
		/*
		 * @Override public void run() {
		 * 
		 * m1(); m2(); main(null);
		 * 
		 * // method if this class implements Runnable
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {

		/* Declaration type if inner class is not static
		 * StaticNestedClass nes=new StaticNestedClass(); 
		 * StaticNestedClass.Nested
		 * n1=nes.new Nested(); StaticNestedClass.Nested n3=new StaticNestedClass().new
		 * Nested();
		 */
		
		Nested n1 = new Nested();

		n1.m1();
		Nested.main(args);

		// Thread t=new Thread(n1); t.run();

		for (int i = 0; i < 5; i++)
			System.out.println("main thread");

		StaticNestedClass.Nested nest = new Nested();
		StaticNestedClass.Nested n2 = new StaticNestedClass.Nested();
		StaticNestedClass.Nested.m2();

	}

}
