package string;

import java.util.stream.Stream;

public class StringBuilder1 {

	public static void main(String[] args) {
		
		StringBuilder s1=new StringBuilder();
		
		s1.append(4);
		
		s1.append("Gauranga");
		
		char[] sub=new char[8];
		sub[1]='R';
		sub[3]='f';
		sub[2]='r';
		sub[4]='q';
		sub[6]='k';
		s1.getChars(2,4,sub,4);
		System.out.println(s1.toString());
		Stream.of(sub).forEach(System.out::println);
		System.out.println(s1.charAt(s1.offsetByCodePoints(2,4)));
		System.out.println(s1.codePointAt(6));
		System.out.println(s1.codePointAt(2));
		s1.insert(4, false);
		System.out.println(s1);
		System.out.println(s1.lastIndexOf("a"));
		System.out.println(s1.capacity());
		s1.trimToSize();
		System.out.println(s1 +"capacity = "+s1.capacity()+" length = "+s1.length());
		s1.ensureCapacity(20);
		System.out.println(s1 +"capacity = "+s1.capacity()+" length = "+s1.length());
		s1.setLength(3);
		System.out.println(s1 +"capacity = "+s1.capacity()+" length = "+s1.length());
		
		
	}
}
