/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.connectivity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * https://www.geeksforgeeks.org/strongly-connected-components/
 *
 * Strongly Connected Components
 *
 * A directed graph is strongly connected if there is a path between all pairs
 * of vertices.
 *
 * Time Complexity: O(V+E)
 * 
 * 1] Fill stack with last visited element in of graph with fillOrder function
 * 2] Reverse/transpose the graph
 * 3] Now start DFS by popping elements from stack
 * 
 */
public class SCC {

    private int V;
    private LinkedList<Integer> adj[];

    SCC(int v) {
        this.V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph 
    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function to print DFS starting from v 
    private void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " "); 
        
        Iterator<Integer> itr = adj[v].listIterator();

        while (itr.hasNext()) {
            int n = itr.next();

            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Function that returns reverse (or transpose) of this graph
    private SCC getTranspose() {
        SCC graph = new SCC(V);

        for (int v = 0; v < V; v++) {
            Iterator<Integer> itr = adj[v].listIterator();
            while (itr.hasNext()) {
                graph.adj[itr.next()].add(v);
            }
        }
        return graph;
    }

    private void fillOrder(int v, boolean visited[], Stack stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertieces adjacent to this vertex
        Iterator<Integer> itr = adj[v].iterator();

        while (itr.hasNext()) {
            int n = itr.next();

            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }

        // All vertices reachable from v are processed by now
        // push v to Stack 
        stack.push(v);
    }

    // This function finds and connect all strongly connected components
    private void printSCCs() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS) 
        boolean visited[] = new boolean[V];

        // Fill vertices in stack according to their finishing times 
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Create a reversed graph 
        SCC graph = getTranspose();
        // Mark all the vertices as not visited (For second DFS)
        Arrays.fill(visited, false);

        // Now process all vertices in order defined by Stack 
        while (!stack.isEmpty()) {
            // Pop a vertex from stack 
            int v = (int) stack.pop();

            // Print Strongly connected component of the popped vertex 
            if (!visited[v]) {
                graph.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        SCC graph = new SCC(5);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(4, 1); 
        graph.addEdge(6, 4); 
        graph.addEdge(5, 6); 
        graph.addEdge(5, 2); 
        graph.addEdge(6, 0); 

        System.out.println("Following are strongly connected components in given graph");
        graph.printSCCs();
    }
}
