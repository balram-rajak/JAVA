package java8.functionalInterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerFunctionPredicate1 {

	static Predicate<Integer> greaterThansixty=t -> t>=60;
	
	static Function<Student, String> getGrade=t -> {
		if(greaterThansixty.test(t.getMarks())) { 
			String grade;
			
		switch ( t.getMarks()) {
		
		case 60: grade="pass" ; break;
		
		case 70: grade="A"; break;
		
		case 80: grade="B"; break;
		
		case 90: grade="E"; break;
		
		case 100: grade="O"; break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + t.getMarks());

		};
		
		return grade;
		}
		
		else
			return "fail";
	
	};
	
	static Consumer<Student> printStudentName=t -> System.out.print(t.getName()+" ");
	
	static Consumer<Student> printStudentMarks=t -> System.out.print(t.getMarks()+" ");
	
	static Consumer<Student> printStudentGrade=t -> System.out.println(getGrade.apply(t)); 
	
	// Consumer chaining
	static Consumer<Student> printStudentObject=t -> printStudentName.
			andThen(printStudentMarks).
			andThen(printStudentGrade).accept(t);;
	
	static void populate(List<Student> student){
		
		student.add(new Student(100,"Krishna"));
		student.add(new Student(80,"Balbhadra"));
		student.add(new Student(90,"Kunti"));
		student.add(new Student(70,"Arjun"));
		student.add(new Student(10,"HiranyaKashayapu"));
		student.add(new Student(200,"radjhe"));
	
	}
	
	public static void main(String[] args) {
		
		List<Student> student=new ArrayList<>();
		populate(student);
		
		student.stream().forEach(object -> printStudentObject.accept(object));
		
	}
	
}


class Student{
	
	public Student(Integer marks, String name) {
		super();
		this.marks = marks;
		this.name = name;
	}
	private Integer marks;
	private String name;
	public Integer getMarks() {
		return marks;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]";
	}
	
	
	
	
}