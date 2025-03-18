package java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example4 {

	
	public static void main(String[] args) {
		
		List<Course> courses=List.of(new Course("Spring","framework",93,57),
				new Course("Spring boot","framework",98,57),
				new Course("AWS","cloud",87,46),
				new Course("AZURE","cloud",86,45),
				new Course("GCP","cloud",88,52),
				new Course("JAVAC","language",99,108),
				new Course("c++","language",87,84),
				new Course("Fullstack","fullstack",97,102));
		
		System.out.println(courses.stream().filter(t -> t.getReviewScore()<93).count());
		System.out.println(courses.stream().filter(t -> t.getReviewScore()>93)
				.mapToInt(value -> value.getNoOfStudents()).max().getAsInt());
		
		System.out.println(courses.stream().filter(t -> t.getReviewScore()>93)
				.mapToInt(value -> value.getNoOfStudents()).sum());
		
		System.out.println(courses.stream().takeWhile(t -> t.getReviewScore()<98)
				.collect(Collectors.toList()));
		
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.averagingDouble(Course::getNoOfStudents))));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName,Collectors.toList()))));
		
		List<Course> course2=courses;
		System.out.println(courses.stream().flatMap(c1 -> course2.stream()
				.map(c2 -> List.of(c1.getName(),c2.getName())))
				.filter(t -> t.get(0).length()==(t.get(1).length()) && !t.get(0)
				.equals(t.get(1)))
				.distinct()
		.collect(Collectors.toList()));
		
	}
}
