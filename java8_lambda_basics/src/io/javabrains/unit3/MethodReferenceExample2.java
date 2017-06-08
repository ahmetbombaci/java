package io.javabrains.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.Person;

public class MethodReferenceExample2 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ahmet","Bombaci",44),
				new Person("Dorina","Strori",33),
				new Person("Emir","Bombaci",9),
				new Person("Yavuz","Leblebici",23)
				
				);
		
		
		
		System.out.println("Printing all persons");
		//performConditionally(people, p -> true, p -> System.out.println(p));
		performConditionally(people, p -> true, System.out::println);  //Method Reference version of above lambda expression
																		// p-> method(p) type of lambda expressions can be expressed with Method Reference too


	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people)
			if(predicate.test(p))
				consumer.accept(p);
		
	}

}
