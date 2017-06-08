package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import io.javabrains.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		people.stream()
		.filter(p -> p.getLastName().startsWith("B"))
		.forEach(p -> System.out.println(p.getFirstName()))
		;
		
		Stream<Person> stream = people.stream();
		
		long count = people.stream()
		.filter(p -> p.getLastName().startsWith("B"))
		.count();
		System.out.println(count);
		
		

		long countParallel = people.parallelStream()
		.filter(p -> p.getLastName().startsWith("B"))
		.count();
		System.out.println(countParallel);

	}

}
