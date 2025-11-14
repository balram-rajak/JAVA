package java8;

import java.util.ArrayList;
import java.util.List;

public class FunctionalBasics {

	public static void main(String[] args) {
		
		printEven();
		printStringWithFunctional();
		printWordAtLeastFourLetters();
		doubleEvenNumber();
		printEachLetters() ;
	}
	
	private static void printEven() {
		List<Integer> numbers=List.of(2,6,3,7,9,45,23,46,82);
		
	numbers.stream().filter(t -> t%2!=0) .
	forEach(number -> System.out.println(number))  ;
	}
	
	private static void printStringWithFunctional() {
		
		List<String> l1 = List.of("krishna","balram","radhe",
				"Devki maiya","yasoda maiya","singh raaj","prahlad maharaj");

		
		l1.stream().filter(names -> names.contains("maiya")).
		forEach(System.out::println);
	}
	
	private static void printWordAtLeastFourLetters() {
		
		List<String> l1 = List.of("krishna","radhe","lav",
				"Devki maiya","yasoda maiya","ram","singh raaj","prahlad maharaj","ved");
		
		l1.stream().filter(names -> names.length()>=4).forEach(System.out::println);
	}
	
	private static void doubleEvenNumber() {
		
		List<Integer> numbers=List.of(2,6,3,7,9,45,23,46,82);
		
		numbers.stream().filter(number -> number%2==0).map(number -> number*number* number).
		forEach(System.out::println)  ;

	}
	
private static void printEachLetters() {
		
		List<String> l1 = List.of("krishna","radhe","lav",
				"Devki maiya","yasoda maiya","ram","singh raaj","prahlad maharaj","ved");
		
//		l1.stream()
//		.map(names -> names.toCharArray())
//		//.toList()
//		
//		.iterator()
//		
//		.forEachRemaining(names -> System.out.println());
       
		char[] c;
		for(String p : l1) {
			
			List<Object> l2= new ArrayList<>();
			c=p.toCharArray();
		    for ( char d : c) {
				
				l2.add(d);
			}
		
		    
		
		l2.stream().forEach(System.out::println);
		
		}
		
   ;
			
		
}










}
			
	

