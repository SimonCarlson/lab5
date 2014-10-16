import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.introcs.In;

/**
 * Created by Simon Carlson on 2014-10-13.
 */
public class Digraph {
    private final int V;                                    // Number of vertices
    private int E;                                          // Number of edges
    protected Bag<Integer>[] adj;                           // bag array of adjacency lists

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];                  // Create list array
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();                    // Initialize lists to empty
        }
    }

    public Digraph(In in) {
        this(in.readInt());                                 // Read first int to set amount of vertices
        int E = in.readInt();                               // Read second int to set amount of edges
        for (int i = 0; i < E; i++) {
            int v = in.readInt();                           // Read first vertex
            int w = in.readInt();                           // Read second vertex
            addEdge(v, w);                                  // Add path v -> w
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);                                      // Add path v -> w
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
