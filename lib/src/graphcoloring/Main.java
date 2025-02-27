package graphcoloring;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices in the graph:");
        int vertices = scanner.nextInt();
        
        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();
        
        // Validate if the number of edges is within the valid range
        if (edges > (vertices * (vertices - 1)) / 2) {
            System.out.println("Error: Too many edges for the given number of vertices.");
            scanner.close();
            return;
        }
        
        Random random = new Random();
        boolean[][] adjacencyMatrix = new boolean[vertices][vertices];
        Graph graph = new Graph(vertices);
        
        try (FileWriter writer = new FileWriter("graph_instance.txt")) {
            // Write number of vertices and edges to file
            writer.write(vertices + "\n");
            writer.write(edges + "\n");
            
            int count = 0;
            while (count < edges) {
                int u = random.nextInt(vertices);
                int v = random.nextInt(vertices);
                
                // Ensure no self-loops and no duplicate edges
                if (u != v && !adjacencyMatrix[u][v]) {
                    adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = true;
                    writer.write(u + " " + v + "\n");
                    graph.addEdge(u, v);
                    count++;
                }
            }
            
            System.out.println("Graph instance successfully generated in 'graph_instance.txt'.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Perform graph coloring using greedy algorithm
        System.out.println("\n\u001B[32mGraph coloring using greedy algorithm:\u001B[0m");
        GraphColoring greedyColoring = new GraphColoring(graph);
        greedyColoring.colorGraph();
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
