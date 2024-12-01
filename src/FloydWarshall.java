package src;

import java.util.ArrayList;
import java.util.List;

import lib.DirectedEdge;

public class FloydWarshall {
    private double[][] distTo;
    private int[][] path;

    public FloydWarshall(EdgeWeightedIntGraph G){
        distTo = new double[G.V()][G.V()];
        path = new int[G.V()][G.V()];

        //inicializacion
        for(int i = 0; i<G.V(); i++){
            for(int j = 0; j<G.V(); j++){
                if(i==j) distTo[i][j] = 0;
                else distTo[i][j] = Double.POSITIVE_INFINITY;
                path[i][j]=-1;
            }
        }

        // Configuración inicial con las aristas del grafo
        for(int i=0; i<G.V(); i++){
            for(DirectedEdge<Integer> e: G.adj(i)){
                distTo[e.from][e.to] = e.weigth;
                path[e.from][e.to] = e.to;
            }
        }

        // Algoritmo Floyd-Warshall
        for (int k = 0; k < G.V(); k++) {
            for (int i = 0; i < G.V(); i++) {
                for (int j = 0; j < G.V(); j++) {
                    if (distTo[i][j] > distTo[i][k] + distTo[k][j]) {
                        distTo[i][j] = distTo[i][k] + distTo[k][j];
                        path[i][j] = path[i][k];  // Actualizamos el camino intermedio
                    }
                }
            }
        }
    }

    public double distTo(int start, int end){
        return distTo[start][end];
    }

    public List<Integer> pathTo(int start, int end){
        List<Integer> result = new ArrayList<>();
        result.add(start);
        int current = start;
        while (current != end) {
            current = path[current][end];
            result.add(current);
        }
        return result;
    }
}