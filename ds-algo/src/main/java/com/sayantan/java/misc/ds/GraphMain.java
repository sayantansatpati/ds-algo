package com.sayantan.java.misc.ds;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphMain {

	/*    B   C
	 * A
	 *    D   E
	 */

	public static void dfs(GraphVertex<String> root) {
		if(root == null) {
			return;
		}

		//System.out.println(String.format("### %s", root.data));

		//Visit Node
		root.displayNode();
		//Mark node as visited
		root.setVisited();

		//
		for(GraphVertex<String> vertex: root.getAdjacencyList()) {
			//System.out.println(String.format("### %s --> %s", root.data, vertex!=null?vertex.data:null));
			if(vertex != null && !vertex.isVisited()) {
				System.out.println(String.format("### %s --> %s", root.data, vertex!=null?vertex.data:null));
				dfs(vertex);
			}
		}
	}

	public static void dfs_stack(GraphVertex<String> root) {
		if(root == null) {
			return;
		}

		Stack<GraphVertex<String>> s = new Stack<GraphVertex<String>>();

		s.add(root);
		//Visit Node
		root.displayNode();
		//Mark node as visited
		root.setVisited();

		while(!s.isEmpty()) {
			GraphVertex<String> vertex = s.peek();

			GraphVertex<String> neighbor = vertex.getUnvisitedNeighbor();
			if(neighbor != null) {
				//Visit Node
				neighbor.displayNode();
				//Mark node as visited
				neighbor.setVisited();
				//Add to stack
				s.push(neighbor);
			} else {
				s.pop();
			}

		}
	}

	public static void bfs(GraphVertex<String> root) {
		if(root == null) {
			return;
		}

		Queue<GraphVertex<String>> q = new LinkedBlockingQueue<GraphVertex<String>>();
		// Add root to Queue
		q.add(root);

		while(!q.isEmpty()) {
			//Pop
			GraphVertex<String> vertex = q.remove();
			//Visit Node
			vertex.displayNode();
			//Mark node as visited
			vertex.setVisited();

			//Add adjacency list to Queue
			for(GraphVertex<String> v: vertex.getAdjacencyList()) {
				if(v != null && !v.isVisited()) {
					System.out.println(String.format("### %s --> %s", vertex.data, v!=null?v.data:null));
					q.add(v);
				}
			}
		}
	}

	public static void unsetVisited(GraphVertex<String> root) {
		if(root == null) {
			return;
		}
		root.unsetVisited();

		for(GraphVertex<String> vertex: root.getAdjacencyList()) {
			if(vertex != null) {
				unsetVisited(vertex);
			}
		}

	}

	public static void main(String[] args) {
		GraphVertex<String> a = new GraphVertex<String>("A");
		GraphVertex<String> b = new GraphVertex<String>("B");
		GraphVertex<String> c = new GraphVertex<String>("C");
		GraphVertex<String> d = new GraphVertex<String>("D");
		GraphVertex<String> e = new GraphVertex<String>("E");
		GraphVertex<String> f = new GraphVertex<String>("F");

		a.addNeighbor(b);
		a.addNeighbor(d);
		b.addNeighbor(c);
		c.addNeighbor(f);
		d.addNeighbor(e);

		System.out.println("### DFS ###");
		dfs(a);
		unsetVisited(a);
		System.out.println("### DFS Using Stack ###");
		dfs_stack(a);
		unsetVisited(a);

		System.out.println("\n### BFS ###");
		bfs(a);
	}

}
