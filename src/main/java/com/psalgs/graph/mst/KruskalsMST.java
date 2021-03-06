/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.mst;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 *
 * Kruskal's Minimum Spanning Tree Algorithm
 *
 * Time Complexity: O(ElogE) or O(ElogV).
 */
public class KruskalsMST {

    class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int weight;

        // Comparator function used for sorting edges based on their weight
        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {

        int parent;
        int rank;
    }

    int V, E;     // V -> no. of vertices & E -> no. of edges
    Edge edge[]; // collection of all edges

    private int find(subset subsets[], int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    private void union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    private KruskalsMST(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];

        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    private void KruskalMST() {
        Edge result[] = new Edge[V]; // This will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges

        for (i = 0; i < V; ++i) {
            result[i] = new Edge();
        }

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new subset();
        }

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == "
                    + result[i].weight);
        }
    }

    public static void main(String args[]) {
        /* Let us create following weighted graph
                10
            0--------1
            |  \     |
          6 |    \   | 15
            |      \ |
            2--------3
                4       
         */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph        
        KruskalsMST graph = new KruskalsMST(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

}
