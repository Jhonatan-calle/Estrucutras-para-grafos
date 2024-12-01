package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import src.IntGraphListas;
import src.IntGraphMatriz;
import src.interfaz.IntGraph;

public class IntGraphTest {
    private IntGraph graph;

    @BeforeEach
    public void setUp() {
        graph = new IntGraphMatriz(5);
        //graph = new IntGraphListas(5);
    }

    @Test
    public void testNumberOfVertices() {
        assertEquals(5, graph.V(), "El número de vértices debería ser 5.");
    }

    @Test
    public void testNumberOfEdgesInitially() {
        assertEquals(0, graph.E(), "El número inicial de aristas debería ser 0.");
    }

    @Test
    public void testAddEdge() {
        graph.addEdge(0, 1);
        assertEquals(1, graph.E(), "El número de aristas debería ser 1 tras agregar una arista.");
    }

    @Test
    public void testAdjacencyList() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        List<Integer> adj = graph.adj(0);
        assertTrue(adj.contains(1), "El nodo 1 debería estar en la lista de adyacencia del nodo 0.");
        assertTrue(adj.contains(2), "El nodo 2 debería estar en la lista de adyacencia del nodo 0.");
        assertEquals(2, adj.size(), "La lista de adyacencia debería contener exactamente 2 nodos.");
    }

    @Test
    public void testAddEdgeInvalidVertex() {
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(-1, 0), "Debería lanzar excepción para un vértice inválido.");
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 5), "Debería lanzar excepción para un vértice inválido.");
    }

    @Test
    public void testAdjacencyListInvalidVertex() {
        assertThrows(IllegalArgumentException.class, () -> graph.adj(-1), "Debería lanzar excepción para un vértice inválido.");
        assertThrows(IllegalArgumentException.class, () -> graph.adj(5), "Debería lanzar excepción para un vértice inválido.");
    }
}
