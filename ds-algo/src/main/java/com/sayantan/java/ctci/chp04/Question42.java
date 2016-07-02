package com.sayantan.java.ctci.chp04;

import com.sayantan.java.misc.ds.TreeNode;

public class Question42 {

	public static int[] arr = {10,20,30,40,50,60,70};

	public static TreeNode<Integer> minimalTree(int[] arr, int l, int u) {
		if(u < l) {
			System.out.println(String.format("%d|%d", l, u));
			return null;
		}
		// Create a node using mid point value
		int m = (l+u) / 2;
		System.out.println(String.format("%d - %d - %d", arr[l],arr[m],arr[u]));
		TreeNode<Integer> node = new TreeNode<Integer>(arr[m]);

		System.out.println("L");
		node.setLeft(minimalTree(arr, l, m-1));
		System.out.println("R");
		node.setRight(minimalTree(arr, m+1, u));

		System.out.println("~ NODE: " + node.getData());
		return node;
	}

	public static void traverseInOrderRecur(TreeNode<Integer> node) {
		if(node == null) {
			return;
		}
		traverseInOrderRecur(node.getLeft());
		node.displayNode();
		traverseInOrderRecur(node.getRight());
	}

	public static void main(String[] args) {
		int l = 0;
		int u = arr.length - 1;
		TreeNode<Integer> node = minimalTree(arr, l, u);

		traverseInOrderRecur(node);
	}


}
