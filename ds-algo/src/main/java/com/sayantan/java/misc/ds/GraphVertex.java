package com.sayantan.java.misc.ds;


public class GraphVertex<T> {

	public T data;
	private boolean visited = false;
	private GraphVertex<T>[] adjList = null;

	private int MAX_NEIGHBORS = 10;
	private int nVertices = -1;

	public GraphVertex(T data) {
		this.data = data;
		adjList = new GraphVertex[MAX_NEIGHBORS];
	}

	public void addNeighbor(GraphVertex<T> neighbor) {
		if(nVertices < MAX_NEIGHBORS) {
			adjList[++nVertices] = neighbor;
		} else {
			throw new IllegalAccessError("Adjacency List is Full!!!");
		}
	}

	public GraphVertex<T>[] getAdjacencyList() {
		return adjList;
	}

	public void setVisited() {
		this.visited = true;
	}

	public void unsetVisited() {
		this.visited = false;
	}

	public boolean isVisited() {
		return this.visited;
	}

	public void displayNode() {
		System.out.println(String.format("%s", data));
	}
}
