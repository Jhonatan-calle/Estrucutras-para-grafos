package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.DirectedEdge;

//las dos implementaciones para testear
import src.GenericListEdgeWeightedGraph;
import src.GenericMatrixEdgeWeightedGraph;


import src.interfaz.EdgeWeightedGraph;

import java.util.List;

public class EdgeWeightedGraphTest {

    private EdgeWeightedGraph<Integer> graph;

    @BeforeEach
    public void setUp() {
        graph = new GenericMatrixEdgeWeightedGraph<Integer>(5);
    }

    @Test
    public void testAddVertex() {
        graph.addVertex(1);
        graph.addVertex(2);

        assertTrue(graph.containsVertex(1), "El grafo debería contener el vértice 1.");
        assertTrue(graph.containsVertex(2), "El grafo debería contener el vértice 2.");
        assertFalse(graph.containsVertex(3), "El grafo no debería contener el vértice 3.");
    }

    @Test
    public void testAddEdge() {
        graph.addVertex(1);
        graph.addVertex(2);
        DirectedEdge<Integer> edge = new DirectedEdge<>(1, 2, 1.5);

        graph.addEdge(edge);

        List<DirectedEdge<Integer>> adj = graph.adj(1);
        DirectedEdge<Integer> result = adj.get(0);

        assertEquals(1, adj.size(), "El vértice 1 debería tener 1 arista saliente.");
        assertEquals(edge, result, "La arista añadida debería coincidir con la esperada.");
    }

    @Test
    public void testAdjacency() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(new DirectedEdge<>(1, 2, 2.0));
        graph.addEdge(new DirectedEdge<>(1, 3, 3.0));

        List<DirectedEdge<Integer>> adj = graph.adj(1);

        assertEquals(2, adj.size(), "El vértice 1 debería tener 2 aristas salientes.");
        assertEquals(2, adj.get(0).to, "El primer nodo adyacente debería ser el 2.");
        assertEquals(3, adj.get(1).to, "El segundo nodo adyacente debería ser el 3.");
    }

    @Test
    public void testInvalidAdj() {
        graph.addVertex(1);

        assertThrows(IllegalArgumentException.class, () -> graph.adj(2),
                "Debería lanzar una excepción para un vértice no existente.");
    }

    @Test
    public void testVertexCount() {
        graph.addVertex(1);
        graph.addVertex(2);

        assertEquals(2, graph.V(), "El número de vértices debería ser 2.");
    }

    @Test
    public void testEdgeCount() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(new DirectedEdge<>(1, 2, 1.0));
        graph.addEdge(new DirectedEdge<>(2, 3, 2.0));

        assertEquals(2, graph.E(), "El número de aristas debería ser 2.");
    }
}
