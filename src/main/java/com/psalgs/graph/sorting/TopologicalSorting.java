/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * https://www.geeksforgeeks.org/topological-sorting/
 *
 * Topological Sorting
 * 
 * 1] DFS and then store last node in stack
 * 2] pop out each and every node from stack
 *
 */
public class TopologicalSorting {

    LinkedList<Integer>[] adj;
    int V;

    TopologicalSorting(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void DFSUtil(int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;
        Iterator<Integer> itr = adj[s].iterator();

        while (itr.hasNext()) {
            int x = itr.next();

            if (!visited[x]) {
                DFSUtil(x, visited, stack);
            }
        }

        stack.add(s);
    }

    private void DFS() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void main(String args[]) {
        TopologicalSorting graph = new TopologicalSorting(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        graph.DFS();
    }

}
