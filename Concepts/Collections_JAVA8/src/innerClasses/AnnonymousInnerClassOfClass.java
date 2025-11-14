package innerClasses;

public class AnnonymousInnerClassOfClass {

	int x = 1000;

	public static void main(String[] args) {

		AnnonymousInnerClassOfClass an = new AnnonymousInnerClassOfClass();
		an.m1();

	}

	void m1() { // Also i can put this whole code inside main function
		/*
		 * Anonymous inner class is created if the requirement for the overriding
		 * function is only one time
		 */
		Gravy g1 = new Gravy() /*
								 * g1 is object of Gravy anonymous child inner class
								 */
		{
			// instance variable of anonymous inner class
			int x = 100; // can't use outside of this anonymous class
			static int b;
			class Test {
				static int x = 10;
				int y = 10;// we can't use it outside this class

				static void m3() {
					System.out.println(x);

				}
			}

			// main function inside anonymous inner class
			public static void main(String[] args) {
				System.out.println("annonymous innerclass main");
				Test.m3();

			}
			/*
			 * () - Anonymous inner classes cannot contain explicitly declared constructors
			 */

			// overriding Gravy class taste method
			void taste() {
				System.out.println("spicy");
				System.out.println(this.x);
				System.out.println(AnnonymousInnerClassOfClass.this.x);
				// this.taste();
			}
		}; // end of anonymous inner class 1

		g1.taste(); // -> spicy

		// getting Name of anonymous inner class
		System.out.println(g1.getClass().getName());

		Gravy defaultValue = new Gravy();
		defaultValue.taste(); // salty

		Gravy sweetTaste = new Gravy() {

			void taste() {
				System.out.println("sweet");
			}
		};
		sweetTaste.taste(); // sweet
	}
}

class Gravy {
	int x = 1000;

	void taste() {
		System.out.println("salty");
	}

	/*
	 * can't contain default type default void spice1() {
	 * 
	 * }
	 */

	static void spice2() {
	}

}