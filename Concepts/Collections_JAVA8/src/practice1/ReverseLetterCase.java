package practice1;

import java.util.Scanner;

public class ReverseLetterCase {

	public static void main(String[] args) {
		
		Scanner sc1=new Scanner(System.in);
		
		if(sc1.nextInt()==1)
		evenCaseChange("Wipro");  // if input == 1
		
		sc1.next();
		
		if(sc1.nextInt()==2)
			System.out.println(reverseAll("CHEnnAi")); 
		
		sc1.close();
	}
	
	
	
	public static String evenCaseChange(String s) {
		
		for(int i=0; i<s.length(); i++) {
			
			if(i%2==0)
				s.charAt(i);
			
			
		}
		
		
		return s;
	}
	
	
	public static String reverseAll(String s) {
		//StringBuffer sb= new StringBuffer();
		String s1= new String();
		
		for(int i=s.length()-1; i>=0; i--) {
			
			String temp=ReverseLetterCase.reverseCase(Character.toString(s.charAt(i)));
			s1=s1+temp;
			
			
			//sb.append(ReverseLetterCase.reverseCase(Character.toString(s.charAt(i))));
			
		}
		return s1;
		
	}
	
	
	  private static String reverseCase(String letter) {
	  
	 if(letter.contains("[A-Z]"))
		  letter.toLowerCase();
	  
	 if(letter.contains("[a-z]"))
		 letter.toUpperCase();
	 
	 else
		 return letter;
	 
	 return letter;
	  }
	 
	

					
}
