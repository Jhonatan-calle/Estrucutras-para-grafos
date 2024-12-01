package src.interfaz;


public interface Graph<T> {
    
    public void addVertex(T v);

    public int V();

    public int E();

    public boolean contains(T v);

    public void addEdge(T v, T w);

}
