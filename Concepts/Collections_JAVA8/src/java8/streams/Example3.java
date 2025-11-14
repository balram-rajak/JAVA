package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Krishna");
		list.add("Radhe");
		list.add("Baldeo");
		list.add("Jagganath");
		list.add("Subhadra");
		list.add("Ram");
		list.add("Radhe");
		
		System.out.println(list.stream().reduce("a",(t, u) -> t));;
		
		List<Integer> numbers=List.of(34, 234, 3, 64, 23, 675, 2397, 4, 7, 34, 54);
		
		System.out.println(
				numbers.stream().map(t -> t*t).reduce(0,Integer::sum));
		
		System.out.println(numbers.stream().allMatch(t -> t>17));
		System.out.println(numbers.stream().noneMatch(t -> t>17));
		System.out.println(numbers.stream().anyMatch(t -> t!=0));
		
		System.out.println(numbers.stream().skip(3).limit(5).collect(Collectors.toList()));
		System.out.println(numbers.stream().takeWhile(t -> t<275)
				.collect(Collectors.toList()));
		
		System.out.println(numbers.stream().filter(t -> t%2==0).findFirst().get());
		System.out.println(list.stream().filter(t -> t.contains("balbhadra"))
				.min((o1, o2) -> o1.compareTo(o2)).orElse("Krishna always"));
		
		System.out.println(list.stream().filter(t -> t.contains("h"))
				.min((o1, o2) -> o1.compareTo(o2)).orElse("Krishna always"));
		
		System.out.println(numbers.stream().filter(t -> t%2==0)
				.mapToInt(t -> t*t).average());
		
		System.out.println(numbers.stream().filter(t -> t%2==0)
				.mapToInt(t -> t*t).max());
	}
}
