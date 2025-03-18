package java8.streams;

public class Course {
public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
private String name;
private String category;
private int reviewScore;
private int noOfStudents;
public String getName() {
	return name;
}
public String getCategory() {
	return category;
}
public int getReviewScore() {
	return reviewScore;
}
public int getNoOfStudents() {
	return noOfStudents;
}
@Override
public String toString() {
	return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
			+ noOfStudents + "]";
}


}
