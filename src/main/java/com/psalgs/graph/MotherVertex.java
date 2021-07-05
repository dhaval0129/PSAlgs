/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
 *
 * Find a Mother Vertex in a Graph
 *
 * Mother Vertex is a vertex V such that all other vertices in G can be reached
 * by a path from v.
 *
 * 1] Choose node in graph, start DFS from chosen node 2] If all vertices are
 * true then push that node in stack
 *
 * 3] Repeat step 1 & 2
 *
 */
public class MotherVertex {

    LinkedList<Integer>[] adj;
    int V;

    MotherVertex(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void DFSUtil(int s, boolean[] visited, Stack<Integer> queue) {
        visited[s] = true;

        while (!queue.isEmpty()) {
            Iterator<Integer> itr = adj[s].iterator();

            while (itr.hasNext()) {
                int v = itr.next();

                if (!visited[v]) {
                    queue.push(v);
                    visited[v] = true;
                }
            }

            DFSUtil(queue.pop(), visited, queue);
        }

    }

    private void DFS() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            boolean flag = false;

            stack.push(i);
            DFSUtil(i, visited, stack);

            stack.clear();
            for (int j = 0; j < visited.length; j++) {
                if (!visited[j]) {
                    flag = true;
                    break;
                }
            }

            Arrays.fill(visited, false);
            if (!flag) {
                nodes.add(i);
            }
        }

        System.out.println("Mother Nodes: " + nodes);
    }

    public static void main(String args[]) {
        MotherVertex graph = new MotherVertex(5);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        System.out.println("Following is Depth First Traversal");
        graph.DFS();
    }
}
