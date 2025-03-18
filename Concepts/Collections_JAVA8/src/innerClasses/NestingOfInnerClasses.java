package innerClasses;

public class NestingOfInnerClasses {

	public static void main(String[] args) {
		Test.A.B o=new Test().new A().new B();
		o.m1();
	}
}

class Test{

	class A{
		class B{
			void m1() {
				System.out.println("inner most class function");
			}
			
		}
	}
}