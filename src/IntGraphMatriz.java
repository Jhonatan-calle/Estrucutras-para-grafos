package src;
import java.util.ArrayList;
import java.util.List;

import src.interfaz.IntGraph;

public class IntGraphMatriz implements IntGraph {
    private final int V;
    private int E;
    private int[][] adj;

    public IntGraphMatriz(int v){
        if(v<0) throw new IllegalArgumentException();
        this.V = v;
        adj = new int[V][V];
        E = 0;
    }

    @Override
    public void addEdge(int v, int w) {
        if(v<0 || v>=V) throw new IllegalArgumentException();
        if(w<0 || w>=V) throw new IllegalArgumentException();
        if(adj[v][w] != 1){  
            adj[v][w] = 1;
            E++;
        }
    }

    @Override
    public List<Integer> adj(int v) {
        if(v<0 || v>=V) throw new IllegalArgumentException();
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<V; i++) if(adj[v][i] == 1) l.add(i);
        return l;
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
