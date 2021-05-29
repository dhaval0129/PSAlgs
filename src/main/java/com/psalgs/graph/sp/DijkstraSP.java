/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.sp;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 *
 * Dijkstra’s shortest path algorithm ( shortest path from source vertex to all
 * other vertex in graph )
 *
 * 1] Declare two arrays int dist[] to hold shortest distance and boolean
 * spSET[] to hold visited vertex
 *
 * 2] Initialize all distances as Infinite (Integer.MAX_VALUE) and stpSet[] as
 * false
 *
 * 3] Distance of source vertex from itself is always 0, we start with vertex 0
 *
 * 4] find shortest path to all vertices from 0 to V-1 using for loop
 *
 * 5] find min dist vertex which is not yet processed and return that vertex
 *
 * 6] set that vertex as true (visited) in spSET boolean array.
 *
 * 7] Update dist[] value of the adjacent vertices of the picked vertex.
 * 
 * 8] based on the condition like, vertex is not visited, there exists direct
 * connection between two vertex, there is finite distance between two vertex
 * and new distance is less then earlier distance update the value is dist[] array
 * 
 * 9] Repeat step 7 till adjacent vertex are visited for picked vertex.
 * 
 * 10] Repeat step 4 till all vertex has been processed
 * 
 * Time Complexity:
 * 
 * Dijksra’s algorithm is a Greedy algorithm and time complexity is O(VLogV) 
 *
 */
public class DijkstraSP {

    static final int V = 9;

    private int minDistance(int dist[], boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++) {
            if (!sptSet[i] && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }

        return min_index;
    }

    private void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    private void dijkstra(int graph[][], int src) {
        // The output array. dist[i] will hold the shortest distance from src to i
        int dist[] = new int[V];

        // sptSet[i] will true if vertex i is included in shortest path tree
        // or shortest distance from src to i is finalized
        boolean sptSet[] = new boolean[V];

        // Initialize all distances as Infinete and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            //sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed 
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // print the constructed distance array
        printSolution(dist, V);
    }

    public static void main(String args[]) {
        int graph[][] = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstraSP t = new DijkstraSP();
        t.dijkstra(graph, 0);
    }
}
