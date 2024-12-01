package src.interfaz;

import java.util.List;

import lib.DirectedEdge;


/**
 * An interface representing a graph with integer nodes.
 * Provides basic methods to query its structure.
 */
public interface EdgeWeightedGraph<T> {
    
    /**
     *
     * @return the number of nodes.
     */
    public int V(); 

    /**
     *
     * @return the number of edges.
     */
    public int E();


    public void addVertex(T v);

    public void addEdge(DirectedEdge<T> e);

    public boolean containsVertex(T v);

    /**
     *
     * @param v the node for which to find adjacent nodes.
     * @return a list of nodes adjacent to {@code v}.
     * @throws IllegalArgumentException if {@code v} is not a valid node.
     */
    public List<DirectedEdge<T>> adj(T v);
}
