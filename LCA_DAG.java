import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LCA_DAG {

	private int V;
	private int E;
	private ArrayList<Integer>[] adj;
	private int[] indegree;
	public boolean[] isMarked;
	public boolean[] isStack;
	public boolean checkDAG; 

	//constructor for a DAG
	public LCA_DAG(int V) { 
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph can't be negative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();

		}
		checkDAG = true;
		isMarked = new boolean[V];
		isStack = new boolean[V];
	}

	//get vertex value
	public int V() {
		return V;
	}

	//get edge value
	public int E() {
		return E;
	}

	//add an edge to the DAG
	public void addEdge(int v, int w) {
		validateV(v);
		validateV(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}
	
	//ensure a valid vertex is found, if not, throw an exception
	private void validateV(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is outside the range of 0 and " + (V - 1));

	}

	public Iterable<Integer> adj(int v) {
		validateV(v);
		return adj[v];
	}

	//check if DAG has a cycle in it 
	public void isAcyclic() {
		for (int i = 0; i < V() && checkDAG; i++) {
			isStack = new boolean[V];
			isMarked = new boolean[V];
			acyclic(i);
		}
	}

	private void acyclic(int v) {
		isStack[v] = true;
		isMarked[v] = true;

		for (int w : adj(v)) {
			if (!isMarked[w]) {
				acyclic(w);
			} else if (isStack[w]) {
				checkDAG = false;
				return;
			}
		}
		isStack[v] = false;
	}

	public LCA_DAG reverse() {
		LCA_DAG reverse = new LCA_DAG(V);
		for (int v = 0; v < V; v++) {

			for (int w : adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}

	//function to find LCA of a DAG
	public int LCA(int v, int w) {

		if (!checkDAG || E == 0) {
			return -1;
		}
		boolean hasCommonAncestor = false;
		validateV(v); 
		validateV(w);

		LCA_DAG reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		ArrayList<Integer> s1 = reversed.BFS(v);
		ArrayList<Integer> s2 = reversed.BFS(w);

		for (int i = 0; i < s1.size(); i++) {
			for (int t = 0; t < s2.size(); t++) {
				if (s1.get(i) == s2.get(t)) {
					commonAncestors.add(s1.get(i));
					hasCommonAncestor = true;
				}
			}
		}

		if (hasCommonAncestor) {
			return commonAncestors.get(0);
		} else {
			return -1;
		}
	}

	private ArrayList<Integer> BFS(int s) {
		boolean isVisited[] = new boolean[V];
		LinkedList<Integer> myQueue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		isVisited[s] = true;
		myQueue.add(s);

		while (myQueue.size() != 0) {
			s = myQueue.poll();
			result.add(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!isVisited[n]) { 
					isVisited[n] = true;
					myQueue.add(n);
				}
			}
		}

		return result;
	}

}
