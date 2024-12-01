package src;

import src.interfaz.IntGraph;

public class DepthSearhFirst {
    boolean[] marked;

    public DepthSearhFirst(IntGraph graph, int start){
        if(start < 0 || start >= graph.V()) throw new IllegalArgumentException();
        marked = new boolean[graph.V()];
        dsf(graph,start);
    }

    private void dsf(IntGraph graph, int v){
        marked[v] = true;
        for(int i : graph.adj(v)) if(!marked[i]) dsf(graph, i);
    }

}
