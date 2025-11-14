package abstractclass;

public abstract class InheritClassInAbstract extends Test{

	Test t=new Test();
	
	final int  j=t.i=0;
	 int z=t.i;
	 static int x=0;
	
	public static void main(String[] args) {
		
		
		Test t1=new Test();
		System.out.println(t1.i);
		System.out.println();
	}
	
	
	  @Override 
	  void m1() { //optional not necessary to override
	  
	  }
	 
	  @Override
	public
		int hashCode() {
			return j;
		  
	  }
	
	static void m2() {
		
	}
	
	final void methodFinal() {
	}
	
	abstract void absFn();
	

}


class Test{
	
	public int i;
	
	void m1() {
		
	}
}


