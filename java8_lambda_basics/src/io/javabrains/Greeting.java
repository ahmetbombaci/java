package io.javabrains;

//new annotation added for lambda interfaces. Forces developer to define just 1 abstract interface
//java 8 allows to implement functions in the interface classes
@FunctionalInterface
public interface Greeting {
	public void perform();
}
