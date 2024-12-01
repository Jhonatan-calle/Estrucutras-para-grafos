package src.test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.DirectedEdge;
import src.BellmanFord;
import src.EdgeWeightedIntGraph;

public class BellmanFordTest {
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
        // Creamos una instancia del algoritmo de bellmanFord
        BellmanFord bellmanFord = new BellmanFord(graph, 0);

        // Validamos las distancias desde el nodo inicial (0) a otros nodos
        assertEquals(0.0, bellmanFord.distTo(0), 0.001); // Distancia a sí mismo
        assertEquals(1.0, bellmanFord.distTo(1), 0.001); // Nodo 0 -> Nodo 1
        assertEquals(3.0, bellmanFord.distTo(2), 0.001); // Nodo 0 -> Nodo 2 (vía 1)
        assertEquals(6.0, bellmanFord.distTo(3), 0.001); // Nodo 0 -> Nodo 3 (vía 2)
        assertEquals(7.0, bellmanFord.distTo(4), 0.001); // Nodo 0 -> Nodo 4 (vía 3)
        assertEquals(12.0, bellmanFord.distTo(5), 0.001); // Nodo 0 -> Nodo 5 (vía 4)
    }

    @Test
    public void testEdgeToPaths() {
        // Creamos una instancia del algoritmo de bellmanFord
        BellmanFord bellmanFord = new BellmanFord(graph, 0);

        // Verificamos el camino mínimo hacia cada nodo
        List<DirectedEdge<Integer>> pathTo3 = bellmanFord.pathTo(3); // Camino al nodo 3
        assertEquals(3, pathTo3.size()); // Debe contener 3 aristas (0 -> 1 -> 2 -> 3)

        // Verificamos aristas específicas del camino
        assertEquals(0, pathTo3.get(0).from); // Primera arista desde 0
        assertEquals(1, pathTo3.get(0).to);   // Primera arista hacia 1

        assertEquals(1, pathTo3.get(1).from); // Segunda arista desde 1
        assertEquals(2, pathTo3.get(1).to);   // Segunda arista hacia 2

        assertEquals(2, pathTo3.get(2).from); // Tercera arista desde 2
        assertEquals(3, pathTo3.get(2).to);   // Tercera arista hacia 3
    }

    @Test
    public void testciclos() {

        // Creamos una instancia del algoritmo de bellmanFord
        BellmanFord bellmanFord = new BellmanFord(graph, 0);

        assertFalse(bellmanFord.hasNegativeCicles());

        //añadimos una arista con pero negativo
        graph.addEdge(new DirectedEdge<Integer>(2, 5, -2)); // 0 -> 1 (peso -2.0)
        graph.addEdge(new DirectedEdge<Integer>(5, 2, 1));

        // Creamos una nueva instancia del algoritmo de bellmanFord
        bellmanFord = new BellmanFord(graph, 0);

        assertTrue(bellmanFord.hasNegativeCicles());

        
    }
}
