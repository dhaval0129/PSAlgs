/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.cycle;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *
 * Detect Cycle in a Directed Graph
 * 
 * Time Complexity O( V + E ) where V is vertices and E is edges
 *
 */
public class DGCycle {

    private int V; // No of vertices

    // Array of lists for Adjacency List Representation
    LinkedList<Integer>[] adj;

    private DGCycle(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private boolean isCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
        if (!visited[v]) {
            // mark the current node as visited and part of recursion stack
            visited[v] = true;
            recStack[v] = true;

            Iterator<Integer> itr = adj[v].iterator();

            while (itr.hasNext()) {
                int i = itr.next();

                if (!visited[i] && isCyclicUtil(i, visited, recStack)) {
                    return true;
                } else if (recStack[i]) {
                    return true;
                }
            }
        }
        // remove vertex from recursion stack
        recStack[v] = false;
        return false;
    }

    public static void main(String args[]) {
        DGCycle graph = new DGCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does't contain cycle");
        }
    }

}
