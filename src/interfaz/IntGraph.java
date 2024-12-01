package src.interfaz;
import java.util.List;

/**
 * Represents an interface for an integer-based graph.
 */
public interface IntGraph {

    /**
     * Gets the number of vertices (nodes) in the graph.
     *
     * @return the number of vertices in the graph.
     */
    public int V(); 

    /**
     * Gets the number of edges in the graph.
     *
     * @return the number of edges in the graph.
     */
    public int E();

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param v the first vertex (source).
     * @param w the second vertex (destination).
     * @post An edge is added between the specified vertices.
     * @throws IllegalArgumentException if {@code v} or {@code w} are invalid.
     */
    public void addEdge(int v, int w);

    /**
     * Retrieves all the vertices adjacent to the given vertex.
     *
     * @param v the vertex for which adjacent vertices are required.
     * @return a list of vertices adjecent of {@code v}
     * @throws IllegalArgumentException if {@code v} is invalid.
     */
    public List<Integer> adj(int v);

    
}
