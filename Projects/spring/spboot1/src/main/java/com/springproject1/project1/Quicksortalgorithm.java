package com.springproject1.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Primary;

import jakarta.inject.Named;

@Named
@Primary
public class Quicksortalgorithm implements Sorting_algorithm{
	

	public int[] sort(int[] arr) {
		//sorting algorithm here
		int[] array=arr;
		ArrayList<Integer> a1=new ArrayList<Integer>();
		for(int i=0; i<array.length;i++) {
			a1.add(array[i]);
		}
		Collections.sort(a1, new intcomparator());
		for(int i=0; i<a1.size();i++) {
			array[i]=(int)a1.get(i);
		}
		return array;
		
	}
	@PostConstruct
	public void Postconstruct() {
		System.out.println("quicksort_postconstruct");
	}
	@PreDestroy
	public void predestroy() {
		System.out.println("Quicksort_predestroy");
	}
	
}
class intcomparator implements Comparator<Integer>{

	
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return -o1.compareTo(o2);
	}
	
}