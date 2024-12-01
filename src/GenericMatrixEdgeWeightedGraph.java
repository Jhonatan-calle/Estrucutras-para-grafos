package src;


import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import lib.DirectedEdge;
import src.interfaz.EdgeWeightedGraph;

public class GenericMatrixEdgeWeightedGraph<T> implements EdgeWeightedGraph<T>{
    private int V;
    private int E;
    private TreeMap<T,Integer> map;
    private double[][] adj;
    private List<T> keys;

    public GenericMatrixEdgeWeightedGraph(int v){
        if(v<0) throw new IllegalArgumentException();
        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        keys = new ArrayList<>(v);
        adj = new double[v][v];
        //elijo -1 para reprecentar que no hay una arista entre i y j
        for(int i = 0; i<v; i++){
            for(int j = 0; j<v; j++){
                if(i==j) adj[i][j] = 0; 
                else adj[i][j] = -1; 
            }
        }
    }

    public boolean containsVertex(T v){
        return map.containsKey(v);
    }

    public void addVertex(T v){
        if(containsVertex(v)) throw new IllegalArgumentException();
        map.put(v, V++);
        adj[V-1][V-1]= 0.0;
        keys.add(v);
    }

    public void addEdge(DirectedEdge<T> e){
        if(!containsVertex(e.from) || !containsVertex(e.to)) throw new IllegalArgumentException();
        int v_key = map.get(e.from); 
        int w_key = map.get(e.to);
        if(adj[v_key][w_key] == -1){
            adj[v_key][w_key] = e.weigth;
            adj[w_key][v_key] = e.weigth;
            E++;
        }
    }

    @Override
    public List<DirectedEdge<T>> adj(T v) {
        if(!containsVertex(v)) throw new IllegalArgumentException();
        List<DirectedEdge<T>> result = new ArrayList<>();
        int v_key = map.get(v);
        for(int i=0; i<adj.length; i++){
            if(adj[v_key][i] != -1){
                if(v_key == i) continue; //para que no tome los selfLoops como adjacencias
                result.add(new DirectedEdge<T>(v, keys.get(i), adj[v_key][i]));
            }
        }
        return result;
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
