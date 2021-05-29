/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
 *
 * Find if there is a path between two vertices in a directed graph
 *
 */
public class CheckPath {

    private int V; // No of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    private CheckPath(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private boolean isReachable(int s, int d) {
        LinkedList<Integer> temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            Iterator itr = adj[s].listIterator();

            while (itr.hasNext()) {
                int n = (int) itr.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n == d) {
                    return true;
                }

                // Else, continue to do BFS
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }

    public static void main(String args[]) {
        CheckPath graph = new CheckPath(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (graph.isReachable(u, v)) {
            System.out.println("There is a path from " + u + " to " + v);
        } else {
            System.out.println("There is no path from " + u + " to " + v);
        }

        u = 3;
        v = 1;
        if (graph.isReachable(u, v)) {
            System.out.println("There is a path from " + u + " to " + v);
        } else {
            System.out.println("There is no path from " + u + " to " + v);
        }

    }
}
