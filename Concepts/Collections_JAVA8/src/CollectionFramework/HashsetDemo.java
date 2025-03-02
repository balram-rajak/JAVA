package rough_work;

import java.util.HashSet;

public class HashsetDemo {

	
	public static void main(String[] args) {
		HashSet h1=new HashSet();
		
		for(int i=0; i<5;i++) {
			h1.add(i);
		}
		
		h1.remove(new Integer(2));
		System.out.println(h1);
	}
}
