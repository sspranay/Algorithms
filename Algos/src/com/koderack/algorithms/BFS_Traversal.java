package com.koderack.algorithms;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pranay pramod
 */
public class BFS_Traversal {
    
    private enum colors {WHITE, GRAY, BLACK};
    
    public static void BFS(Graph graph, Integer S){
        int V = graph.V();
        colors[] color = new colors[V];
        int[] distance = new int[V];
        int[] predecessor = new int[V];
        
        for(int i=0; i<V; i++){
            color[i] = colors.WHITE;
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = 0;
        }
        
        Queue<Integer> Q = new LinkedList<>();
        
        color[S] = colors.GRAY;
        distance[S] = 0;
        
        Q.add(S);
        while(!Q.isEmpty()){
            List<Integer> neighbors = new LinkedList<>();
            int u = Q.remove();
            System.out.print("\nProcessing: " + u);
            neighbors = graph.getAdjacencyList(u);
            System.out.print("\nNeighbors: ");
            for(Integer v : neighbors){
                System.out.print(" " + v);
                if(color[v] == colors.WHITE){
                    color[v] = colors.GRAY;
                    distance[v] = distance[u] + 1;
                    predecessor[v] = u;
                    Q.add(v);
                }
            }
            System.out.println("\n******Processed: " + u);
            color[u] = colors.BLACK;
        }
    }
    
}
class DemoBFS{
    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        
        BFS_Traversal BFS = new BFS_Traversal();
        BFS.BFS(graph, 0);
        
    }
}
