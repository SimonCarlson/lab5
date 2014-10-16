import edu.princeton.cs.algs4.Bag;
import java.util.LinkedList;

/**
 * Created by Simon Carlson on 2014-10-14.
 */
public class RecursiveDFS {
    public LinkedList<Integer> recursiveDFS(Digraph G, int source) {
        if (G.bag.length < source) {                        // If bag's length is lesser than source, source can't exist
            return null;
        }

        boolean[] visited = new boolean[G.V()];      // Create empty boolean array that will flag which vertices we visited
        recursiveDFS(G.bag, visited, source);               // recursiveDFS changes the values of visited
        visited[source] = false;                            // Every node can visit itself, irrelevant info
        LinkedList<Integer> results = new LinkedList<Integer>();    // A LinkedList can add new elements at low cost

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {                               // Check if i-th spot in visited is true
                results.add(i);                             // If it's true, add that index (vertex) to results
            }
        }
        return results;
    }

    public boolean[] recursiveDFS(Bag<Integer>[] bag, boolean[] visited, int s) {
        visited[s] = true;                                  // Set vertex to visited so we don't count it twice
        for (int i : bag[s]) {                              // Iterate over bag
            if (!visited[i]) {
                recursiveDFS(bag, visited, i);              // Recursive call to dig deeper in graph
            }
        }
        return visited;
    }


}
