package rough_work;

import java.util.Map;
import java.util.WeakHashMap;

public class Weakhashmapdemo {

	
	public static void main(String[] args) throws Exception {
		Map h1= new WeakHashMap();
		
		Employee e1=new Employee(null, 0);
		h1.put(e1,"balram");
		
		System.out.println(h1);
		e1=null;
		System.gc();// calling garbage collector
		Thread.sleep(5000); // pausing main thread for seconds such that the finalise() method in Employee class completes execution of overrided finalize metho0d first
		System.out.println(h1);
		
	}
}
