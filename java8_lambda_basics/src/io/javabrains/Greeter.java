package io.javabrains;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		Greeting helloWorldGreeting = new HelloWorldGreeting();		
		Greeting lambdaGreeting = () -> System.out.println("Hello World!"); 
		Greeting innerClassGreeting = new Greeting() { //anonymous inner class
			public void perform() {
				System.out.println("Hello world inner!");
			}
		};
		

		helloWorldGreeting.perform();
		lambdaGreeting.perform();
		innerClassGreeting.perform();

		greeter.greet(lambdaGreeting);
		greeter.greet(() -> System.out.println("Hello World!")); //Type Inference
		greeter.greet(innerClassGreeting);

		//MyAdd addFunction = (int a, int b) -> a + b;
		
		/*
		doubleNumber = (int a) -> a * 2;
		
		
		safeDivide = (int a, int b) -> {
			if(b==0) return 0;
			return a / b;
		};
		
		stringLengthCountFunction = (String s) -> s.length();
		*/
	}

}


interface MyAdd {
	int perform(int x, int y);
}
