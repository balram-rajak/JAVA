package java8.LambdaExpressions;

@FunctionalInterface
interface main1 extends retrieve{
	
	//void m1();
	
	public static void main() {
		System.out.println("static");
	}
	
	
	default int m2(int x) {
		System.out.println("default");
		return x;
	}
	
}