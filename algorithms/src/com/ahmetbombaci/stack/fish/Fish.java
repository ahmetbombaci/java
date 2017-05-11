package com.ahmetbombaci.stack.fish;

import java.util.Stack;

public class Fish {
    int size;
    int direction;
    Fish(int _size, int _direction) {
        this.size = _size;
        this.direction = _direction;
    }
    
    
    public static int countAliveFish(int[] A, int[] B) {
        // write your code in Java SE 8
        Stack<Fish> river = new Stack<>();
        
        for(int i=0; i<A.length; ++i) {
            if(B[i]==1) {  //no need to do anything with downstream fish
                river.push(new Fish(A[i],B[i]));
            }
            else {  //handle upstream fish
                if(river.isEmpty()) {  //check stack: no fish, no worry
                    river.push(new Fish(A[i], B[i]));
                }
                else {  //if there is a fish
                    Fish top = river.pop();
                    if(top.direction==0) { //and it is upstream too, then put them back to stack
                        river.push(top);
                        river.push(new Fish(A[i], B[i]));
                    }
                    else { //compare their sizes
                        if(A[i]>top.size)
                            --i;  //if upstream fish is bigger, repeat the process again
                        else
                            river.push(top);  //otherwise; skip current fish
                    }
                }
            }
        }
        
        return river.size();
    }
    
    public static void main(String[] args) {
    	int A[] = {4,3,2,1,5};
    	int B[] = {0,1,0,0,0};
    	
    	int x = countAliveFish(A, B);
    	
    	System.out.println("Solution is "+ x);
    }

}
