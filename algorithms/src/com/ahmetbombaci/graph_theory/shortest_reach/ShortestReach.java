package com.ahmetbombaci.graph_theory.shortest_reach;

import java.io.*;
import java.util.*;




public class ShortestReach {

    public class Graph {
        public int size;
        public List<Node> nodes;
        
        public Node getNode(int nodeID) {
        	return nodes.get(nodeID);
        }
        
        Graph(int size) {
        	this.size = size;
        	nodes = new ArrayList<Node>();
        	for(int i=0; i<=size; i++) {
        		nodes.add(i, new Node(i));
        	}
        }
        
        public void calcDistance(int nodeID) {
        	Node currNode = nodes.get(nodeID);
        	
        	if(currNode == null) {
        		return;
        	}
        	else {
                Queue<Node> bfsNodeQueue = new LinkedList<>();

        		currNode.setDistance(0);
        		currNode.setVisited(true);
        		bfsNodeQueue.add(currNode);
        		
        		while(!bfsNodeQueue.isEmpty()) {
        			Node r = bfsNodeQueue.remove();
        			
        			for(Node n : r.neighbours) {
        				if(!n.isVisited()) {
        					n.setDistance(r.getDistance()+6);
        					n.setVisited(true);
        					bfsNodeQueue.add(n);
        				}
        			}
        		}
        	}
        }
        
        public void printDistanceList(int nodeID) {
        	for(int i=1; i<=size; ++i) {
        		if(i!=nodeID) {
        			Node r = nodes.get(i);
        			if(r==null)
        				System.out.print(-1 + " ");
        			else
        				System.out.print(r.getDistance() + " ");
        		}
        	}
        	System.out.println("");
        }
    }

    public class Node {
        public List<Node> neighbours = new ArrayList<Node>();
        private int ID;
        private boolean visited=false;
        private int distance=-1;
        
        Node(int ID) {
            this.ID = ID;
        }

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}
    }
    
    /*
     * Sample Input: 
     * 
2
4 2
1 2
1 3
1
3 1
2 3
2
     * Sample Output
     * 
6 6 -1
-1 6
     */
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	ShortestReach executer = new ShortestReach();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0=0; a0<q; ++a0) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            Graph myGraph = executer.new Graph(n);
            
            for(int a1=0; a1<m; ++a1) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                Node node1, node2;
                
                node1=myGraph.getNode(n1);
                node2=myGraph.getNode(n2);

                node1.neighbours.add(node2);
                node2.neighbours.add(node1);
            }
            
            int s = in.nextInt();
            
            myGraph.calcDistance(s);
            myGraph.printDistanceList(s);
        }
    }
    
    
}