package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import src.GenericListGraph;
//para probar ambas implementaciones descomentar la siguiente linea y cambia la inicializacion
//de graph
//import src.GenericMatrixGraph;


import src.interfaz.Graph;

public class GenericGraphTest {
    Graph<String> graph;

    @BeforeEach
    public void setUp(){
        graph = new GenericListGraph<String>(7);
        graph.addVertex("Logica");
        graph.addVertex("Calculo1");
        graph.addVertex("Int Algebra");
        graph.addVertex("Algebra");
        graph.addVertex("Estadistica");
        graph.addVertex("Algebra Lineal");
        graph.addVertex("Avanzada");
        
    }
    
    @Test
    public void testContains(){
        assertTrue(graph.contains("Logica"));
    }

    @Test
    public void testNumerNodes(){
        assertEquals(7,graph.V());
        
    }

    @Test
    public void testLleno(){
        assertThrows(IllegalArgumentException.class,()-> graph.addVertex("Estructura1"));
    }

    @Test
    public void testAddRepit(){
        assertThrows(IllegalArgumentException.class,()-> graph.addVertex("Logica"));
    }

    @Test
    public void testEdgeNumber(){
        assertEquals(0,graph.E());
        graph.addEdge("Calculo1", "Estadistica");
        graph.addEdge("Int Algebra", "Algebra");
        graph.addEdge("Algebra", "Algebra Lineal");
        assertEquals(3,graph.E());
    }

    
} 
