package com.koderack.algorithms;


import java.util.LinkedList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ppramod
 */
public class Graph {
    private int V,E;
    private List<Integer>[] adjList;

    public Graph(int V) {
        this.V = V;
        E = 0;
        adjList = new LinkedList[V];
        for(int i=0; i<V; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    
    /**
     * Note that we are using the linkedlist as SET and thus not allowing parallel
     * edges
     * @param v1
     * @param v2 
     */
    public void addEdge(int v1, int v2){
        if(!adjList[v1].contains(v2))
            adjList[v1].add(v2);
        // similarly add v2 to v1 adjlist
        if(!adjList[v2].contains(v1))
            adjList[v2].add(v1);
    }
    
    public int V(){
        return V;
    }
    public List<Integer> getAdjacencyList(int vertex){
        return adjList[vertex];
    }
    
    public void printAdjacencyList(){
        int i=0;
        for(List<Integer> v : adjList){
            System.out.print("\n vertex: " + i++ + " => ");
            for(Integer neighbor : v)
                System.out.print(" " + neighbor);
        }
    }
}
class GraphDemo{
    
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
        
        graph.printAdjacencyList();
    }
}