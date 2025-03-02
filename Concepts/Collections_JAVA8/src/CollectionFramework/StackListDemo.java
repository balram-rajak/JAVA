package rough_work;

import java.util.Stack;
public class StackListDemo {

	public static void main(String[] args) {
		
		Stack s= new Stack();
		
		s.push("Q");
		s.push(null);
		s.push(13);
		System.out.println(s);
		System.out.println(s.peek());
		s.push(true);
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.search(false));
		
		
		System.out.println(s.empty());
		
		Stack s1= (Stack) s.clone();
		s.clear();
		System.out.println(s.empty());
		System.out.println(s1.empty());
		System.out.println("null present at "+ s1.search(null));
		System.out.println(s.capacity());
		

		
	}
}
