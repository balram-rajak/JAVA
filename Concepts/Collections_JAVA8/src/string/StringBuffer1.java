package string;

import java.util.ArrayList;

public class StringBuffer1 {

	public static void main(String[] args) {
		
		ArrayList<String> a=new ArrayList<>();
		
		try {
			System.out.println("outer try");
			try {
				System.out.println("inner try");
				String s=null;
				s.compareTo("");
			}catch(ArithmeticException e){
				System.out.println("inner catch");
			}
		}catch (Exception e) {
			
			System.out.println("outer catch");
		}
		finally {
			System.out.println("finally done");
		}
		System.out.println("last statement");
		
	}
	
}
