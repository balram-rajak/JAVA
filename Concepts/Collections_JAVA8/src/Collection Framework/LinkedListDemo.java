package rough_work;

import java.util.Enumeration;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.add("first");
		l1.add(0);
		l1.add(null);
		System.out.println(l1);
		l1.add(0, "first element");
		System.out.println(l1);
		l1.addFirst("this is first linkedlist");
		System.out.println(l1);
		l1.removeLast();
		System.out.println(l1);
		l1.addLast(true);
		System.out.println(l1);
		
		Enumeration e1=(Enumeration)l1.element();
		System.out.println(e1.hasMoreElements());
		
		
		
		
	}
}
