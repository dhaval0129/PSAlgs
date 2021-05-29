/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.tsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 *
 * Kahn’s algorithm for Topological Sorting
 * 
 * 1] Create Adjacency list for the graph.
 * 
 * 2] Calculate and store in-degree for each vertices in array.
 * (In-coming edges to node or no of times node is repeated in adjacency list ) 
 *  Time Complexity: O(V+E) to calculate in-degree
 * 
 * 3] Create new Queue and enqueue/add vertices with in-degree 0 
 * 
 * 4] Create Array-list to store vertices which are popped from queue.
 * 
 * 5] while queue is not empty process each vertices on step 6
 * 
 * 6] pop vertices from queue and add to array list.
 * 
 * 7] Go through each node attached to vertices in adjacency list 
 *    and lower the in-degree count for each vertices from in-degree array
 * 
 * 8] If in-degree of any node is zero then add to queue
 * 
 * 9] Maintain a count how many times the step 5 is executed
 * 
 * 10] After queue is empty compare count with vertices variable V
 * if both counts are not equal then there is cycle in graph 
 * and return method to main function
 * 
 * 11] If there is no cycle print Array list used to used store popped values from queue
 * in ascending order or starting from zero to N;
 * 
 * 12] Printing will give result of topological sort using Kahn's Algorithm
 *
 * Over all Time Complexity : O(V+E) where V is vertices and E is edges
 */
public class KahnTopoSort {

    int V;
    List<Integer>[] adj;

    private KahnTopoSort(int v) {
        V = v;
        adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void topologicalSort() {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        int indegree[] = new int[V];

        // Traverse adjacency lists to fill indegress of vertices
        // This step takes O( V + E ) time
        // It fills array with the count number times node is repeated in adjacency list
        for (int i = 0; i < V; i++) {
            List<Integer> temp = (ArrayList<Integer>) adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Initialize count of visited vertices
        int cnt = 0;
        // create a arraylist to store result ( A topological ordering of the vertices )
        List<Integer> topOrder = new ArrayList<>();

        // Time Complexity: O(V+E)
        while (!q.isEmpty()) {

            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all its neighbouring nodes
            // of dequeued node u and decrease their in-degree by 1
            for (int node : adj[u]) {
                // If in-degree becomes zero, add it to queue
                if (--indegree[node] == 0) {
                    q.add(node);
                }
            }
            cnt++;
        }

        // Check if there was a cycle       
        if (cnt != V) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        // Print topological order          
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        KahnTopoSort graph = new KahnTopoSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        graph.topologicalSort();
    }
}
