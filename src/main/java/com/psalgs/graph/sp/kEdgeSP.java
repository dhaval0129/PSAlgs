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
 * http://www.geeksforgeeks.org/shortest-path-exactly-k-edges-directed-weighted-graph/
 *
 * Shortest path with exactly k edges in a directed and weighted graph
 *
 */
public class kEdgeSP {

    static final int V = 4;
    static final int INF = Integer.MAX_VALUE;

    private int shortestPath(int graph[][], int u, int v, int k) {
        // Table to be filled up using DP. The value sp[i][j][e] will
        // store weight of the shortest path from i to j with exactly
        // k edges
        int sp[][][] = new int[V][V][k + 1];

        // Loop for number of edges from 0 to k
        for (int e = 0; e <= k; e++) {

            for (int i = 0; i < V; i++) { // for source

                for (int j = 0; j < V; j++) { // for destination
                    // initialize value
                    sp[i][j][e] = INF;

                    // from base case
                    if (e == 0 && i == j) {
                        sp[i][j][e] = 0;
                    }
                    if (e == 1 && graph[i][j] != INF) {
                        sp[i][j][e] = graph[i][j];
                    }

                    // go to adjacent only when number of edges is
                    // more than 1
                    if (e > 1) {
                        for (int a = 0; a < V; a++) {
                            // There should be an edge from i to a and
                            // a should not be same as either i or j
                            if (graph[i][a] != INF && i != a
                                    && j != a && sp[a][j][e - 1] != INF) {
                                sp[i][j][e] = Math.min(sp[i][j][e],
                                        graph[i][a] + sp[a][j][e - 1]);
                            }
                        }
                    }
                }
            }
        }
        return sp[u][v][k];
    }

    public static void main(String args[]) {
        /* Let us create the graph shown in above diagram*/
        int graph[][] = {
            {0, 10, 3, 2},
            {INF, 0, INF, 7},
            {INF, INF, 0, 6},
            {INF, INF, INF, 0}
        };

        kEdgeSP sp = new kEdgeSP();
        int u = 0, v = 3, k = 2;
        System.out.println("Weight of the shortest path is " + sp.shortestPath(graph, u, v, k));
    }
}
