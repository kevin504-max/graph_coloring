package graphcoloring;

import java.util.Arrays;

/**
 * Class to implement the graph coloring algorithm.
 * This class uses a greedy approach to assign colors to graph vertices.
 */
public class GraphColoring {
    private Graph graph;

    /**
     * Constructor for the GraphColoring class
     * 
     * @param graph the Graph to which the coloring algorithm will be applied.
     */
    public GraphColoring (Graph graph) {
        this.graph = graph;
    }

    /**
     * Method to color the graph using a greedy algorithm
     * Each vertex is assigned the smallest available color that has not been assigned to its neighbors. 
     */
    public void colorGraph () {
        int vertices = graph.getVertices();
        int[] result = new int[vertices];
        Arrays.fill(result, -1);
    
        boolean[] available = new boolean[vertices];
        
        result[0] = 0;
    
        for (int u = 1; u < vertices; u++) {
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
    
            result[u] = cr;
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