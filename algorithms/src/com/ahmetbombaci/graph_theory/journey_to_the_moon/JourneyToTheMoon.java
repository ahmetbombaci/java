package com.ahmetbombaci.graph_theory.journey_to_the_moon;

import java.io.*;
import java.util.*;


public class JourneyToTheMoon {

    public static void mergeNations(int nationList[], int n1, int n2, int nationCounter) {
        int n = nationList.length;
        int from, to;
        if(n1>n2) {
            from=n1;
            to=n2;
        }
        else {
            from=n2;
            to=n1;
        }
        
        for(int i=0; i<n; i++) {
            if(nationList[i] == from)
                nationList[i] = to;
            else if(nationList[i]==nationCounter-1)
                nationList[i] = from;
        }
    }
    

    /*
     * Sample Input 0: 
     * 
5 3
0 1
2 3
0 4
     * Sample Output 0:
     * 
6
     * 
     * 
     * Sample Input 1: 
     * 
4 1
0 2
     * Sample Output 1:
     * 
5
     * 
     * 
     * Sample Input 2: 
     * 
1 1
0 0
     * Sample Output 2:
     * 
0
     * 
     * 
     * Sample Input 3: 
     * 
5 3
0 1
2 3
1 2
     * Sample Output 3:
     * 
0
     * 
     * 
     * Sample Input 4: 
     * 
100000 1
0 1
     * Sample Output 4:
     * 
4999949999
     */

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nationList[] = new int[n];
        Arrays.fill(nationList , -1);
        
        int p = in.nextInt();
        int nationCounter=0;
        
        //set nation list for pair astronauts
        for(int i=0; i<p; i++) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            
            int n1 = nationList[a1];
            int n2 = nationList[a2];
            
            //System.out.println("a1-2 n1-2:" + a1 + " " + a2 + " " + n1 + " " + n2);
            if(n1 == -1 && n2 == -1) {
                nationList[a1] = nationCounter;
                nationList[a2] = nationCounter;
                nationCounter++;
            }
            else if(n1 == -1) {
                nationList[a1] = nationList[a2];
            }
            else if(n2 == -1) {
                nationList[a2] = nationList[a1];
            }
            else if(n1 != n2) {
                mergeNations(nationList, n1, n2, nationCounter);
                nationCounter--;
            }
        }
        
        //set nation list for the astronauts where there is nobody else from the same nation 
        for(int i=0; i<n; i++) {
            if(nationList[i] == -1) {
                nationList[i] = nationCounter;
                nationCounter++;
            }
        }
        
        if(nationCounter<2) {
            System.out.println(0);
        }
        else {
            int nationMatrix[] = new int[nationCounter];
            Arrays.fill(nationMatrix , 0);

            for(int i=0; i<n; i++) {
                //System.out.println("nationList["+i+"]"+nationList[i]);
                nationMatrix[nationList[i]]++;
                //System.out.println("nationMatrix["+nationList[i]+"]"+nationMatrix[nationList[i]]);
            }
            //System.out.println("nationCounter:"+nationCounter);
            long result = (long) n * (n-1) / 2;
            for(int i=0; i<nationCounter; i++) {
                //System.out.println("nationMatrix["+i+"]:"+nationMatrix[i]);
                if(nationMatrix[i]>1) {
                    result -= (long) nationMatrix[i] * (nationMatrix[i]-1) / 2;
                }
            }
            System.out.println(result);
        }
    }
}
