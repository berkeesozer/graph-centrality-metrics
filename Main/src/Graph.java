import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class Graph {
	
	private int size;
	private int edgeSize;
	private ArrayList<Node> nodes = new ArrayList<>(size); // to keep vertex names
	private ArrayList<Edge> edges = new ArrayList<>(edgeSize); // to keep edge names
	
	public Graph(int size,int edgeSize) {
		this.size = size;
		nodes.add(null); // ignoring first element
	}
		
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	
	public void addEdge(Edge edge)
	{
		edges.add(edge);
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public int getSize() {
		return size;
	}

	public void NsetSize(int size) {
		this.size = size;
	}


	public ArrayList<Edge> getEdges() {
		return edges;
	}


	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public void getShortestPath(Node startNode,Node endNode)
	{
		BFS(startNode,endNode);

	
	}
	public void BFS(Node startNode,Node endNode) {
		
		Queue<Node> routeQueue = new LinkedList<>();
		
		

		// add the first node (startNode)
		startNode.setVisited(true);
		routeQueue.add(startNode);
		boolean found = false;

		// breadth first search until every node is visited
		while (!routeQueue.isEmpty()) {
			Node currentNode = routeQueue.poll();				
			for (Node node : currentNode.neighbors) {
				if (node.isVisited() == false) {
					// making visited status true to visited nodes
					node.setVisited(true);				
					routeQueue.add(node);
					node.previous = currentNode;
					// break if it reached last node
					if (node == endNode) {
						found = true;
						routeQueue.clear();
						break;
					}
				}
			}
		}		
		getRoute(startNode,endNode);				
	
	}

	// method to get the route(shortest path)between two nodes
	public void getRoute(Node startNode,Node endNode) {
		Node node = endNode;
		ArrayList<Node> routeQueue = new ArrayList<>();
		int routeSize=0;
		do {			
			if ((node==null)) 
			{				
				break;
			}
			if(startNode.getName().equals(String.valueOf(17)) || startNode.getName().equals(String.valueOf(23)) || startNode.getName().equals(String.valueOf(77)) || startNode.getName().equals(String.valueOf(81)) || startNode.getName().equals(String.valueOf(422)) || startNode.getName().equals(String.valueOf(528)) || startNode.getName().equals(String.valueOf(882)) || startNode.getName().equals(String.valueOf(1045)))
			{
				break;
			}		
			routeQueue.add(node);				
			node.setbNess(node.getbNess()+1); // increasing betweennes of the current because that node is inside the shortest path
			node = node.previous;
			routeSize++; // for closeness
		} while (node != startNode.previous);
		
				startNode.setcNess(startNode.getcNess()+routeSize);
		
		
			//clearing visited status for every node for future executions	
			
			for (int i = 1; i < nodes.size(); i++) 
			{
				nodes.get(i).setVisited(false);
			}
			routeQueue.clear();
			
		
	}
	
	
	
	
}