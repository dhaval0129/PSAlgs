/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author djoshi
 *
 * https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 *
 * Transitive Closure of a Graph using DFS
 *
 * Given a directed graph, find out if a vertex v is reachable from another
 * vertex u for all vertex pairs (u, v) in the given graph. Here reachable mean
 * that there is a path from vertex u to v. The reach-ability matrix is called
 * transitive closure of a graph.
 *
 */
public class TransitiveClosure {
    
    int V;
    LinkedList<Integer>[] adjList;
    
    int[][] tc;
    
    TransitiveClosure(int v) {
        V = v;
        adjList = new LinkedList[v];
        tc = new int[v][v];
        
        // Initialize
        for(int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    private void addEdge(int v, int w) {
        adjList[v].add(w);
    }
    
    private void DFSUtil(int s, int v) {
        tc[s][v] = 1;
        
        for (int adj : adjList[v]) {
            if (tc[s][adj] == 0) {
                DFSUtil(s, adj);
            }
        }
    }
    
    private void transistiveClosure() {
        
        for (int i = 0; i < V; i++) {
            DFSUtil(i, i);
        }
        
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }
    
    public static void main(String args[]) {
        TransitiveClosure graph = new TransitiveClosure(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        System.out.println("Transistive closure matrix is ");
        graph.transistiveClosure();
    }
}
