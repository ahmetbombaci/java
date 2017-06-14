package com.ahmetbombaci.binary_search;

import java.util.Arrays;
import java.util.Random;

/*
 * Problem: You are given n binary values x0, x1, . . . , xn-1, such that xi is element of {0, 1}. This array
represents holes in a roof (1 is a hole). You are also given k boards of the same size. The goal
is to choose the optimal (minimal) size of the boards that allows all the holes to be covered
by boards.
 */
public class CoverHoles {
	static int countBoards(int[] holes, int length) {
		int boards =0;
		int end = -1;
		
		for(int i=0; i<holes.length; i++) {
			if(holes[i]==1 && end<i) {
				end=i+length-1;
				boards++;
			}
		}
		
		return boards;
	}
	
	static int findOptimalBoardSize(int[] holes, int k) {
		int n=holes.length;
		int left=1;
		int right=n;
		
		int result=-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(countBoards(holes, mid) <= k) {
				right = mid-1;
				result = mid;
			}
			else {
				left = mid+1;
			}
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(1000)+1;
		System.out.println("n is " + n);
		
		int[] holes = new int[n];
		System.out.print("holes[]={");
		for(int i=0; i<n; i++) {
			holes[i]=rand.nextInt(2);
			System.out.print(holes[i]+",");
		}
		System.out.println("}");
		
		System.out.println("The number of holes is "+Arrays.stream(holes).sum());
		
		int k = rand.nextInt(100)+1;
		System.out.println("k is "+k);
		
		int size=findOptimalBoardSize(holes,k);
		System.out.println("Optimal board size is "+size);
		
	}
	

}
