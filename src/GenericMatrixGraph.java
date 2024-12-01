package src;

import java.util.TreeMap;
import src.interfaz.Graph;

public class GenericMatrixGraph<T> implements Graph<T> {
    private int V;
    private int E;
    private TreeMap<T,Integer> map;
    private int[][] adj;

    public GenericMatrixGraph(int v){
        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        adj = new int[v][v];
    }

    @Override
    public void addVertex(T e) {
        if(contains(e)) throw new IllegalArgumentException();
        if(adj.length == V ) throw new IllegalArgumentException("the graph is full");
        map.put(e,V++);
    }

    @Override
    public boolean contains(T v) {
        return map.containsKey(v);
    }

    @Override
    public void addEdge(T v, T w) {
        if(!(contains(v) && contains(w))) throw new IllegalArgumentException();
        adj[map.get(v)][map.get(w)] = 1;
        adj[map.get(w)][map.get(v)] = 1;
        E++;
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }
}
