package innerClasses.interfaceInsideInterface;

public interface InnerInterfaceInsideInterface {

	public void m1();
	
	interface entry<k,v>{
		
		public void enterPair(k key, v value);
	}
	
	
	
}

class Test implements InnerInterfaceInsideInterface.entry<String,String>{
	
	public static void main(String[] args) {
		
		InnerInterfaceInsideInterface.entry<String, String> i=(a,b) -> 
		System.out.printf("pair %s %s \n",a,b);
		i.enterPair("radhe","Krishna");
		
		InnerInterfaceInsideInterface outer=() -> 
		System.out.println("outer interface m1");
		outer.m1();
		
		Test t1=new Test();
		t1.enterPair("Radhe", "Krishna");
		
	}

	@Override
	public void enterPair(String key, String value) {
		System.out.printf("pair %s %s",key,value);
		
	}
}