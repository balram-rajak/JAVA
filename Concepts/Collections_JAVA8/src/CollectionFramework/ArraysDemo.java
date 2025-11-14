package rough_work;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] a=new int[4];
		Scanner sc1=new Scanner(System.in);
		for(int b=0;b<4;b++) {
			a[b]=sc1.nextInt();
			
		}
		Arrays.sort(a);
		for(int b:a)
		System.out.println(b);
		String[] s=new String[4];
		for(int b=0;b<4;b++) {
			s[b]=sc1.nextLine();
			
		}
		Arrays.sort(s);
		for(String b:s)
			System.out.println(b);
		
		Byte[] b=new Byte[4];
		for(int i=0;i<4;i++) {
			b[i]=sc1.nextByte();
			
		}
		Arrays.sort(b,new bytecomparator());
		for(Byte i:b)
			System.out.println(i);
		
		sc1.close();
	}
}

final class bytecomparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return (((Byte) o1).compareTo((Byte)o2));
	}
	
}