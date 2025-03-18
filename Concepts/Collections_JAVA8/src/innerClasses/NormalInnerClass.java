package innerClasses;

public class NormalInnerClass {

	static int y=1;
	int x=0;
	class Inner{
	
		static int z=3;
		 int x=3;
		
		 void m1() {
			 
			 System.out.println(y); 
			 System.out.println("inner class x: "+this.x);
			 System.out.println("outer class"
			 		+ " x: "+NormalInnerClass.this.x);
			
		}
		
		 static void m2(int a,int b) {
			 System.out.println(a+b);
		 }
		/*public static void main(String[] args) {
			System.out.println(" Inner main"); 
			
			Will not run the program implicitly 
			and exception will occur
			To run we have to explicitly mention this as main
			method in run configuration
			}*/
		}
		
	void mymember() {
		 Inner i1=new Inner();
		 i1.m1();
		 System.out.println(Inner.z);
	}
	
		
		  public static void main(String[] args) {
		  
		  NormalInnerClass n1=new NormalInnerClass();
		 
		  // method 1 to create object of inner class
		  Inner inner1=n1.new Inner(); 
		  
		  //and calling inner class function
		  inner1.m1();
		  
		  Inner.m2(4,6);
		  
		  //Anonymous object of inner class and calling m1()
		  n1.new Inner().m1();
		  
		  //calling m1 through outer class function
		  n1.mymember();
			
		  System.out.println(" Outer main");
		  
		  }
		 
	
	
	
	
	
}
