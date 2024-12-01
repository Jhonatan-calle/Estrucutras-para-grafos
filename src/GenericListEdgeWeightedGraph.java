package src;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lib.DirectedEdge;
import src.interfaz.EdgeWeightedGraph;

public class GenericListEdgeWeightedGraph<T> implements EdgeWeightedGraph<T>{
    private int V;
    private int E;
    private TreeMap<T,Integer> map;
    private List<List<DirectedEdge<T>>> adj;
    private List<T> keys;

    public GenericListEdgeWeightedGraph(int v){
        if(v<0) throw new IllegalArgumentException();
        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        adj = new ArrayList<>(v);
        keys = new ArrayList<>(v);
    }

    public boolean containsVertex(T v){
        return map.containsKey(v);
    }

    public void addVertex(T v){
        if(containsVertex(v)) throw new IllegalArgumentException();
        map.put(v, V++);
        adj.add(new LinkedList<>());
        keys.add(v);
    }

    public void addEdge(DirectedEdge<T> e){
        if(!containsVertex(e.from) || !containsVertex(e.to)) throw new IllegalArgumentException();
        int v_key = map.get(e.from); 
        int w_key = map.get(e.to);
        if(!adj.get(v_key).contains(e)){
            adj.get(v_key).add(e);
            adj.get(w_key).add(new DirectedEdge<T>(e.to, e.from, e.weigth));
            E++;
        }
    }

    @Override
    public List<DirectedEdge<T>> adj(T v) {
        if(!containsVertex(v)) throw new IllegalArgumentException();
        int v_key = map.get(v);
        return adj.get(v_key);
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
