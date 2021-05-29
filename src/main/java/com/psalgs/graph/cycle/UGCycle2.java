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
 * http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * 
 * Detect cycle in an undirected graph
 * 
 * Time Complexity O ( V + E ) where v is vertices and e is edges
 */
public class UGCycle2 {

    int V;
    LinkedList<Integer>[] adj;

    private UGCycle2(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> itr = adj[v].iterator();

        while (itr.hasNext()) {
            int i = itr.next();

            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                // If an adjacent vertex is visited and is not parent of current
                // vertex, then there is a cycle.
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        UGCycle2 g1 = new UGCycle2(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if (g1.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }

        UGCycle2 g2 = new UGCycle2(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);

        if (g2.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }
    }
}
