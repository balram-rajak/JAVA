package java8.LambdaExpressions;

public class ThreadWithRunnable {

	public static void main(String[] args) {
		
		main2 f1= (i) -> i*i ;
		/*
		 * Runnable f= () -> {
		 * 
		 * for(int i=0; i<10; i++) { System.out.println(f1.squareOf(i));
		 * System.out.println("child thread"); }
		 * 
		 * };
		 * 
		 * Thread t1=new Thread(f);
		 */
		
new Thread(() -> {
			
			for(int i=0; i<10; i++) {
				System.out.println(f1.squareOf(i));
				System.out.println("child thread");
			}
		}
		).start();

		System.out.println(f1.squareOf(4));

		System.out.println(f1.squareOf(4));

		//t1.start();

		System.out.println(f1.squareOf(4));

		System.out.println(f1.squareOf(75));
	
	}


}


interface myrun{

  int squareOf(int x);
}

@FunctionalInterface
interface main2 extends retrieve{

//void m1();

default void m2() {
	System.out.println("default");
}


public static void main() {
	System.out.println("static");
}

}


