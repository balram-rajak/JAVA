package java8.functionalInterface;

public abstract interface Recorder {

	
	default void m2() {
		System.out.println(" Recorder default m2");
	}
		 
	static void staticMethod() {
		
		System.out.println("Recorder static method");
	}
	
	//final void methodFinal() ;  //can't declare final type in 
	                             //interface
	
	/* @can't do it
	 * strictfp void fn() {
	 * 
	 * }
	 */
	 

	/*
	 * @Override public 
	 * int hashCode() { 
	 * return 0; 
	 * }
	 *can't provide our own body of Object class methods in interface
	 */
	
	@Override
	int hashCode();
	
	
	public static void main(String[] args) {
		System.out.println("Recorder main method");
	}
}
