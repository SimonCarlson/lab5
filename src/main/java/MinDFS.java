
/**
 * Created by Simon on 2014-10-16.
 */
public class MinDFS {
    public int[] minDFS(Digraph G) {
        int[] min = new int[G.V()];
        boolean[] visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                minRecursive(G, visited, min, i);
            }
        }
        return min;
    }

    public int minRecursive(Digraph G, boolean[] visited, int[] min, int s) {
        if (!visited[s]) {
            if (G.bag[s].isEmpty()) {
                min[s] = s;
                visited[s] = true;
                return s;
            }
            else {
                visited[s] = true;
                for (int i : G.bag[s]) {
                    if (!visited[i]) {
                        min[s] = minRecursive(G, visited, min, i);
                    }
                }
            }
        }
        return min[s];
    }
}
