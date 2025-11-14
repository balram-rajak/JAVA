public class Student {
    private String name;
    private int rollNumber;
    private double marks;
    
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}
