package rough_work;

import java.util.Enumeration;
import java.util.Vector;


public class EnumerationDemo {

	public static void main(String[] args) {
		
		Vector<Integer> v=new Vector<>();
		Enumeration<Integer> e1=v.elements();
		
		for(int i=0; i<=10; i++)
		{
			v.add(i);
			}
		
		while(e1.hasMoreElements()) {
			Integer x= e1.nextElement();
			if(x%2==0) 
				System.out.println(x);
		}
		
		System.out.println(v);
		}
}
