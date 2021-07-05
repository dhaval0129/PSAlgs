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
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 *
 * Depth First Traversal or DFS for a Graph (Recursive Approach)
 * 
 * Time Complexity: O(V+E)
 * 
 */
public class DFS {

    private int V; // No of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer>[] adj;

    private DFS(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    private void dfsTraversal(int v) {
        // Mark all the vertices as not visited( set as
        // false by default in java )
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean visited[]) {
        // mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recursion for all the vertices adjacent to this vertex
        Iterator<Integer> itr = adj[v].listIterator();

        while (itr.hasNext()) {
            int i = itr.next();

            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String args[]) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.dfsTraversal(2);
        System.out.println();
    }

}
