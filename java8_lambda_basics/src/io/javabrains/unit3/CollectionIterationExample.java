package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;

import io.javabrains.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		System.out.println("Using for loop");
		for(int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Using for-in loop");
		for(Person p : people) {
			System.out.println(p);
		}

		System.out.println("Using lambda for-each loop"); //can be executed in parallel-multi-threaded
		people.forEach(p -> System.out.println(p));
		people.forEach(System.out::println);
		

	}

}
