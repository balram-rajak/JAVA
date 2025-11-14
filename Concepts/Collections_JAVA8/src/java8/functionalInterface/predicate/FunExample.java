package java8.functionalInterface.predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;


public class FunExample {

	private class Customer {
		public Customer(String uname, String pass) {
			super();
			this.uname = uname;
			this.pass = pass;
		}
		public String getUname() {
			return uname;
		}
		
		String uname;
		String pass;
		

	}

	public static void main(String[] args) {
		
		Map<String, Boolean> m=new HashMap<>();
		m.put("balram", true);
		Scanner sc1=new Scanner(System.in);
		Customer customer1=new FunExample().new Customer(sc1.nextLine(), sc1.nextLine());
		Predicate<Customer> checkHaveGirlFriend=t -> (m.containsKey(t.getUname()) ? 
				m.get(t.getUname()) : false);
		
		sc1.close();
		
		/*
		 * System.out.println( (checkHaveGirlFriend.test(customer1) ?
		 * "HaveGf Successful entry" : "Don't have gf no entry"));
		 */
		
		Map<Customer, Boolean> mapOfCustomer=new HashMap<>();
		mapOfCustomer.put(customer1, true);
		Predicate<Customer> checkHaveGirlFriend2=t -> 
		mapOfCustomer.entrySet().stream().map(map-> 
		String.valueOf(map.getKey().getUname())).toString().equals((t.uname)) ;
		
				//contentEquals(t.getUname()) ? 
				//m.get(t.getUname()) : false);
		
		System.out.println((checkHaveGirlFriend2.test(customer1) ? 
				"have gf go ahead" : "Not having gf no entry"));
		//mapOfCustomer.entrySet().stream().map(t->t.getKey().getUname())
	}
}
