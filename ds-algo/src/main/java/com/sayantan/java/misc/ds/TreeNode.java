package com.sayantan.java.misc.ds;

public class TreeNode<T> {

	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	TreeNode(T key) {
		this.data = key;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public void displayNode() {
		System.out.println(String.format("[Node] Data: %s", data));
	}

}
