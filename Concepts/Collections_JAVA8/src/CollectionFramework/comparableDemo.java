package rough_work;

import java.util.Comparator;
import java.util.TreeSet;

public class comparableDemo {

	public static void main(String[] args) {

		TreeSet<Employee> t1 = new TreeSet<>();

		Employee e1 = new Employee("rama", 400);
		Employee e2 = new Employee("krishna", 5000);
		Employee e3 = new Employee("balaji", 300);
		Employee e4 = new Employee("jagganath", 4000);
		Employee e5 = new Employee("chaitanya", 10000);

		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		t1.add(e4);
		t1.add(e5);
		System.out.println(t1);

		TreeSet<Employee> t2= new TreeSet<>(new Mycomparator());
		
		t2.add(e1);
		t2.add(e2);
		t2.add(e3);
		t2.add(e4);
		t2.add(e5);
		
		System.out.println(t2);
		
		
	}

}

class Mycomparator implements Comparator<Object> {

	
	public int compare(Object o1, Object o2) {
		Employee s1 = (Employee)o1;
		Employee s2 = (Employee)o2;

	String n1=s1.get_name();
	String n2=s2.get_name();
		
		return n1.compareTo(n2);
		/*if (n1.length() > n2.length())
			return +1;
		else if (s1.length() == s2.length())
			return s1.compareTo(s2);
		else
			return -1;*/

	}

}
