/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-given-graph-tree/
 * 
 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 *
 * Check if a given graph is tree or not
 * 
 * ( If there is cycle in graph then it not tree ) 
 *
 * Time Complexity: O(V+E)
 */
public class IsTree {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    private IsTree(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Undirected Graph
    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isCyclicUtil(int v, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            i = it.next();

            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                // If an adjacent is visited and not parent of 
                // current vertex, then there is a cycle.
                return true;
            }
        }
        
        return false;
    }

    private boolean isTree() {
        // Mark all the vertices as not visited and not part
        // of recursion stack
        boolean visited[] = new boolean[V];

        // The call to isCyclicUtil serves multiple purposes
        // It returns true if graph reachable from vertex 0
        // is cyclcic. It also marks all vertices reachable
        // from 0.
        if (isCyclicUtil(0, visited, -1)) {
            return false;
        }

        // (not marked by isCyclicUtil(), then we return false
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // There is no cycle in graph so it is tree
        IsTree g1 = new IsTree(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isTree()) {
            System.out.println("Graph is Tree");
        } else {
            System.out.println("Graph is not Tree");
        }

        // There is cycle in graph below so it not tree
        IsTree g2 = new IsTree(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        if (g2.isTree()) {
            System.out.println("Graph is Tree");
        } else {
            System.out.println("Graph is not Tree");
        }
    }
}
