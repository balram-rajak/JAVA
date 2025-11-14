package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class UnboundedWildcards {

	static void printObjectList(List<Object> l){
		
		for(Object list:l)
		System.out.println(list);
		
	}
	
static void printUnknownList(List<?> l){
		
		for(Object list:l)
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		
		List<?> li = Arrays.asList("true", 2, 3,false);
		List<Object> bytes = Arrays.asList(87, 0x65, 0x65);
		printObjectList(bytes);
		printUnknownList(li);
		
		List<? extends Object>[] arrayOfList = new List<?>[1];
		arrayOfList[0]=li;
		//List<? extends Object>[] arrayOfAnotherList = new List<? super Integer>[1];
		
		List anotherList = new ArrayList<>();
		//boolean instanceTest = anotherList instanceof List<? super Integer>;
		//System.out.println(instanceTest);
		
		System.out.println(new List<>() {

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray(Object[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(int index, Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object get(int index) {
				// TODO Auto-generated method stub
				
				return index;
			}

			@Override
			public Object set(int index, Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void add(int index, Object element) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ListIterator listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
		}.get(0)
				
		
				);
		
		List l=new ArrayList<>() {

			private static final long serialVersionUID = 1L;

			Optional x=Optional.empty();
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Object> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Object e) {
				
				try{x=Optional.of(e);}
				catch(Exception ex) {
					return false;
				}
				
				return true;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Object> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(int index, Collection<? extends Object> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object get(int index) {
				
				return x;
			}

			@Override
			public Object set(int index, Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void add(int index, Object element) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ListIterator<Object> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<Object> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Object> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}
		

	};
	
	//l=Arrays.asList("balram","krishna");
	List<?> l1=new LinkedList<>();
	l.add("Krishna");
	l1=l;
	
	System.out.println(l1.getClass());
	System.out.println(l.get(0));
	printUnknownList(l);
}
}









