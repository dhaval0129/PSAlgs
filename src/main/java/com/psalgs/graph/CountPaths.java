package com.psalgs.graph;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * Count all possible paths between two vertices
 * 
 * https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
 * 
 * Time Complexity: O(N!)
 * Space Complexity: O(1)
 * 
 * @author djoshi
 *
 */
public class CountPaths {

	static class Graph {

		private static int V;
		private static LinkedList<Integer> adj[];

		Graph(int v) {
			this.V = v;
			adj = new LinkedList[V];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		private void addEdge(int u, int v) {
			adj[u].add(v);
		}

		private int countPathsUtil(int s, int d, int pathCount) {

			if (s == d) {
				pathCount++;
			} else {
				
				ListIterator<Integer> iterator = adj[s].listIterator();
				
				while(iterator.hasNext()) {
					int n = iterator.next();
					pathCount = countPathsUtil(n, d, pathCount);
				}
			}
			
			return pathCount;
		}

		private int countPaths(int s, int d) {
			int pathCount = 0;

			pathCount = countPathsUtil(s, d, pathCount);
			return pathCount;
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);

		int s = 0, d = 3;
		System.out.println(g.countPaths(s, d));
	}

}
