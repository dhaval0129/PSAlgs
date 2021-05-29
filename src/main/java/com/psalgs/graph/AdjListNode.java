/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.LinkedList;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/graph-and-its-representations/
 * 
 * Graph and It's representation ( Adjacency List )
 *  
 */
public class AdjListNode {

    static class Graph {

        int V;
        LinkedList<Integer>[] adjListArray;

        // constructor
        Graph(int V) {
            this.V = V;
            // define the size of array as number of vertices
            adjListArray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    private static void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest
        graph.adjListArray[src].addFirst(dest);
        // Since graph is undirected, add an edge from dest to src also
        graph.adjListArray[dest].addFirst(src);
    }

    private static void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");

            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        // Create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of the above graph
        printGraph(graph);
    }
}
