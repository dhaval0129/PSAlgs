package com.psalgs.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Count the number of nodes at given level in a tree using BFS.
 * 
 * https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
 * 
 * @author djoshi
 *
 */
public class BFSLevelCount {
	
	private static int V;
	private static LinkedList<Integer> adj[];
	private static HashMap<Integer,Integer> level = new HashMap<>();
	
	private static class Graph {
		
		Graph(int v) {
			V = v; 
			adj = new LinkedList[V];
			
			for(int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		private void addEdge(int u, int v) {
			adj[u].add(v);
		}
	}
	
	private void bfsTraverse(int s) {
		
		boolean[] visited = new boolean[V];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		int pollCount = 0;
		int levelCount = 0;
		int count = 0;
		level.put(levelCount++, 1);
		
		while(!queue.isEmpty()) {
			
			s = queue.poll();
			pollCount++;
			System.out.print(s + " ");
			
			visited[s] = true;
			Iterator<Integer> itr = adj[s].iterator();

			while(itr.hasNext()) {
				
				int n = itr.next();
				
				if(!visited[n]) {
					queue.add(n);
					level.put(levelCount, ++count);
				}
			}
			
			if(level.get(levelCount-1) == pollCount) {
				levelCount++;
				pollCount = 0;
				count = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		Graph g = new Graph(9);
		g.addEdge(0,1);
		g.addEdge(0,2);
		
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(2,5);
		
		g.addEdge(2,6);
		
		g.addEdge(4, 7);
		g.addEdge(4, 8);
		
		BFSLevelCount bfs = new BFSLevelCount();
		bfs.bfsTraverse(0);
		
		System.out.println("\nLevel:" + level);
		
	}

}
