package rough_work;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;



public class ListIteratorDEMO {
	
	public static void main(String[] args) {
		
		Vector l1= new Vector();

		LinkedList l2=new LinkedList();
		
		l1.add("29");
		l1.add("99");
		l1.add("null");
		l1.add("true");
		
		l1.add("ram");
		
		ListIterator r1=l2.listIterator();
		
		Iterator itr=l2.iterator();
		
		Enumeration e1=l1.elements();
		
	while(r1.hasNext()) {
		
		String s=(String)r1.next();
		
		if(s.equals("ram"))
		r1.add("krishna");
		
		else if(s.equals("true"))
			r1.set("false");

		else if(s.equals("null"))
			r1.remove();
			
	}
	
	System.out.println(l1);;
	System.out.println(r1.getClass().getName());
	System.out.println(itr.getClass().getName());
	System.out.println(e1.getClass().getName());
	}
	
}
