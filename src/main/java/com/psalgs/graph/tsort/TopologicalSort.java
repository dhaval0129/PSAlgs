/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.tsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/topological-sorting/
 *
 * Topological Sort ( we use Directed Acyclic Graph )
 *
 *  In Topological sort we print first visited node at last ( we keep it in stack )
 */
public class TopologicalSort {

    int V;
    LinkedList<Integer>[] adj;

    private TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void topologicalSort() {
        Stack<Integer> stack = new Stack();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Call recursive helper function to store Topological sort
        // starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topologicalSortUtil(int v, boolean visited[], Stack stack) {
        // Mark the current node as visited.
        visited[v] = true;

        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()) {
            int i = itr.next();

            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String args[]) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        // Directed Acyclic graph (DAG)

        System.out.println("Following is a Topological sort of the given graph");
        graph.topologicalSort();
    }
}
