/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 *
 * Iterative Depth First Traversal of Graph 
 * Hint: Use Stack
 *
 */
public class DFS_Itr {

    static class Graph {

        int V; // number of vertices
        LinkedList<Integer> adj[]; // adjacency lists

        Graph(int v) {
            this.V = v;
            adj = new LinkedList[V];

            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        private void addEdge(int v, int w) {
            adj[v].add(w);
        }

        private void DFS(int s) {
            // Mark all vertices as not visited
            boolean visited[] = new boolean[V];

            // create a stack for DFS
            Stack<Integer> stack = new Stack<>();

            // push the current source node
            stack.push(s);

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            while (!stack.isEmpty()) {
                s = stack.pop();

                if (!visited[s]) {
                    System.out.print(s + " ");
                    visited[s] = true;
                }

                // Get all adjacent vertices of the popped vertex s
                // If a adjacent has not been visited, then puah it
                // to the stack.
                Iterator<Integer> itr = adj[s].iterator();

                while (itr.hasNext()) {
                    int i = itr.next();
                    if (!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        // Total 5 vertices in graph
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }
}
