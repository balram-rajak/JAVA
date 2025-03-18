package rough_work;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
	
	public static void main (String[] args) {
		
		example<String> e1= new example<>();// using generic, as a type parameter in case of a class
		example<Integer> e2=new example<Integer>();
		
		e2.set(24); // integer type accepts that type only data
		e1.set("first generic"); // string type accepts that type parameter data only
		ArrayList<String> arrl=new ArrayList<>();
		
		List l= new ArrayList();
		System.out.println(l);
		
		l.add(true);
		l.add(29);
		System.out.println("list without gengeric"+ l);
		String s=(String) l.get(0); // we will get runtime error here
		
		arrl.add("hello");
		
		//Integer x=(Integer)arrl.get(0); // using generic, the error was detected at compile time
		System.out.println("object with String type gengeric "+ e1.get());
		System.out.println("object with Integer type generic "+ e2.get());
	}  
}
	class example<T> { // defined a class with a type parameter
		  
		private T data;
		
		  void set(T data) {this.data=data;}
		  T get() {return data;}
		  /*static void ex(T data) { // error as the generic was only defined in scope of an instance  
		  }*/
		
	}

