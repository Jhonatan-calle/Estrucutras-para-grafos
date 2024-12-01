package src;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import src.interfaz.Graph;

public class GenericListGraph<T> implements Graph<T>{
    private int V;
    private int E;
    private TreeMap<T,Integer> map;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")//para eliminar un warning
    public GenericListGraph(int v){
        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        adj = new LinkedList[v];
    }

    @Override
    public void addVertex(T v) {
        if(contains(v)) throw new IllegalArgumentException();
        if(adj.length == V ) throw new IllegalArgumentException("the graph is full");
        map.put(v, V++);
        adj[V-1] = new LinkedList<>();
    }

    @Override
    public void addEdge(T v, T w) {
        if(!contains(v) || !contains(w)) throw new IllegalArgumentException();
        int v_key = map.get(v);
        int w_key = map.get(w);
        if(!adj[v_key].contains(w_key)){
            adj[v_key].add(w_key);
            adj[w_key].add(v_key);
            E++;
        }
    }

    @Override
    public boolean contains(T v) {
        return map.containsKey(v);
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }
}
