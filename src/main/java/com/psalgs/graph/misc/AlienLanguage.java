/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.misc;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 * 
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 *
 * Given a sorted dictionary of an alien language, find order of characters
 *
 * The time complexity of topological sorting is O(V+E) which is O(n + alpha)
 * here. So overall time complexity is O(n + alpha) + O(n + alpha) which is O(n
 * + alpha).
 * 
 * Asked during facebook phone interview
 *
 */
public class AlienLanguage {

    static class Graph {

        private final LinkedList<Integer>[] adjList;

        Graph(int nVertices) {
            adjList = new LinkedList[nVertices];
            for (int i = 0; i < nVertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int startVertex, int endVertex) {
            adjList[startVertex].add(endVertex);
        }

        int getNoOfVertices() {
            return adjList.length;
        }

        // A recursive function used by topologicalSort 
        void topologicalSortUtil(int currVertex, boolean[] visited, Stack<Integer> stack) {
            // Mark the current node as visited. 
            visited[currVertex] = true;

            // Recur for all the vertices adjacent to this vertex 
            for (int adjVertex : adjList[currVertex]) {
                if (!visited[adjVertex]) {
                    topologicalSortUtil(adjVertex, visited, stack);
                }
            }
            // Push current vertex to stack which stores result 
            stack.push(currVertex);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();

            // Mark all the vertices as not visited
            // since default is false no need to enter false in each array location
            boolean[] visited = new boolean[getNoOfVertices()];

            // Call the recursive helper function to store Topological  
            // Sort starting from all vertices one by one 
            for (int i = 0; i < getNoOfVertices(); i++) {

                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // Print contents of stack 
            while (!stack.isEmpty()) {
                System.out.print((char) ('a' + stack.pop()) + " ");
            }
            System.out.println();
        }
    }

    private static void printOrder(String[] words, int alpha) {
        // Create a graph with 'aplha' edges 
        Graph graph = new Graph(alpha);

        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // If we find a mismatching character, then add an edge 
                // from character of word1 to that of word2 
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Print topological sort of the above created graph 
        graph.topologicalSort();
    }

    // This function fidns and prints order 
    // of characer from a sorted array of words. 
    // alpha is number of possible alphabets  
    // starting from 'a'. For simplicity, this 
    // function is written in a way that only 
    // first 'alpha' characters can be there  
    // in words array. For example if alpha 
    //  is 7, then words[] should contain words 
    // having only 'a', 'b','c' 'd', 'e', 'f', 'g' 
    
    public static void main(String args[]) {
         // alpha will be 3 since it contains a, b, c characters in words
        //String[] words = {"caa", "aaa", "aab"};

        // Asked during facebook interview
        
        // alpha will be 3 since it contains a, b, c characters in words
        // String[] words = {"ca", "cb", "cc"};
        
        // alpha will 4 since it contains a,b,c,d
        String[] words = {"cd", "ca", "db", "bb", "ac"};

        printOrder(words, 4);
    }
}
