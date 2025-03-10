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
        int vertices = graph.getVertices(); // Obtêm o número de vértices do grafo
        int[] result = new int[vertices]; // Array para armazenar as cores dos vértices
        Arrays.fill(result, -1); // Inicializa todas as posições do array com -1
    
        boolean[] available = new boolean[vertices]; // Array para armazenar as cores disponíveis e verificar qual está disponível em cada iteração
        
        result[0] = 0; // Atribui a cor 0 ao primeiro vértice
    
        // Itera sobre os vértices do grafo a partir do segundo vértice, pois o primeiro já foi colorido
        for (int u = 1; u < vertices; u++) { 
            Arrays.fill(available, true); // Inicializa o array de cores disponíveis com true
    
            // Verifica os vértices adjacentes ao vértice atual e marca as cores já utilizadas
            for (int adj : graph.getAdjacencyList(u)) {
                if (result[adj] != -1) { // Se o vértice adjacente já foi colorido, marca a cor como indisponível
                    available[result[adj]] = false; // Torna a cor como indisponível
                }
            }
    
            // Encontra a primeira cor disponível para o vértice atual
            int cr;
            for (cr = 0; cr < vertices; cr++) {
                if (available[cr]) break; // Se a cor estiver disponível, sai do loop
            }
    
            result[u] = cr; // Atribui a cor encontrada ao vértice atual
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