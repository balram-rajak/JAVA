package java8.functionalInterface;

public class FuctionalInterfaceDefaultMethods implements Caller{

	public static void main(String[] args) {
		
		FuctionalInterfaceDefaultMethods f1= new FuctionalInterfaceDefaultMethods();
	f1.m2();
	
	}

	@Override
	public void m2() {
		// it's optional to override default method of an interface
		Caller.super.m2();
	}
	
	
}
