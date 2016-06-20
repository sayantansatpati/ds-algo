package com.sayantan.java.misc.ds;

import java.util.Stack;

public class Tree {

	TreeNode<Integer> root;

	public Tree(int key) {
		root = new TreeNode<Integer>(key);
	}

	public boolean find(int key) {
		TreeNode<Integer> current = root;
		while(current != null && current.getData() != key) {
			if(key < current.getData()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return (current != null? true: false);
	}

	public void insert(int key) {
		TreeNode<Integer> current = root;
		TreeNode<Integer> parent = null;

		while(current != null) {
			//Set Parent
			parent = current;
			if(key < current.getData()) {
				current = current.getLeft();
				if(current == null) {
					parent.setLeft(new TreeNode<Integer>(key));
				}
			} else {
				current = current.getRight();
				if(current == null) {
					parent.setRight(new TreeNode<Integer>(key));
				}
			}
		}

	}

	/*
	 * 3 conditions to check
	 * 1) Node to be deleted is a leaf node
	 * 2) Node to be deleted is a parent with 1 children
	 * 3) Node to be deleted is a parent with 2 children (Toughest)
	 */
	public TreeNode<Integer> delete(int key) {
		return null;
	}

	public TreeNode<Integer> getRoot() {
		return root;
	}

	public void traverseInOrderRecur(TreeNode<Integer> node) {
		if(node == null) {
			return;
		}
		traverseInOrderRecur(node.getLeft());
		node.displayNode();
		traverseInOrderRecur(node.getRight());
	}

	public void traverseInOrderNoRecur(TreeNode<Integer> node) {
		TreeNode<Integer> currNode = getRoot();
		if(currNode == null) {
			return;
		}
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();

		while(!s.isEmpty() || currNode != null) {
			// Go Left all the way till a null is encountered
			if(currNode != null) {
				s.push(currNode);
				currNode = currNode.getLeft();
			// Visit Node, and go right
			} else {
				TreeNode<Integer> pNode = s.pop();
				pNode.displayNode();
				currNode = currNode.getRight();
			}
		}
	}

}
