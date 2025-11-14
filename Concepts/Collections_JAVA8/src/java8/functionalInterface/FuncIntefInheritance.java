package java8.functionalInterface;

public class FuncIntefInheritance implements Recorder, Caller{

	@Override
	public void m2() {
		
		// or your own implementation
		
		Recorder.super.m2();  // calling Recorder implementation
		//Caller.super.m2(); // calling Caller implementation
	}

	public static void main(String[] args) {
		FuncIntefInheritance f1= new FuncIntefInheritance();
		
		f1.m2();
	}
	
	
}
