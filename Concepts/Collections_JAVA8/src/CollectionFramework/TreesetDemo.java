package rough_work;

import java.util.TreeSet;

public class TreesetDemo {

	public static void main(String[] args) {
		
		TreeSet t1= new TreeSet();
		
		
		/*t1.add("b");
		t1.add("B");
		t1.add("a");
		t1.add("L");
		t1.add("200");*/
		//t1.add(null);
		
		
		t1.add(new StringBuffer("A"));
		t1.add(new StringBuffer("B"));
		
		System.out.println(t1);
		
		System.out.println("PRISHA".compareTo("PRIYA"));
		System.out.println("Z".compareTo("L"));
		System.out.println("A".compareTo("A"));
		//System.out.println("A".compareTo(null));
	}
}
