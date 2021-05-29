/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.bt;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 *
 * HamiltonianCycle Cycle
 *
 * HamiltonianCycle path is undirected graph that visits each vertex exactly
 * once, A HamiltonianCycle cycle (or HamiltonianCycle circuit) is a
 * HamiltonianCycle Path such that there is an edge (in graph) from the last
 * vertex to the first vertex of the HamiltonianCycle Path.
 *
 */
public class HamiltonianCycle {

    final int V = 5;
    int path[];

    /* A utility function to check if the vertex v can be
       added at index 'pos'in the Hamiltonian Cycle
       constructed so far (stored in 'path[]') */
    private boolean isSafe(int v, int graph[][], int path[], int pos) {
        /* Check if this vertex is an adjacent vertex of
           the previously added vertex. */
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        /* check if the vertex has already been included
           This step can be optimized by creating an array of size V
         */
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }

    private boolean hamCycleUtil(int graph[][], int path[], int pos) {
        // base case
        // If all vertices are included in Hamiltonian cycle
        if (pos == V) {
            // And if there is an edge from the last included vertex to the first vertex
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // Try different vertices as a next candidate in
        // Hamiltonian Cycle. We don't try for 0 as we
        // included 0 as starting point in in hamCycle()
        for (int v = 1; v < V; v++) {
            // check if this verex can be added to Hamiltonian cycle
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                /* recur to construct rest of the path */
                if (hamCycleUtil(graph, path, pos + 1)) {
                    return true;
                }

                path[pos] = -1;
            }
        }
        return false;
    }

    private int hamCycle(int graph[][]) {

        // Init path array and set all address locations to -1
        path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }

        /* Let us put vertex 0 as the first vertex in the path.
           If there is a Hamiltonian Cycle, then the path can be
           started from any point of the cycle as the graph is
           undirected */
        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1)) {
            System.out.println("\nSolution does not exist");
            return 0;
        }

        printSolution(path);
        return 1;
    }

    private void printSolution(int path[]) {
        System.out.println("Solution Exists: Following is one Hamiltonian Cycle");

        for (int i = 0; i < V; i++) {
            System.out.print(" " + path[i] + " ");
        }
        // Let us print the first vertex again to show the
        // complete cycle
        System.out.print(" " + path[0] + " ");
    }

    public static void main(String args[]) {
        HamiltonianCycle hamiltonian = new HamiltonianCycle();
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)   
         */
        int graph1[][] = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},};

        // Print the solution
        hamiltonian.hamCycle(graph1);

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0}};

        // Print the solution
        hamiltonian.hamCycle(graph2);
    }
}
