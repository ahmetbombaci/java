package com.ahmetbombaci.sub_sequence;

import java.util.Scanner;

/*
 * Question link: https://www.hackerrank.com/challenges/maxsubarray
 */
public class MaximumSubarray {
    public Result findMaxSubarray(int[] arr) {
        int size=arr.length;
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        int sumPositive=0;
        for(int i=0; i<size; i++) {
            if(arr[i]>0)
                sumPositive += arr[i];
            
            sum+=arr[i];            
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
        }
        
        Result r = new Result();
        r.contiguousMax = max;
        r.nonContiguousMax = (max<0)?max:sumPositive;
        return r;    
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	MaximumSubarray exec = new MaximumSubarray();
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++) {
            int n=in.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = in.nextInt();
            }
            Result r = exec.findMaxSubarray(arr);
            System.out.println(r.contiguousMax + " " + r.nonContiguousMax);
        }
        
    }

}


class Result {
    int contiguousMax;
    int nonContiguousMax;
}