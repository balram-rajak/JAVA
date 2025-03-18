package rough_work;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class VectorListDemo {

	public static void main(String[] args) {
		
		Vector v1= new Vector();
		
		Enumeration E =v1.elements();
		
		v1.add("24");v1.add("first vector");v1.add(null);v1.add(true);
		v1.addElement(false);
		v1.remove(1);v1.set(3,'c');
		
		System.out.println(v1);
		v1.add(49.666);
		
		for(int i=0;i<v1.size(); i++) {
			
		System.out.println("Element "+i+"="+E.nextElement());
		
		}
		System.out.println("hashcode = "+v1.hashCode());
		System.out.println(v1.capacity());
		System.out.println(v1);
		System.out.println(E.hasMoreElements());
		List l= new ArrayList();
		System.out.println(v1.get(0).equals(24));
		
	}
}
