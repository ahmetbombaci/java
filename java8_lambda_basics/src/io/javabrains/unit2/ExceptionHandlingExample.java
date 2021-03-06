package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int [] someNumbers = {1,2,3,4};
		int key = 2;
		
		process(someNumbers,key, wrapperLambda((v,k) -> System.out.println(v/k)));

	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		// TODO Auto-generated method stub
		for(int x:someNumbers) {
			consumer.accept(x, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (k,v) -> {
			try {
				consumer.accept(k, v);;
			}
			catch(ArithmeticException e) {
				System.out.println("there is an exception");
			}
		};
	}

}
