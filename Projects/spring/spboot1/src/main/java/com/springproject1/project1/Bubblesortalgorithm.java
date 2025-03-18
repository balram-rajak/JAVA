package com.springproject1.project1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.inject.Named;

@Named
@Qualifier("bubble")
public class Bubblesortalgorithm implements Sorting_algorithm{

	int arr[];
	
	public int[] sort(int[] arr) {
		// sorting logic here
		
		this.arr=arr;
		Arrays.sort(arr);
		return arr;
	}
	
}
