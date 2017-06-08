package io.javabrains.unit2;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			System.out.println(this);  //value of this reference is the same as outside. it is not the same as anonymous inner class
		});
	}
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			//System.out.println(this);  //value of this reference is the same as outside. it is not the same as anonymous inner class
		});
		
		thisReferenceExample.execute();
		
		thisReferenceExample.doProcess(10, new Process() {

			@Override
			public void process(int i) {
				// TODO Auto-generated method stub
				System.out.println("Value of i is " + i);
				System.out.println(this);
			}
			
			public String toString() {
				return "This is the anonymous inner class";
			}
		});
		
		
		
		
	}
	public String toString() {
		return "This is the main ThisReferenceExample class instance";
	}
}
