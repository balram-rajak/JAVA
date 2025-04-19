package rough_work;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class IteratorDemo {

	public static void main(String[] args) {
		
		LinkedList l =new LinkedList();
		
		for(int i=0; i<10; i++) {
			
			l.add(i);
		}
		
		Iterator itr= l.iterator();
		while(itr.hasNext()) {
			Integer x= (Integer) itr.next();
			if(x%2==0) {
				System.out.println(x);
			}
				else
					itr.remove();
		
	}
		
		Queue q1= new PriorityQueue() ;
		ListIterator ltr1=l.listIterator();
		
		
		
		System.out.println(l);
}
}
