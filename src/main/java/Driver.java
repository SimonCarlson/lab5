import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.net.URL;

/**
 * Created by Simon Carlson on 2014-10-13.
 */
public class Driver {
    public static void main(String[] args) {
        URL url = Driver.class.getResource("graph.txt");
        In input = new In(url);

        Digraph digraph = new Digraph(input);               // Create a digraph instance
        RecursiveDFS recursive = new RecursiveDFS();        // Create a recursiveDFS instance
        StackDFS stack = new StackDFS();                    // Create a stackDFS instance
        MinDFS min = new MinDFS();                          // Create a minDFS instance

        StdOut.println("Using recursive call");
        Stopwatch recWatch = new Stopwatch();
        for (int i : recursive.recursiveDFS(digraph, 0)) {  // Iterates through the list given from recursiveDFS
            StdOut.print(i + " ");
        }
        StdOut.println("\nTime spent: \n" + recWatch.elapsedTime());

        StdOut.println("\nUsing stack");
        Stopwatch stackWatch = new Stopwatch();
        for (int i : stack.stackDFS(digraph, 0)) {          // Iterates through the list given from stackDFS
            StdOut.print(i + " ");
        }
        StdOut.println("\nTime spent: \n" + stackWatch.elapsedTime());

        StdOut.println("\nSmallest index for each node:");
        for (int i : min.minDFS(digraph)) {
            StdOut.println(i + " ");
        }
    }
}
