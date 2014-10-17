
/**
 * Created by Simon on 2014-10-16.
 */
public class MinDFS {
    public int[] minDFS(Digraph G) {
        int[] min = new int[G.V()];                         // Array to store min value for each node
        boolean[] visited = new boolean[G.V()];             // Array to store visited info
        for (int i = 0; i < G.V(); i++) {                   // For every non-visited node, call recursive method
            if (!visited[i]) {
                minRecursive(G, visited, min, i);
            }
        }
        return min;
    }

    public int minRecursive(Digraph G, boolean[] visited, int[] min, int s) {
        visited[s] = true;
        if (G.bag[s].isEmpty()) {                           // An empty bag implies no adjacent edges
            min[s] = s;                                     // If bag is empty, node can only visit itself. ONLY CASE THIS IS ALLOWED
            return s;
        }
        for (int i : G.bag[s]) {                            // For every non-visited adjacent node, call recursive method
            if (!visited[i]) {
                min[i] = minRecursive(G, visited, min, i);
            }
            if (i < min[i]) {                               // If node we are visiting is smaller than it's own min value
                min[s] = i;                                 // Set parent node min value to the child node
            }
            else {                                          // If the node we are visiting is greater than it's own min value
                min[s] = min[i];                            // Set parent node min value to the child nodes min value
            }
        }
        return min[s];
    }
}
