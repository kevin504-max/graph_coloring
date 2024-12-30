package graphcoloring;

import java.util.Scanner;

/**
 * Main class for testing the graph coloring implementation.
 * This program allows the user to input a graph and see the results of greedy coloring algorithm.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[36mEnter the number of vertices in the graph:\u001B[0m");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        System.out.println("\u001B[36mEnter the number of edges in the graph:\u001B[0m");
        int edges = scanner.nextInt();

        System.out.println("\u001B[36mEnter the edges (pair of vertices u v) in the graph:\u001B[0m");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }
 
        System.out.println("\n\u001B[32mGraph coloring using greedy algorithm:\u001B[0m");
        GraphColoring greedyColoring = new GraphColoring(graph);
        greedyColoring.colorGraph();

        scanner.close();
    }
}
