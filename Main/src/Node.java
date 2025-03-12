import java.util.*;

public class Node {

	private String name;
	private int bNess; // betweennes value
	private int cNess; // closeness value
	private boolean visited = false;
	List<Node> neighbors;
	Node previous = null;

	Node(String name) {
		this.name = name;
		this.neighbors = new ArrayList<>();
	}

	
	void addNeighbour(Node node) {
		this.neighbors.add(node);
		node.neighbors.add(this);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getbNess() {
		return bNess;
	}

	public void setbNess(int bNess) {
		this.bNess = bNess;
	}

	public int getcNess() {
		return cNess;
	}

	public void setcNess(int cNess) {
		this.cNess = cNess;
	}


	public boolean isVisited() {
		return visited;
	}


	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
