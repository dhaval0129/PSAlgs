/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 *
 * Check if a graph is strongly connected
 *
 * A directed graph is strongly connected if there is a path between any two
 * pair of vertices
 *
 */
public class StronglyConnected {

    int V;
    List<Integer>[] adj;

    private StronglyConnected(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // A recursive function to print DFS starting from v
    
    private void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;

        Iterator<Integer> itr = adj[v].iterator();

        while (itr.hasNext()) {
            int n = itr.next();

            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    private StronglyConnected getTranspose() {
        StronglyConnected g = new StronglyConnected(V);

        for (int v = 0; v < V; v++) {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> itr = adj[v].listIterator();

            while (itr.hasNext()) {
                g.adj[itr.next()].add(v);
            }
        }
        return g;
    }

    // Check is graph is strongly connected
    private boolean isSC() {
        // Step 1: Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Step 2: Do DFS traversal starting visit all vertices 
        // then return false
        DFSUtil(0, visited);

        // If DFS traversal doesn't visit all vertices, then
        // return false.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        // Step 3: Create a reversed graph
        StronglyConnected gr = getTranspose();

        // Step 4: Mark all the vertices as not visited (For
        // second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Step 5: Do DFS for reversed graph starting from
        // first vertex. Staring Vertex must be same starting
        // point of first DFS
        gr.DFSUtil(0, visited);

        // If all vertices are not visited in second DFS, then
        // return false
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        StronglyConnected graph1 = new StronglyConnected(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 0);
        graph1.addEdge(2, 4);
        graph1.addEdge(4, 2);

        if (graph1.isSC()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        StronglyConnected graph2 = new StronglyConnected(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);

        if (graph2.isSC()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
