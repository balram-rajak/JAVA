package java8.functionalInterface.supplier;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OtpGeneration {
	
	static Supplier<String> generateOtp=() -> 
		(int)(Math.random()*1000)+""+(int)(Math.random()*1000);
		
	static Predicate<String> checkOtpLength=Otp	-> Otp.length()==6;
	
	static Consumer<String>	printOtp=Otp -> System.out.println(Otp); 
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		while("y".equals(sc.next())) {
			String otp=generateOtp.get();
		if(checkOtpLength.test(otp)) 
			printOtp.accept(otp);
		
		}
		sc.close();
	}

}
