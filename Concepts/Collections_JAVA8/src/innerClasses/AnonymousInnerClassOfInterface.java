package innerClasses;

import java8.functionalInterface.Caller;

public class AnonymousInnerClassOfInterface {

	Caller c1=new Caller() {

		int x;
		static int y;
		// it's optional to override default method of an interface
		@Override
		public void m2() {
			// TODO Auto-generated method stub
			Caller.super.m2();
			Caller.staticMethod();
		}


		@Override
		public void m3() {
			// TODO Auto-generated method stub
			Caller.super.m2();
			Caller.staticMethod();
		}
		
		/* can't override static method
		 * @Override public void staticMethod() { // TODO Auto-generated method stub
		 * Caller.super.m2(); Caller.staticMethod(); }
		 */
	};
}
