package com.springproject1.project1;

import java.util.Scanner;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan

public class Project1Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cont1=new AnnotationConfigApplicationContext(Project1Application.class);
		
		Scanner sc1= new Scanner(System.in);
		int[]arr = {9,4,3,6,45,2,89,532};
		int index;
		System.out.println("enter the searching number");
		int number=sc1.nextInt();
		
		//getting the index of the searched number
		index= cont1.getBean(Binarysearchalgo.class).searching(arr,number);
		System.out.println(index);
		
		sc1.close();
		cont1.close();
	}
	@PreDestroy
	public void predestroy() {
		System.out.println("project1app_predestroy");
	}
}
