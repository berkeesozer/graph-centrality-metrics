import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException  {
		
		//KARATE CLUB NETWORK
		
		Graph karate = new Graph(34,78);
		for (int i = 1; i <= karate.getSize(); i++) 
		{
			String nodeNumber = String.valueOf(i);
			Node node = new Node(nodeNumber);
			karate.addNode(node);
		}
		File graph1 = new File("karate_club_network.txt");
	    Scanner sc = new Scanner(graph1);
	    
	    do {
	    	int sourceIndex = sc.nextInt();
	    	int destinationIndex = sc.nextInt();
	    	Node sourceNode = karate.getNodes().get(sourceIndex);
	    	Node destNode = karate.getNodes().get(destinationIndex);
	    	sourceNode.addNeighbour(destNode);	   	         	
		} while (sc.hasNext());
	   
	    
	    
	       //calculating shortest paths for each possible pair of nodes (34*33 nodes)
	    
		   for (int i = 1; i <= karate.getSize(); i++) 
		   {
				int index1 = Integer.valueOf(karate.getNodes().get(i).getName());
				for(int j = i+1 ; j< karate.getSize(); j++)
				{		   					  	
			   		int index2 = Integer.valueOf(karate.getNodes().get(j).getName());		   
 			   		karate.getShortestPath(karate.getNodes().get(index1), karate.getNodes().get(index2));		   		
				}
			   
		   }
		   // printing highest betweenness for karate
		   
		   int highestbNess = 0;
		   String highestbNessNode = "";
		   for(Node n : karate.getNodes().subList(1, karate.getSize()))
		   {
			   if (n.getbNess()>highestbNess) 
			   {
				   highestbNess = n.getbNess();
				   highestbNessNode = n.getName();	   
			   }	   
		   }
		   System.out.println("2020510065 Berke Sozer");
		   System.out.println("Zachary Karate Club Network #" + highestbNessNode + " Betweennes: " + highestbNess);
		   
		   
		   // printing highest closeness for karate (1/x form)
		   double highestcNess = 0;
		   String highestcNessNode = "";
		   for(Node n : karate.getNodes().subList(1, karate.getSize())) // printing highest closeness
		   {
			   if (n.getcNess()>highestcNess) 
			   {
				   highestcNess = n.getcNess();
				   highestcNessNode = n.getName();	   
			   }	   
		   }
		   System.out.println("Zachary Karate Club Network #" + highestcNessNode + " Closeness: " + 1/highestcNess);
		   
		   //FACEBOOK SOCIAL NETWORK
		   //(same things as karate part)
		   
		   Graph facebook = new Graph(1518,32998);
			for (int i = 1; i <= facebook.getSize(); i++) 
			{
				String nodeNumber = String.valueOf(i);
				Node node = new Node(nodeNumber);
				facebook.addNode(node);
			}
			File graph2 = new File("facebook_social_network.txt");
		    Scanner sc2 = new Scanner(graph2);
		    
		    do {
		    	int sourceIndex = sc2.nextInt();
		    	int destinationIndex = sc2.nextInt();
		    	Node sourceNode = facebook.getNodes().get(sourceIndex);
		    	Node destNode = facebook.getNodes().get(destinationIndex);
		    	sourceNode.addNeighbour(destNode);	    		  		    		    	
			} while (sc2.hasNext());
		    
		    System.out.println("Calculating Facebook Social Network paths... (30 seconds)");
		    for (int i = 1; i <= facebook.getSize(); i++) 
			   {				  
		    		int index1 = Integer.valueOf(facebook.getNodes().get(i).getName());		    	
		    		for(int j = i+1 ; j< facebook.getSize(); j++)
					{			    			
				   		int index2 = Integer.valueOf(facebook.getNodes().get(j).getName());						   		
	 			   		facebook.getShortestPath(facebook.getNodes().get(index1), facebook.getNodes().get(index2));		   		
					}	   
			   }
		    
		    	// printing highest betweennes for karate
			   int highestbNessFB = 0;
			   String highestbNessNodeFB = "";
			   for(Node n : facebook.getNodes().subList(1, facebook.getSize()))
			   {
				   if (n.getbNess()>highestbNessFB) 
				   {
					   highestbNessFB = n.getbNess();
					   highestbNessNodeFB = n.getName();	   
				   }	   
			   }
			   System.out.println("Facebook Social Network #" + highestbNessNodeFB + " Betweennes: " + highestbNessFB);
			   
			   // printing highest closeness for facebook (1/x form)
			   double highestcNessFB = 0;
			   String highestcNessNodeFB = "";
			   for(Node n : facebook.getNodes().subList(1, facebook.getSize())) 
			   {
				   if (n.getcNess()>highestcNessFB) 
				   {
					   highestcNessFB = n.getcNess();
					   highestcNessNodeFB = n.getName();	   
				   }	   
			   }
			   System.out.println("Facebook Social Network #" + highestcNessNodeFB + " Closeness: " + String.format("%.7f", 1/highestcNessFB));
	
		   
		   
			   

	 
	 


	   
	    
	 
	   


	}

}
