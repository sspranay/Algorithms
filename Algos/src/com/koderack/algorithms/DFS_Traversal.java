package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pranay
 */
public class DFS_Traversal {
    
    private enum colors {WHITE, GRAY, BLACK};
    colors[] color;
    int[] discoveryTime;
    int[] predecessor;
    int[] finishingTime;
    int V, time=0;
    
    public void DFS(Graph graph){
        V = graph.V();
        color = new colors[V];
        discoveryTime = new int[V];
        predecessor = new int[V];
        finishingTime = new int[V];
        
        for(int i=0; i<V; i++){
            color[i] = colors.WHITE;
            discoveryTime[i] = 0;
            predecessor[i] = -1;
        }
        
        // Understand that for a strongly connected graph, in the for loop,
        //, the condition color[v]==colors.WHITE executes only 1 time
        // then why the for loop?
        // if disconnected graph, we still wanna cover the rest of the components.
        // Interestingly, the BFS we have implemented doesn't cover disconnected graph situation!
        int time = 0;
        for(int v=0; v<V ; v++){
            if(color[v] == colors.WHITE){
                DFS_VISIT(v, graph);
            }
        }
    }
    
    private void DFS_VISIT(int v, Graph graph){
        color[v] = colors.GRAY;
        time += 1;
        discoveryTime[v] = time;
        System.out.println("Grayed " + v);
        for(int u : graph.getAdjacencyList(v)){
            if(color[u] == colors.WHITE){
                System.out.println("white adjacent" + u);
                predecessor[u] = v;
                DFS_VISIT(u,graph);
            }
        }
        System.out.print("\n processed, blackened now " + v);
        color[v] = colors.BLACK; 
        time = time + 1;
        finishingTime[v] = time; 
        System.out.print(" Discovered at " + discoveryTime[v] + " finished at "+ finishingTime[v]);
    }
    
}
class DemoDFS{
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
        
        DFS_Traversal DFS = new DFS_Traversal();
        DFS.DFS(graph);
        
    }
}