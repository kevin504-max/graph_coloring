package graphcoloring;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of instances to generate:");
        int numInstances = scanner.nextInt();

        System.out.println("Enter the minimum number of vertices:");
        int minVertices = scanner.nextInt();

        System.out.println("Enter the maximum number of vertices:");
        int maxVertices = scanner.nextInt();

        System.out.println("Enter the density percentage (1-100):");
        int density = scanner.nextInt();

        Random random = new Random();

        for (int i = 1; i <= numInstances; i++) {
            int vertices = random.nextInt(maxVertices - minVertices + 1) + minVertices;
            int maxEdges = (vertices * (vertices - 1)) / 2;
            int edges = (int) ((density / 100.0) * maxEdges);

            boolean[][] adjacencyMatrix = new boolean[vertices][vertices];
            Graph graph = new Graph(vertices);

            String filename = "graph_instance_" + i + ".txt";
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(vertices + "\n");
                writer.write(edges + "\n");

                int count = 0;
                while (count < edges) {
                    int u = random.nextInt(vertices);
                    int v = random.nextInt(vertices);

                    if (u != v && !adjacencyMatrix[u][v]) {
                        adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = true;
                        writer.write(u + " " + v + "\n");
                        graph.addEdge(u, v);
                        count++;
                    }
                }

                System.out.println("Graph instance saved in: " + filename);
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

            // Measure execution time
            long startTime = System.currentTimeMillis();
            GraphColoring greedyColoring = new GraphColoring(graph);
            greedyColoring.colorGraph();
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println("\u001B[34mExecution time for instance " + i + ": " + executionTime + " ms\u001B[0m");

            // Save execution time to file
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.write("Execution time: " + executionTime + " ms\n");
            } catch (IOException e) {
                System.out.println("Error writing execution time to file: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
