package com.ahmetbombaci.graph_theory.roads_and_libraries;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            
            HashMap<Integer,Integer> cityMap = new HashMap<>();
            HashMap<Integer,HashSet<Integer>> cityClusters = new HashMap<>();
            
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                
                if(cityMap.containsKey(city_1)) {  //city_1 is connected to another city so connect city_2 to the same city
                    int city1Cluster = cityMap.get(city_1);
                    cityMap.put(city_2,city1Cluster);
                    HashSet<Integer> cluster = cityClusters.get(city1Cluster);
                    cluster.add(city_2);
                    cityClusters.put(city1Cluster, cluster);
                }
                else if(cityMap.containsKey(city_2)) {  //city_2 is connected to another city so connect city_1 to the same city
                    int city2Cluster = cityMap.get(city_2);
                    cityMap.put(city_1,city2Cluster);
                    HashSet<Integer> cluster = cityClusters.get(city2Cluster);
                    cluster.add(city_1);
                    cityClusters.put(city2Cluster, cluster);
                }
                else {  //neither city_1 nor city_2 is connected to any city. Create new mapping
                    cityMap.put(city_1,city_1);
                    cityMap.put(city_2,city_1);
                    HashSet<Integer> cluster = new HashSet<>();
                    cluster.add(city_2);
                    cityClusters.put(city_1, cluster);
                }
            }
            
            for(int a1 = 1; a1 <= n; a1++){
                if(!cityMap.containsKey(a1)) {
                    cityClusters.put(a1,new HashSet<Integer>());
                }
            }
            
            if(x<=y) { //building a library is cheaper than repearing a road
                long totalCost=(long)n*x;
                System.out.println(totalCost);
            }
            else {
                long totalCost=0L;
                for(int headCity : cityClusters.keySet()) {
                    //System.out.println("Debug: headCity: " + headCity + " contains " + cityClusters.get(headCity).size() + " cities.");
                    totalCost+= x + (long)(y * cityClusters.get(headCity).size());
                }
                System.out.println(totalCost);
            }
        }
    }
}
