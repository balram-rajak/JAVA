package java8.methodReference;

import java.util.function.IntConsumer;

public class StaticMethod {

	public static void main(String[] args) {
		
		IntConsumer giveNothing=Sample::giveNum;
		giveNothing.accept(4);
		
		Job i1=Sample::giveRandomNumber;
		i1.m2();
		
		Sample s=new Sample();
		Job i2=s::given;
		
		i2.m2();
	}
}

class Sample{
	
	static int giveRandomNumber() {
		return (int)(Math.random()*10);
	}
	
	static void giveNothing(int i) {
		
		
	}
	
	void given() {
		
	}
	
	static int giveNum(int i) {
		return i;
		
	}
}

@FunctionalInterface
interface Job{
	
	void m2();
	
}