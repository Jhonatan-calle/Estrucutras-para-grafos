package src;


import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.IndexMinPQ;
import lib.DirectedEdge;

public class DijkstraSP {
    public double[] distTo;
    public DirectedEdge<Integer>[] edgeTo;
    public IndexMinPQ<Double> pq;
    public int start;

    public DijkstraSP(EdgeWeightedIntGraph G, int start){
        if(start<0 || start>=G.V()) throw new IllegalArgumentException();
        this.start = start;
        distTo = new double[G.V()];
        edgeTo =new DirectedEdge[G.V()];
        for(int i = 0; i<G.V(); i++) distTo[i] = Double.POSITIVE_INFINITY;
        distTo[start] = 0.0;

        pq = new IndexMinPQ<>(G.V());
        pq.insert(start,distTo[start]);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for(DirectedEdge<Integer> e : G.adj(v)) relax(e);
        }
    }

    private void relax(DirectedEdge<Integer> e){
        int v = e.from; int w = e.to;
        if(distTo[w]>distTo[v] + e.weigth){
            distTo[w] = distTo[v] + e.weigth;
            edgeTo[w] = e;
            if(pq.contains(w))pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public List<DirectedEdge<Integer>> pathTo(int v){
        List<DirectedEdge<Integer>> result = new ArrayList<>();
        DirectedEdge<Integer> edge = edgeTo[v];
        result.add(edge);
        while (edge.from != start) {
            edge = edgeTo[edge.from];
            result.addFirst(edge);
        }
        return result;
    }
}
