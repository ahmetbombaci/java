package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		// Step 1: Sort list by last name
		
		/*
		//pre Java 8 way
		Collections.sort(people, new Comparator<Person>(){
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
		});		
		System.out.println(people); 
		*/
		
		//with lambda expressions
		Collections.sort(people, (o1,o2) -> o1.getLastName().compareTo(o2.getLastName()));		
				
		
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println(people); 
		
		
		// Step 3: Create a method that prints all people that have last name beginning with S
		people
			.stream()
			.filter(p -> p.getLastName().startsWith("S"))
			//.map(String::toUpperCase)   //not applicable here, just for reference
			//.sorted                     //not applicable here, just for reference
			.forEach(System.out::println);

		
		//video 14 at https://javabrains.io/courses/java_lambdabasics/lessons/Lambda-Exercise
		

	}
	
}
