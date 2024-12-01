package src.test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.DirectedEdge;
import src.FloydWarshall;
import src.EdgeWeightedIntGraph;

public class FloydWarshallTest {
    private EdgeWeightedIntGraph graph;

    @BeforeEach
    public void setUp() {
        // Inicializamos un grafo ponderado de ejemplo
        graph = new EdgeWeightedIntGraph(6);
        
        // Añadimos las aristas al grafo (peso entre nodos)
        graph.addEdge(new DirectedEdge<Integer>(0, 1, 1.0)); // 0 -> 1 (peso 1.0)
        graph.addEdge(new DirectedEdge<Integer>(0, 2, 4.0)); // 0 -> 2 (peso 4.0)
        graph.addEdge(new DirectedEdge<Integer>(1, 2, 2.0)); // 1 -> 2 (peso 2.0)
        graph.addEdge(new DirectedEdge<Integer>(1, 3, 6.0)); // 1 -> 3 (peso 6.0)
        graph.addEdge(new DirectedEdge<Integer>(2, 3, 3.0)); // 2 -> 3 (peso 3.0)
        graph.addEdge(new DirectedEdge<Integer>(3, 4, 1.0)); // 3 -> 4 (peso 1.0)
        graph.addEdge(new DirectedEdge<Integer>(4, 5, 5.0)); // 4 -> 5 (peso 5.0)
    }

    @Test
    public void testShortestPathsFromStartNode() {
        // Creamos una instancia del algoritmo de floydWarshall
        FloydWarshall floydWarshall = new FloydWarshall(graph);

        // Validamos las distancias desde el nodo inicial (0) a otros nodos
        assertEquals(0.0, floydWarshall.distTo(0,0), 0.001); // Distancia a sí mismo
        assertEquals(1.0, floydWarshall.distTo(0,1), 0.001); // Nodo 0 -> Nodo 1
        assertEquals(3.0, floydWarshall.distTo(0,2), 0.001); // Nodo 0 -> Nodo 2 (vía 1)
        assertEquals(6.0, floydWarshall.distTo(0,3), 0.001); // Nodo 0 -> Nodo 3 (vía 2)
        assertEquals(7.0, floydWarshall.distTo(0,4), 0.001); // Nodo 0 -> Nodo 4 (vía 3)
        assertEquals(12.0, floydWarshall.distTo(0,5), 0.001); // Nodo 0 -> Nodo 5 (vía 4)
    }

    @Test
    public void testEdgeToPaths() {
        // Creamos una instancia del algoritmo de floydWarshall
        FloydWarshall floydWarshall = new FloydWarshall(graph);

        // Verificamos el camino mínimo hacia cada nodo
        List<Integer> pathTo3 = floydWarshall.pathTo(0,3); //(0 -> 1 -> 2 -> 3)
        assertEquals(4, pathTo3.size()); 

        assertEquals(0, pathTo3.get(0));
        assertEquals(1, pathTo3.get(1));  
        assertEquals(3, pathTo3.get(3)); 
    }
}
