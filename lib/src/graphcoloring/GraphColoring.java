package graphcoloring;

import java.util.*;

/**
 * Class to implement the DSATUR graph coloring algorithm.
 */
public class GraphColoring {
    private Graph graph;

    /**
     * Constructor for the GraphColoring class
     * 
     * @param graph the Graph to which the coloring algorithm will be applied.
     */
    public GraphColoring(Graph graph) {
        this.graph = graph;
    }

    /**
     * Method to color the graph using the DSATUR algorithm.
     */
    public void colorGraph() {
        int vertices = graph.getVertices();
        int[] result = new int[vertices]; // Array to store the colors of the vertices
        Arrays.fill(result, -1); // Initialize all positions with -1 (uncolored)
        
        int[] saturationDegree = new int[vertices]; // Array to track saturation degree
        int[] degree = new int[vertices]; // Array to store the degree of each vertex
        
        // Compute initial degrees
        for (int v = 0; v < vertices; v++) {
            degree[v] = graph.getAdjacencyList(v).size();
        }

        // Priority queue to select vertex based on DSATUR criteria
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> {
            if (saturationDegree[v1] != saturationDegree[v2]) {
                return Integer.compare(saturationDegree[v2], saturationDegree[v1]); // Higher saturation degree first
            }
            if (degree[v1] != degree[v2]) {
                return Integer.compare(degree[v2], degree[v1]); // Higher degree as a tiebreaker
            }
            return Integer.compare(v1, v2); // Lexicographical order as final tiebreaker
        });

        // Insert all vertices into the priority queue
        for (int v = 0; v < vertices; v++) {
            pq.add(v);
        }

        while (!pq.isEmpty()) {
            int u = pq.poll(); // Select vertex with highest saturation degree

            // Find the smallest available color
            boolean[] available = new boolean[vertices];
            Arrays.fill(available, true);

            for (int adj : graph.getAdjacencyList(u)) {
                if (result[adj] != -1) {
                    available[result[adj]] = false;
                }
            }

            int cr;
            for (cr = 0; cr < vertices; cr++) {
                if (available[cr]) break;
            }

            result[u] = cr; // Assign the found color

            // Update saturation degree of adjacent vertices
            for (int adj : graph.getAdjacencyList(u)) {
                if (result[adj] == -1) {
                    Set<Integer> neighborColors = new HashSet<>();
                    for (int neighbor : graph.getAdjacencyList(adj)) {
                        if (result[neighbor] != -1) {
                            neighborColors.add(result[neighbor]);
                        }
                    }
                    saturationDegree[adj] = neighborColors.size();
                    pq.remove(adj);
                    pq.add(adj);
                }
            }
        }

        System.out.println("\nGraph Coloring Results:");
        String[] colorCodes = {"\u001B[31m", "\u001B[32m", "\u001B[34m", "\u001B[33m", "\u001B[35m", "\u001B[36m"};
        for (int u = 0; u < vertices; u++) {
            String color = colorCodes[result[u] % colorCodes.length];
            System.out.println("Vertex " + u + " ---> " + color + "Color " + result[u] + "\u001B[0m");
        }

        int numColors = Arrays.stream(result).max().orElse(-1) + 1;
        System.out.println("\nTotal number of colors used: " + numColors);
    }
}
