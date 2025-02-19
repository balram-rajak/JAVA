package java8.functionalInterface.predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Authentication {

	private class User{
		public String getUname() {
			return uname;
		}
		public String getPass() {
			return pass;
		}
		public User(String uname, String pass) {
			super();
			this.uname = uname;
			this.pass = pass;
		}
		private String uname;
		private String pass;
		
	}
	
	public static void main(String[] args) {
		Map<String, String> m=new HashMap<String, String>();
		m.put("balram", "det452");
		Scanner sc1=new Scanner(System.in);
		String uname=sc1.nextLine();
		User user1=new Authentication().new User(uname,sc1.nextLine());
		
		Predicate<User> authenticateUser=t -> 
		t.getPass().contentEquals(m.get(uname)!=null ? m.get(uname) : "*_*");
				
		System.out.println("login "+
		(authenticateUser.test(user1) ? "successful": "unsuccessful"));;
				sc1.close();
	}
}
