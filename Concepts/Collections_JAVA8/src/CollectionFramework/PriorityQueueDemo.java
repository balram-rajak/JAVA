package rough_work;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<String> q=new PriorityQueue<>(new queuecomparator());
		
		q.offer("rakesh");
		q.offer("krishna");
		q.offer("balram");
		q.offer("subhadra");
		System.out.println(q.comparator());
		System.out.println(q.stream());
		System.out.println(q.poll());
		//q.offer(null);
		System.out.println(q);
		

	}

}

class queuecomparator implements Comparator<Object>{
	
	@Override
	public int compare(Object o1, Object o2) {
		
		String s1=o1.toString();
		String s2=o2.toString();
		
		return -s1.compareTo(s2);
	}
}