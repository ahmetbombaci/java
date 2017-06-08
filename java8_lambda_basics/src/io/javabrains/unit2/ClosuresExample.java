package io.javabrains.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20; //this has to be final since it has been used in anonymous inner class
		
		doProcess(a, i -> System.out.println(i+b));  //lambda expression version
		
		doProcess(a, new Process() {  //anonymous inner class version

			@Override
			public void process(int i) {
				// TODO Auto-generated method stub
				System.out.println(i+b);
			}
			
		});

	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}