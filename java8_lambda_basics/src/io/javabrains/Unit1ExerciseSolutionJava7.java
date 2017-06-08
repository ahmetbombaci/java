package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		// Step 1: Sort list by last name
		Collections.sort(people, new Comparator<Person>(){
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
		});		
		
		
		
		
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		printAll(people);

		
		
		// Step 3: Create a method that prints all people that have last name beginning with S
		System.out.println("Printing all persons with last name beginning with S");
		printConditionally(people, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("S");
			}
			
		});

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p: people)
			if(condition.test(p))
				System.out.println(p); 
		
	}

	private static void printAll(List<Person> people) {
		for(Person p: people)
			System.out.println(p); 
		
	}
	
	

}

interface Condition {
	boolean test(Person p);
}
