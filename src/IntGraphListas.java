package src;
import java.util.LinkedList;
import java.util.List;

import src.interfaz.IntGraph;

//grafo no dirigido
public class IntGraphListas implements IntGraph{
    private final int V;
    private int E;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public IntGraphListas(int v){
        if(v<0) throw new IllegalArgumentException();
        this.V = v;
        this.E = 0;
        this.adj = new LinkedList[V];
        for(int i = 0; i<V; i++) adj[i] = new LinkedList<>();
        
    }

    @Override
    public void addEdge(int v, int w) {
        if(v<0 || v>=V) throw new IllegalArgumentException();
        if(w<0 || w>=V) throw new IllegalArgumentException();
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public List<Integer> adj(int v) {
        if(v<0 || v>=V) throw new IllegalArgumentException();
        return adj[v];
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }
}