package com.sayantan.java.ctci.chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sayantan.java.misc.ds.Tree;
import com.sayantan.java.misc.ds.TreeNode;

public class Question43 {


	public static List<List<TreeNode<Integer>>> listTreeNodes = new ArrayList<List<TreeNode<Integer>>>();

	public static void createLinkedListOfNodesPerLevel(Tree tree) {
		if(tree.getRoot() == null) {
			return;
		}

		Queue<TreeNode<Integer>> q = new LinkedBlockingQueue<TreeNode<Integer>>();
		// Add root to Queue
		q.add(tree.getRoot());

		int level = 0;
		while(!q.isEmpty()) {
			List<TreeNode<Integer>> ll_level = new java.util.LinkedList<TreeNode<Integer>>();
			while(!q.isEmpty()) {
				TreeNode<Integer> node = q.remove();
				System.out.println(String.format("[%d] data: %d", level, node.getData()));
				ll_level.add(node);
			}

			for (int i = 0; i < ll_level.size(); i++) {
				TreeNode<Integer> node = ll_level.get(i);
				if(node.getLeft() != null)
					q.add(node.getLeft());
				if(node.getRight() != null)
					q.add(node.getRight());
	        }

			listTreeNodes.add(ll_level);
			level++;
		}

	}

	public static void main(String[] args) {
		Tree tree = new Tree(50);
		tree.traverseInOrderRecur(tree.getRoot());

		boolean found = tree.find(25);
		System.out.println(found);

		found = tree.find(50);
		System.out.println(found);

		tree.insert(40);
		tree.insert(35);
		tree.insert(45);
		tree.insert(60);
		tree.insert(55);
		tree.insert(65);

		System.out.println("[Start]: traverseInOrderRecur");
		tree.traverseInOrderRecur(tree.getRoot());
		System.out.println("[End]: traverseInOrderRecur");

		createLinkedListOfNodesPerLevel(tree);

	}

}
