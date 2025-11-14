package java8.functionalInterface.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Collectionpredicate<T> {

	public static void main(String[] args) {
		
		Predicate<Collection<String>> p=t -> t.isEmpty();
		System.out.println(p.test(Arrays.asList("Balram","Krishna","Radhe")));
		System.out.println(p.negate().test(Arrays.asList("Balram","Krishna","Radhe")));;
		
		Predicate<Collection<Object>> p1=t -> t.isEmpty();
		List<Object> l1=new ArrayList<>();
		l1.add("kiran"); l1.add(6);
		
		System.out.println(p1.test(l1));
		
		System.out.println(p1.test(new ArrayList<>()));
		
		//value is fixed(l1) but Predicate procedure is changing 
		Predicate<Predicate<Collection<Object>>> procedure2=t -> !t.test(l1);
		System.out.println(procedure2.test(p1));
		
		Predicate<Collection<Object>> p2=t -> t.contains(new ArrayList<>());
		System.out.println(procedure2.test(p2));
		
		//Predicate procedure is fixed but value is changing 
		//a sort of negate function
		Predicate<Collection<String>> p3=t -> !p.test(t);
		System.out.println(p3.test(Arrays.asList("Balram","Krishna","Radhe")));
		
	}
	
}
	
	