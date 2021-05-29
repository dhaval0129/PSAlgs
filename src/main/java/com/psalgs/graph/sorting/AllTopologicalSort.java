/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.sorting;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author djoshi
 * 
 * https://www.geeksforgeeks.org/all-topological-sorts-of-a-directed-acyclic-graph/
 * 
 * Use Backtracking 
 */
public class AllTopologicalSort {

    int V;
    LinkedList<Integer>[] adj;

    private AllTopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void allTopologicalSortsUtil(boolean[] visited,
            int[] indegree, ArrayList<Integer> stack) {

        boolean flag = false;
        
        for (int i = 0; i < V; i++) {
            
            if (!visited[i] && indegree[i] == 0) {
                visited[i] = true;
                stack.add(i);
                
                for(int a: adj[i]) {
                    indegree[a]--;
                }
                
                allTopologicalSortsUtil(visited, indegree, stack); 
                visited[i] = false;
                stack.remove(stack.size() - 1);
                
                for(int a: adj[i]) {
                    indegree[a]++;
                }                
                flag = true;
            }
        }
        
        if(!flag) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    public void allTopologicalSorts() {
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int var : adj[i]) {
                indegree[var]++;
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();
        allTopologicalSortsUtil(visited, indegree, stack);
    }

    public static void main(String args[]) {
        AllTopologicalSort graph = new AllTopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("All Topological sorts");
        graph.allTopologicalSorts();
    }
}
