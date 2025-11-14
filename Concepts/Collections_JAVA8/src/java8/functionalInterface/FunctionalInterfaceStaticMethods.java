package java8.functionalInterface;

public class FunctionalInterfaceStaticMethods implements Recorder{

	public static void main(String[] args) {
		
		Caller.staticMethod(); 
		
		// It's not necessary that class should implement the interface
		// to call it's static method
		
		Recorder.main(args);
		
		Recorder.staticMethod();
		
	}
	
}

