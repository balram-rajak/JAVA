package java8.functionalInterface.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example3 {

	public static void main(String[] args) {
		
		String[] arr= {"Balram"," ","krishna",null,"kanhaya","Radhe",""};
		
		Predicate<Integer> stratsWithK=index -> arr[index].startsWith("k");
		Predicate<Integer> isNull=index -> arr[index]==null;
		Predicate<Integer> isBlank=index -> arr[index].isEmpty();
	
		//method-1
		for(int i=0; i<arr.length; i++)
			System.out.println((isNull.or(isBlank).test(i)) ?  "": stratsWithK.test(i)); ;
		//method-2, without predicate
		/*
		 * for(String s:arr) System.out.println(s.startsWith("k") ? s : "");
		 */
		
		System.out.println("check if empty or null");
		checkEmptyorNull(isNull.or(isBlank), arr);
		
		Predicate<Integer> isNotEmptyandNotNull=t -> arr[t]!=null && !arr[t].isEmpty();
		System.out.println("check if empty or null, method 2");
		List<String> l=new ArrayList<>();
	    for(int i=0; i<arr.length; i++)
	    	if(isNotEmptyandNotNull.test(i))
	    		l.add(arr[i]);
	    	//System.out.print(isNotEmptyandNotNull.test(i) ? arr[i]+"\n" : ""); 
	    System.out.println(l);
	}
	
	static void checkEmptyorNull(Predicate<Integer> p,String[] arr){
		
		for(int i=0; i<arr.length; i++)
			System.out.printf((p.test(i)) ? "index: "+i+"\n" : "");
	}
}
