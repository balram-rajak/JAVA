package rough_work;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		
		TreeMap<String,Integer> t=new TreeMap<>(new Treemapcomparator());
		t.put("balram",499);
		t.put("rashmi",1034);
		t.put("krishna",10000);
		t.put("narayan",40000);
		t.put(null,null);
		t.put("xxx", null);
		System.out.println(t);
	}
}

class Treemapcomparator implements Comparator<String>{
	
	
	
	public int compare(String o1, String o2)  {
		
		try {
		return -o2.compareTo(o1);
	}
		catch(Exception e) {
			return +1;
	}
	
		
	}
	
	

}
