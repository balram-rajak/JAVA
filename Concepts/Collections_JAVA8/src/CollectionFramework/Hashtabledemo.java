package CollectionFramework;

import java.util.Hashtable;

public class Hashtabledemo {

static void testPassByReference(Hashtable<Employee,String> h){

	h.put(new Employee("Krishna",50),"Null&Void");

}
	public static void main(String[] args) throws Exception {
		
		Hashtable<Employee,String> h=new Hashtable<>(30);
		testPassByReference(h);
		Employee e=new Employee("gopi kant",29);
		h.put(new Employee("balram", 12), "balram@gmail.com");
		h.put(new Employee("tarun", 10), "tarun@gmail.com");
		
		h.put(e, "gopi@gmail.com");
		e=null;
		//Thread.sleep(5000);
		h.put(new Employee("gauri", 89), "gauri@gmail.com");
		h.put(new Employee("minakshi", 101), "minakshi@gmail.com");
		
		System.out.println(h);
	}
}
