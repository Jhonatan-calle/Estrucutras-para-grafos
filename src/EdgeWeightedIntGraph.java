package src;
import lib.DirectedEdge;

import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedIntGraph {
    private int V;
    private int E;
    private List<DirectedEdge<Integer>>[] adj;

    @SuppressWarnings("unchecked")//elimina warning en linea 16
    public EdgeWeightedIntGraph(int v){
        this.V = v;
        this.E = 0;
        adj = new LinkedList[V];
        for(int i = 0; i<V; i++) adj[i] = new LinkedList<DirectedEdge<Integer>>();
    }

    public void addEdge(DirectedEdge<Integer> e){
        int v = e.from; int w = e.to;
        if(v<0 || v>=V) throw new IllegalArgumentException();
        if(w<0 || w>=V) throw new IllegalArgumentException();
        if(!adj[v].contains(e)){
            adj[v].add(e);
            E++;
        }
    }

    public List<DirectedEdge<Integer>> adj(int v){
        if(v<0 || v>V) throw new IllegalArgumentException();
        return adj[v];
    }
    
    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }
}
