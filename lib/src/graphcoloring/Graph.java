package graphcoloring;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a graph using an adjacency list.
 * It allows the creation of an undirected graph where edges connect pairs of vertices.
 */
public class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    /**
     * Constructor for the Graph class
     * Initializes the graph with a specified number of vertices and empty adjacency list.
     * 
     * @param vertices Number of vertices in the graph 
     */
    public Graph (int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an undirected edge between two vertices in the graph.
     * 
     * @param u Source vertex
     * @param v Destination Vertex
     */
    public void addEdge (int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    /**
     * Returns the number of vertices in the graph
     * 
     * @return Number of vertices.
     */
    public int getVertices () {
        return vertices;
    }

    /**
     * Returns the adjacency list of a specific vertex.
     * 
     * @param vertex The vertex to whose adjacency list will be returned.
     * @return List of vertices adjacent to the specified vertex.
     */
    public List<Integer> getAdjacencyList (int vertex) {
        return adjacencyList.get(vertex);
    }
}