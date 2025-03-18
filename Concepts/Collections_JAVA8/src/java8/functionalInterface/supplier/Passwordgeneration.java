package java8.functionalInterface.supplier;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Passwordgeneration {
	
	static Predicate<String> matchPasswordPattern=t -> t.matches("[A-Z@#$]+");
	
	
	static Supplier<String> generateRandomNumbers=() -> (int)(Math.random()*(10))+"";
	
	// 29 = 26 alphabets + 3 special characters(@,64 #,35 $,36)
	static Supplier<String> generateRandomCharacters=() -> 
	((char)(Math.random()*91)+"");
	
	private static Supplier<String> generatePassword=() -> {
		
		String s="";
		for(int i=1; i<=8; i++) {
			if(i%2==0) s+=generateRandomNumbers.get();
				
			else s+=generateRandomCharacters.get();
		}
		
		return s;
	};
	
	
	  static Predicate<String> checkPattern=t -> 
	  t.matches("([A-Z$@#]\\d){4}");

	
	static Consumer<String> printPassword=t -> System.out.println(t);
	
	public static void main(String[] args) {
		String password=generatePassword.get();
		
		  while(!checkPattern.test(password)) { 
			  password=generatePassword.get();
		  if(checkPattern.test(password)) 
			  printPassword.accept(password);
		  
		  }
		
	}
}
