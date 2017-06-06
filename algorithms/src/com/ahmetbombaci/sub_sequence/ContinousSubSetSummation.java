package com.ahmetbombaci.sub_sequence;

import java.io.*;
import java.util.*;

public class ContinousSubSetSummation {

	public static boolean checkTargetValue(List<Integer> myArray, int targetValue) {
		int sum = 0;
		int left = 0;

		for (int i = 0; i < myArray.size(); i++) {
			sum += myArray.get(i);
			if (sum == targetValue)
				return true;
			else if (sum > targetValue) {
				while(sum>targetValue) {
					sum-=myArray.get(left);
					left++;
				}
				if(sum == targetValue) {
					if(targetValue==0) {
						if(myArray.get(i)==0)
							return true;
					}
					else
						return true;
				}
			}

		}

		return false;
	}

	/*
	 * 
	 * 
	 // [6, 3, 5, 23], 8 # True (because 3 + 5 = 8) 
	 // [6, 3, 5, 23], 7 #False 
	 // [6, 3, 5, 23], 11 # False 
	 // [6, 3, 5, 23], 6 # True 
	 // []           , 0 #False 
	 // [1,2,3]      , 0 # False 
	 // [1,2,3,0]    , 0 # True
	 * 
	 * 4 8 6 3 5 23
	 * 4 7 6 3 5 23
	 * 4 11 6 3 5 23
	 * 4 6 6 3 5 23
	 * 0 0
	 * 3 0 1 2 3
	 * 4 0 1 2 3 0
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> myArray = new ArrayList<Integer>();
		int n = scan.nextInt();
		int targetValue = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			myArray.add(scan.nextInt());
		}

		if (checkTargetValue(myArray, targetValue)) {
			System.out.println("True");
		} else
			System.out.println("False");

	}
}
