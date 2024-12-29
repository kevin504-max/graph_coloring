package graphcoloring;

import java.util.Scanner;

/**
 * Main class for testing the graph coloring implementation.
 * This program allows the user to input a graph and see the results of greedy coloring algorithm.
 */
public class Main {
    /**
     * The main method server as the entry point for the program.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph:");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (pair of vertices u v) in the graph:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("Graph coloring using greedy algorithm:");
        GraphColoring greedyColoring = new GraphColoring(graph);
        greedyColoring.colorGraph();

        scanner.close();
    }
}