/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 *
 * Breadth First Traversal or BFS for a Graph ( Level order traversal ) Hint:
 * Use Queue
 *
 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is
 * number of edges in the graph
 *
 */
public class BFS {

    private int V; // No of vertices
    private LinkedList<Integer>[] adj; // Adjacency Lists

    private BFS(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void BFS(int s) {
        // Mark all the vertices as not visited ( by default )
        boolean visited[] = new boolean[V];

        // create queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then, mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breath First Traversal (starting from vertex 2) ");
        g.BFS(2);
    }
}
