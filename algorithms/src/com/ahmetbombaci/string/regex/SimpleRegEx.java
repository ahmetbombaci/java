package com.ahmetbombaci.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegEx {
	
	//print consecutive [a-zA-Z] characters
	public static void printWords(String input) {
		String myRegex = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(myRegex);
		Matcher match = pattern.matcher(input);
		while(match.find()) {
			System.out.println(match.group());
		}
	}
	
	//print consecutive [a-zA-Z] characters as well as whitespace
	public static void printWordsPunctuation(String input) {
		String myRegex = "[a-zA-Z\\s]+";
		Pattern pattern = Pattern.compile(myRegex);
		Matcher match = pattern.matcher(input);
		while(match.find()) {
			System.out.println(match.group());
		}
	}
	
	public static void printCount(String input, String mask) {
		Pattern pattern = Pattern.compile(mask);
		Matcher match = pattern.matcher(input);

		//int count = match.groupCount();  //not working
		int count=0;
		
		while(match.find()) {
			++count;
			System.out.println(match.group());
		}
		
		System.out.println("There are " + count + " " + mask + " in " + input);		
	}
	
	private static void printInput(String input) {
		System.out.println("input: "+input);
		System.out.println("------------------------------");
	}

	public static void main(String[] args) {
		String testInput1 = "cat, dog, monkey horse caterpillar";
		
		printInput(testInput1);
		printWords(testInput1);
		System.out.println("------------------------------\n\n\n\n");

		printInput(testInput1);
		printWordsPunctuation(testInput1);
		System.out.println("------------------------------\n\n\n\n");

		printInput(testInput1);
		printCount(testInput1, "[a]");
		System.out.println("------------------------------\n\n\n\n");  // prints 3
		
		printInput(testInput1);
		printCount(testInput1, "[o][a-z]");
		System.out.println("------------------------------\n\n\n\n");  // prints 3
		

		printInput(testInput1);
		printCount(testInput1, "[at]");  // 'a' or 't'
		System.out.println("------------------------------\n\n\n\n");  // prints 5
		

		printInput(testInput1);
		printCount(testInput1, "(at)");  // "at" together
		System.out.println("------------------------------\n\n\n\n");  // prints 2

		printInput(testInput1);
		printCount(testInput1, ".d+");  // . any char following by char 'd'
		System.out.println("------------------------------\n\n\n\n");  // prints 1
		
		printInput(testInput1);
		printCount(testInput1, "\\d+");  // A digit: [0-9]
		System.out.println("------------------------------\n\n\n\n");  // prints 0

		printInput(testInput1);
		printCount(testInput1, "\\D+");  // A non-digit: [^0-9]
		System.out.println("------------------------------\n\n\n\n");  // prints 1

		printInput(testInput1);
		printCount(testInput1, "\\p{Punct}");  // Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
		System.out.println("------------------------------\n\n\n\n");  // prints 2
		
	}

}
