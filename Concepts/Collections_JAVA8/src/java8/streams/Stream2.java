package java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {

	static Function<String,String> giveChar=t -> {
		
		char[] c=t.toCharArray(); 
		for(int i=0; i<c.length; i++)
			t+=c[i]+" ";
		
		return t;
	};
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Krishna");
		list.add("Radhe");
		list.add("Balbhadra");
		list.add("Jagganath");
		list.add("Subhadra");
		list.add("Ram");
		list.add("Radhe");

		List<?> l = list.stream().map(name -> name.toCharArray())
				.collect(Collectors.toList());

		System.out.println("-----------Collect strings into List whose length<7--------");
		// collect() method
		l = list.stream().filter(s -> s.length() < 7).collect(Collectors.toList());

		l.stream().forEach(System.out::println);

		System.out.println("-----------Collect strings into List after converting to uppercase--------");
		// collect() method
		l = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

		l.stream().forEach(System.out::println);

		// count() method
		System.out.println("-----------count strings length less than 8-------- \n"
				+ list.stream().filter(s -> s.length() < 8).count());

		// Sorted() method with DNSO
		System.out.println("-----------default natural sorting--------");

		List<String> sortedList = list.stream().map(s -> s.toLowerCase()).sorted().collect(Collectors.toList());

		sortedList.stream().forEach(System.out::println);

		// Sorted() method with customized sorting
		System.out.println("--customized sorting --> increasing order of length of strings--------");
		List<String> coustomizedSortedList = list.stream().map(s -> s.toUpperCase()).sorted(MyComparator)
				.collect(Collectors.toList());

		coustomizedSortedList.stream().forEach(System.out::println);

		// Sorted() method with customized sorting
		System.out.println("-----customized sorting --> opposite of DNSO--------");
		List<String> coustomizedSortedList2 = list.stream().map(s -> s.toUpperCase())
				.sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());

		coustomizedSortedList2.stream().forEach(System.out::println);

		// Sorted() method with customized sorting
		System.out.println("---customized sorting --> decreasing order of length of strings--------");
		List<String> coustomizedSortedList3 = list.stream().map(s -> s.toLowerCase()).
				sorted((o1, o2) -> -((Integer)o1.length()).compareTo(o2.length()))
				.collect(Collectors.toList());

		coustomizedSortedList3.stream().forEach(System.out::println);
		
		//minimum value using min() function
		System.out.println("---customized sorting --> getting minimum value--------");
		Optional<String> minimumLength = list.stream().map(s -> s.toLowerCase()).
				sorted((o1, o2) -> -((Integer)o1.length()).compareTo(o2.length()))
				.min(MyComparator);

		minimumLength.stream().forEach(System.out::println);
		
		// maximum value using max() function
		System.out.println("---customized sorting --> getting maximum value--------");
		String maximumLength = list.stream().map(s -> s.toLowerCase()).
				sorted((o1, o2) -> -((Integer)o1.length()).compareTo(o2.length()))
				.max(MyComparator).get();

		System.out.println(maximumLength);

		list.stream().map(name -> name.toCharArray())
		.forEach(t -> {for(char c: t) 
			System.out.printf("%s \n",c);
		System.out.println("-----------------");
		});
		
		
		// adding each character of string to list and printing it
		System.out.println("---taking individual character out of all strings------");
		list.stream().map(name -> name.toCharArray())
		.map(t -> {
			List<Character> l1=new ArrayList<>();
			for(char c: t)
				l1.add(c);
			return l1;
		}).sequential()
		.forEach(System.out::println);
		
		// adding each character of string to list and printing it
				System.out.println("---taking individual character out of each distinct string------");
		list.stream().map(name -> name.toCharArray())
		.map(t -> {
			List<Character> l1=new ArrayList<>();
			for(char c: t)
				l1.add(c);
			return l1;
		}).distinct()
		.forEach(System.out::println);
		
		//using toArray() method
		String[] arr1=list.stream().toArray(String[]::new);
		
		Object[] arr2=list.stream().toArray();;
		for(Object o: arr2)
		System.out.println(o);
		
		Stream.of(arr1).forEach(System.out::println);
		
		
	}
	
static Comparator<String> MyComparator= (o1,o2) -> {
	
		if(o1.length() < o2.length())
			return -1;
		else if(o1.length() > o2.length()) 
			return +1;
		else
			return 0;

};

}
