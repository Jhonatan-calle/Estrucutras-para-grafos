package src;

import java.util.LinkedList;
import java.util.List;

import lib.DirectedEdge;

public class BellmanFord {
    private final int start;
    private double[] distTo;
    private DirectedEdge<Integer>[] edgeTo;
    private boolean negativeWeight;

    public BellmanFord(EdgeWeightedIntGraph G, int start){
        if(start<0 || start>=G.V()) throw new IllegalArgumentException();
        this.start = start;
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        negativeWeight = false;
        
        //inicializacion
        for(int i = 0; i<G.V(); i++) distTo[i] = Double.POSITIVE_INFINITY;
        distTo[start] = 0.0;

        //bellman-Ford algoritmo
        for(int i = 0; i<G.V(); i++){ 
            for(DirectedEdge e: G.adj(i)) relax(e);
        }
            
        //chequeo de ciclos negativos
        for(int i = 0; i<G.V(); i++){ 
            for(DirectedEdge<Integer> e: G.adj(i)){
                if(distTo[e.to]>distTo[e.from]+e.weigth){
                    negativeWeight = true;
                    break;
                }
                if (negativeWeight) break;
            }
        }  
    }

    private void relax(DirectedEdge<Integer> e){
        if(distTo[e.to]>distTo[e.from]+e.weigth){
            distTo[e.to] = distTo[e.from]+e.weigth;
            edgeTo[e.to] = e;
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public List<DirectedEdge<Integer>> pathTo(int v){
        List<DirectedEdge<Integer>> result = new LinkedList();
        DirectedEdge<Integer> edge = edgeTo[v];
        result.add(edge);
        while (edge.from != start) {
            edge = edgeTo[edge.from];
            result.addFirst(edge);
        }
        return result;
    }

    public boolean hasNegativeCicles(){
        return negativeWeight;
    }

}
