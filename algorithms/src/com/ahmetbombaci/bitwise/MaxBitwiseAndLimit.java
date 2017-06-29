package com.ahmetbombaci.bitwise;

//https://www.hackerrank.com/challenges/30-bitwise-and/problem

/*
Task 
Given set S={1,2,,3,...N}. Find two integers, A and B (where A<B), from set S such that the value of A&B is the maximum possible and also less than a given integer, K. In this case, & represents the bitwise AND operator.
5 2 => 1
8 5 => 4
2 2 => 0

Constraints:
2<=N<=1000
2<=K<=N
*/
public class MaxBitwiseAndLimit {

    static int findRightMostZero(int x) {
        int pos = 0;
        while(x%2 != 0) {
            x >>= 1;
            pos++;
        }
        return pos;
    }
    static int replaceRightMostZeroWithOne(int x) {
        int pos = findRightMostZero(x);
        return x | (1<<pos);
    }
    

    public static void main(String[] args) {
        int N= 8;
        int K= 5;
        /*
         * max value has to be smaller than K so the best candidate is K-1
         * in order to obtain K-1, we need the number K-1 as well as another number, let's say X 
         * In binary representation of X, it has to have 1s where K-1 has
         * in addition,  at least one of the zeros has to be replaced with 1
         * in order to make X minimum, right-most zero has to be replaced by 1
         * 
         * Example: N: 20 K: 17
         * binary-K = 10001
         * binary-K-1 = 10000 = 16
         * in order to obtain 16, we need 10000 and another number like 1____ where one of the _ has to be 1
         * the minimum number that satisfy this condition is 10001 = 17 which is less than 20 (N)
         * 16&17=16
         * 
         * Another example: N: 6 K:4
         * binary-K = 100
         * binary-K-1 = 11 = 3
         * in order to obtain 3, we need 11 and another number like ___11 where one of the _ has to be 1
         * the minimum number that satisfy this condition is 111 = 7 which is greater than 6 (N) so it is not possible to get 3
         * in this case, we know that it is always possible to obtain K-2
         * why?
         * Let's assume that K-1 ends with zero (Rule 1)
         *    in this case, (K-1)&K=(K-1) so max value can be K-1 (because of constraint K<=N)
         * Let's assume that K-1 ends with one and we replaced the right-most zero with 1 and it became larger than N
         *    in this case, K-2 will end with zero and we know that because it ends with zero max value can be K-2 (see Rule 1)
         */
        int newNum = replaceRightMostZeroWithOne(K-1);
        if(newNum<=N)
            System.out.println(K-1);
        else
            System.out.println(K-2);
    }
}
