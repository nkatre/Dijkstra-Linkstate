package graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 * 
 * @author nikhil pankil
 * 
 */

public class TestDijkstra {


    
	private static GraphNode[] node;
	private static int totalnodes;
    private static BufferedReader br;
        /**
        * 
        * @param args
        */
        public static void main (String [] args){
  	
        	try {
				BufferedReader br= new BufferedReader(new FileReader("small-net.txt"));		
				totalnodes=Integer.parseInt(br.readLine());
				System.out.println("Total number of nodes in the topology are: "+totalnodes);
				
	
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
     
        	
        	
        	
        	for(int i=1; i<=totalnodes;i++){
        		System.out.println();
        		initialize();
			    Graph myGraph = new Graph(node[i]);
			    System.out.println("**** Shortest path to all nodes from: "+node[i].getVal()+" ****");
                Dijkstra dAlg = new Dijkstra(myGraph);
                dAlg.go();
          //      dAlg.PrintStatusOfPriorityQ();
                
           //     p("done");
                myGraph.print();
          //      myGraph.emptyVisitedNodes();
              //  initialize();
                
        	}
        	}
            private static void p(String s){
                System.out.println(s);
            }
            private static void initialize(){
            	try {
            		BufferedReader br= new BufferedReader(new FileReader("small-net.txt"));
            		totalnodes=Integer.parseInt(br.readLine());
    				node=new GraphNode[totalnodes+1];    // node is of the type GraphNode[]
    	        	for(int i=1;i<=totalnodes;i++)
    	        	{
    	        	node[i] = new GraphNode("Node"+i);
    	        	//System.out.println("Node"+i);
    	        	}
    	        	
                    String temp;               
    				while((temp=br.readLine())!=null)
    				{	
    				String[] tempArray=temp.split(" ");				
    				int firstNode=Integer.parseInt(tempArray[0]);
    				int secondNode=Integer.parseInt(tempArray[1]);
    				double distance=Double.parseDouble(tempArray[2]);
    			//	System.out.println(firstNode+" "+secondNode+" "+distance);
    				node[firstNode].AddOutgoingEdge(node[secondNode], distance);
    				node[secondNode].AddOutgoingEdge(node[firstNode], distance);
    				temp=br.readLine();				 
    				}
    				br.close();
    				
    			} catch (NumberFormatException | IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
            
        
}         
      
        
        

 