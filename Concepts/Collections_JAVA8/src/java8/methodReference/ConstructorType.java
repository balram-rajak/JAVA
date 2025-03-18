package java8.methodReference;

public class ConstructorType {

	 public static void main(String[] args) {
		
		 Test t=new Test();
		 
		 Pair i=Test::new;
		 
		 System.out.println(i.getObject());
		 
		 Human i2=Test::new;

		 System.out.println(i2.getObj(4,9));
		 
	}
}

interface Pair{
	
	Test getObject();
	
	//void getObjectWithArgument(int x, int y);
}

interface Human{
	
	Test getObj(int num1, int num2);
}

class Test{
	
	int x;
	int y;
	
	@Override
	public String toString() {
		return "Test [x=" + x + ", y=" + y + "]";
	}

	Test(){
		
	}
	
	Test(int x, int y){
		this.x=x;
		this.y=y;
	}
}