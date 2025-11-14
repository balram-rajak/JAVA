package rough_work;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Navigablesetdemo {

	public static void main(String[] args) {
		NavigableMap<String,Integer> s=new TreeMap<>();
		s.put("balram",49);
		s.put("krsihna",13);
		s.put("kanha",56);
		s.put("sudama",20000);
		
		System.out.println(s.higherEntry("b"));
		System.out.println(s.ceilingEntry("c"));
		System.out.println(s.floorKey("r"));
		System.out.println(s.lowerKey("z"));
		System.out.println(s.pollFirstEntry());
		System.out.println(s.pollLastEntry());
		System.out.println(s.descendingMap());
		
	}
}
