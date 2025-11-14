package rough_work;

public class Employee implements Comparable{

	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	private String name;
	private int id;
	private double salary;
	
	
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, int id) {
		this.name=name;
		this.id=id;
		
	}
	
	public String get_name() {
		return this.name;
	}
	
	int get_id() {
		return id;
	}
	
	public String toString() {
		return "("+name+","+id+")";
	}
	public int compareTo(Object o) {
		
		Employee o1=this;
		Employee o2=(Employee)o;
		 int id1=o1.id;
		 int id2=o2.id;
		
		
		if(id1 < id2)
			return -1;
		else if(id1>id2)
			return +1;
		else 
		return 0;
	}

}
