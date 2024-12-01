package src;

import java.util.LinkedList;
import java.util.Queue;

import src.interfaz.IntGraph;

public class BreathSearchFirst {
    
    public BreathSearchFirst(IntGraph graph, int start){
        if(start<0 || start>0) throw new IllegalArgumentException();
        boolean[] marked = new boolean[graph.V()];
        int[] edgeTo = new int[graph.V()];
        Queue<Integer> queue = new LinkedList<>();
        marked[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i: graph.adj(v)){
                if(!marked[i]){
                    marked[i] = true;
                    edgeTo[i] = v;
                    queue.offer(i);
                }
            }
        }
    }
}
