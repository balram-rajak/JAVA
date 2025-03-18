package com.springproject1.project1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class Binarysearchalgo {

	@Inject
	private Sorting_algorithm Quicksortalgorithm;

	public int searching(int[] arr, int number) {
		// function for searching the number
		int x=0;
	int sorted_array[]=	Quicksortalgorithm.sort(arr);
		for(int i=0; i<sorted_array.length; i++) {
			if(sorted_array[i]==number)
				return i;
			
			else if(i==sorted_array.length-1)
				System.out.println("number not found");
				
		}
	
	System.out.println(Quicksortalgorithm);
		return x;
	}
	@PostConstruct
	public void Postconstruct() {
		System.out.println("binarysearch_postconstruct");
	}
	
	@PreDestroy
	public void predestroy() {
		System.out.println("biaryseach_predestroy");
	}
}
