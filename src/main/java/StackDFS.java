import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Simon Carlson on 2014-10-14.
 */
public class StackDFS {
    public LinkedList<Integer> stackDFS(Digraph G, int source) {
        if (G.bag.length < source) {                        // If length of bag is lesser than source, source can't exist
            return null;
        }
        boolean[] visited = new boolean[G.V()];      // Create boolean array to flag visited vertices
        Stack<Integer> stack = new Stack<Integer>();        // Create new stack
        stack.push(source);                                 // Push initial vertex
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {                              // If the popped value isn't visited..
                visited[v] = true;                          // Flag it as visited
                for (int i : G.bag[v]) {                    // Then push every adjacent vertex
                    stack.push(i);
                }
            }
        }
        LinkedList<Integer> results = new LinkedList<Integer>();    // Create LinkedList to summarize results
        visited[source] = false;                            // Every vertex can visit itself, redundant
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {                               // For every visited vertex
                results.add(i);                             // Add that index (vertex) to the list
            }
        }
        return results;
    }
}
