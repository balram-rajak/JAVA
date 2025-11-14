package java8.functionalInterface;

public interface Caller {

	default void m2() {
		System.out.println("Caller default method m2");
	}
	
	static void staticMethod() {
		System.out.println("Caller static menthod");
	}
	
	default void m3() {
		System.out.println("Caller default method m2");
	}
}
