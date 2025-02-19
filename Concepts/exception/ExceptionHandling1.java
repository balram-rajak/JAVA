package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling1 extends RuntimeException{

	private static final long serialVersionUID = 1L;
	static InterruptedException e;
//	static int x=10/0;
//	static {
//		String s=null;
//		System.out.println(s.length());
//	}
	public static void main(String[] args) {
//		throw new ArithmeticException(" explicit exception");
//		throw e;
//		throw new ExceptionHandling1();
//		doStuff();
//		throw new Error("Error explicit");
//		new Thread().setPriority(100);
//		int x=Integer.parseInt("1 0");
		try (BufferedReader br=new BufferedReader(new FileReader(""))){
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		
	} 
	
	public static void doStuff() throws InterruptedException {
		doMoreStuff();
	}
	public static void doMoreStuff() throws InterruptedException{
		throw e;
	}
}
