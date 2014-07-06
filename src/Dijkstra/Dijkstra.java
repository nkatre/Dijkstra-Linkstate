package ToSubmitLinkstate;


/* 
 * authors: nikhil pankil
 * 
 * To compute Task1 changes are made which can be seen by Ctrl+F("Task1")
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public ArrayList<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
       
    public Vertex(String argName) 
    { name = argName; }   
    public String getName(){
		return this.name;   	
    }
    public String toString() { return name; }    
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
	public Vertex getTarget() {
		return target;
	}
	public double getWeight() {
		return weight;
	}
    
}

public class Dijkstra
{
	public static PriorityQueue<Vertex> vertexQueue;
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        vertexQueue = new PriorityQueue<Vertex>();
	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);

		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
		}
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
    	
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
/*
    public static void main(String[] args)
    {
    Vertex v0 = new Vertex("Harrisburg");
	Vertex v1 = new Vertex("Baltimore");
	Vertex v2 = new Vertex("Washington");
	Vertex v3 = new Vertex("Philadelphia");
	Vertex v4 = new Vertex("Binghamton");
	Vertex v5 = new Vertex("Allentown");
	Vertex v6 = new Vertex("New York");
	v0.adjacencies = new Edge[]{ new Edge(v1,  79.83),
	                             new Edge(v5,  81.15) };
	v1.adjacencies = new Edge[]{ new Edge(v0,  79.75),
	                             new Edge(v2,  39.42),
	                             new Edge(v3, 103.00) };
	v2.adjacencies = new Edge[]{ new Edge(v1,  38.65) };
	v3.adjacencies = new Edge[]{ new Edge(v1, 102.53),
	                             new Edge(v5,  61.44),
	                             new Edge(v6,  96.79) };
	v4.adjacencies = new Edge[]{ new Edge(v5, 133.04) };
	v5.adjacencies = new Edge[]{ new Edge(v0,  81.77),
	                             new Edge(v3,  62.05),
	                             new Edge(v4, 134.47),
	                             new Edge(v6,  91.63) };
	v6.adjacencies = new Edge[]{ new Edge(v3,  97.24),
	                             new Edge(v5,  87.94) };
	Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6 };
7
        computePaths(v3);
        for (Vertex v : vertices)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Vertex> path = getShortestPathTo(v);
	    System.out.println("Path: " + path);
	}
    }
}
  */
   
    private static int totalnodes;
    public static int src;
	public static int dest;
    private static String filename, input;
    private static String[] inputArray;
    private static BufferedReader in,fr;
    public static double cost;
    private static long start, end;
    private static int[] node;
    private static int nodeArrayCounter;
  
    private static String line;
	
	
	public static void main(String args[]) throws IOException{
    	System.out.println("linkstate filename node1 node2");
    	System.out.print("Input > ");
    	in=new BufferedReader(new InputStreamReader(System.in));
    	input=in.readLine();
    	inputArray=input.split(" ");   	
    	filename=inputArray[1];
    	node=new int[inputArray.length-2];
    	nodeArrayCounter=inputArray.length-2;
    	for(int i=0;i<(inputArray.length-2);i++){
    		node[i]=Integer.parseInt(inputArray[i+2]);
    	}
       
//for(int q=1; q<=10;q++){    // Start of For Loop to compute Task1
for(int q=0;q<node.length;q++){
    	fr=new BufferedReader(new FileReader(filename));
    	totalnodes=Integer.parseInt(fr.readLine());
    	System.out.println("****************************************************");
   // 	System.out.println("Total nodes : "+totalnodes);    	
    	Vertex[] v=new Vertex[totalnodes+1];
    	for(int i=1;i<=totalnodes;i++){
    	v[i]=new Vertex("node"+i);
    	v[i].adjacencies=new ArrayList<Edge>();
    //	System.out.println("i: "+i);
    //	System.out.println("Current name: "+v[i].getName());
    	}
	
    //	 System.out.println("nextline :"+fr.readLine());  	      	
    	while((line=fr.readLine())!=null){
    		
    		String[] lineArray=line.split(" ");
    		src=Integer.parseInt(lineArray[0]);
    //		System.out.println(src);
    		dest=Integer.parseInt(lineArray[1]);
    //		System.out.println(dest);
    		cost=Double.parseDouble(lineArray[2]);
    //		System.out.println(cost);
    //		System.out.println(v[src].getName());
    //		System.out.println(v[dest].getName());
    		v[src].adjacencies.add(new Edge(v[dest], cost));
    		v[dest].adjacencies.add(new Edge(v[src], cost));
    		
    	}
   
    	
    	
    		start=System.currentTimeMillis();

//    		computePaths(v[q]);   // Change made to compute Task1
    	    computePaths(v[node[q]]);   // Change made to compute Task1
      	  
    	    
    	    for(int shpath=1; shpath<=totalnodes; shpath++){
    	    	if((nodeArrayCounter>1)&&(shpath==node[q+1])){  
    	    	System.out.println();
        		System.out.println("Shortest path from "+ v[node[q]] + " to " + v[shpath] + ": " + v[shpath].minDistance);        		
        		List<Vertex> destpath = getShortestPathTo(v[shpath]);
        		System.out.println("Shortest path for the above shortest cost: " + destpath);
        		System.out.println();
    	        }
    	    }
    	    
//    	    System.out.println("Routing Table of node"+q);  // Change made to compute Task1
    		System.out.println();
    	    System.out.println("<----Routing Table of node"+node[q]+"---->"); 
    	    System.out.println();
    	       	    
            for(int i=1; i<=totalnodes; i++){
    		System.out.println("Distance to " + v[i] + ": " + v[i].minDistance);
    		List<Vertex> path = getShortestPathTo(v[i]);
    		System.out.println("Path: " + path);

    		end=System.currentTimeMillis();
    //		System.out.println("Time to compute the shortest path :"+(end-start)+" milliseconds");
    		System.out.println();
    		
   		    }

            System.out.println("Time to compute the shortest path :"+(end-start)+" milliseconds");
//}   // End of For Loop to compute Task1 
            nodeArrayCounter=nodeArrayCounter-1;
}  // End of for loop for multiple node computation
System.out.println("****************************************************");
	}
}

