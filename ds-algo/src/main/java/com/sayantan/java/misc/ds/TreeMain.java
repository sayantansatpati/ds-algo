package com.sayantan.java.misc.ds;

public class TreeMain {

	/**
	 * @param args
	 */
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

		System.out.println("[Start]: traverseInOrderNoRecur");
		tree.traverseInOrderRecur(tree.getRoot());
		System.out.println("[End]: traverseInOrderNoRecur");

	}

}
