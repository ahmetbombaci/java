package io.javabrains.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.Person;

public class StandardFunctionInterfacesExample {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		// Step 1: Sort list by last name
		Collections.sort(people, (o1,o2) -> o1.getLastName().compareTo(o2.getLastName()));		
				
		
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		performConditionally(people, p -> true, p -> System.out.println(p));
		
		
		// Step 3: Create a method that prints all people that have last name beginning with S
		System.out.println("Printing all persons with last name beginning with S");
		performConditionally(people, p->p.getLastName().startsWith("S"), p -> System.out.println(p.getFirstName()));
				


	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people)
			if(predicate.test(p))
				consumer.accept(p);
		
	}
}
