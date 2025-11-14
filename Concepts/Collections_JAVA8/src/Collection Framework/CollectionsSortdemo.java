package rough_work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSortdemo {

	public static void main(String[] args) {
		
		ArrayList l=new ArrayList();
		
		l.add(28);
		l.add(10);
		
		l.add(40);
		l.add(20);
		
	
		
		System.out.println(l);
		
		System.out.println(Collections.binarySearch(l, 20));//unpredictable result
		Collections.sort(l);// first sort function
		System.out.println(l);
		
		System.out.println(Collections.binarySearch(l, 20));
		System.out.println(Collections.binarySearch(l, 29));
		Collections.reverse(l);//doesn't give reverse comparator
		System.out.println("reverse:"+l);
	    Collections.sort(l, new collectcomparator());// second sort function
	    System.out.println(l);
	    
	    System.out.println(Collections.binarySearch(l, 29));// comparator object not pased
	    // unpredictable result
	    System.out.println(Collections.binarySearch(l,29, new collectcomparator()));
	    System.out.println(Collections.binarySearch(l,40, new collectcomparator()));
	    Collections.reverse(l);
		System.out.println("reverse:"+l);
	}
}

class collectcomparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		
		return -((Integer) o1).compareTo((Integer)o2);
	}
	
	
}