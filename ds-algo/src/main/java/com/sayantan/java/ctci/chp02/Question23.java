package com.sayantan.java.ctci.chp02;

import com.sayantan.java.misc.ds.LinkedList;
import com.sayantan.java.misc.ds.LinkedList.Node;

public class Question23 {

	private Question23() {

	}

	public static void deleteMiddleNode(Node node) {
		Node previous = node;
		Node current = node;
		while(current != null && current.next != null) {
			previous = current;
			current.iData = current.next.iData;
			current = current.next;
		}
		previous.next = null;
	}

	public static String sum(LinkedList l1, LinkedList l2) {
		/*
		 * Assumptions:
		 * Lists are of equal length
		 * Digits are in reverse order
		 */
		Node current1 = l1.head;
		Node current2 = l2.head;

		int carryOver = 0;
		StringBuilder sb = new StringBuilder();
		while(current1 != null && current2 != null) {
			int sum = current1.iData + current2.iData + carryOver;
			sb.append(String.valueOf(sum % 10));
			carryOver = sum / 10;

			current1 = current1.next;
			current2 = current2.next;
		}

		return sb.toString();
	}

	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.insertFirst(10);
		ll.insertFirst(20);
		ll.insertFirst(30);
		ll.insertFirst(40);
		ll.insertFirst(50);
		ll.insertFirst(60);
		ll.insertFirst(70);

		ll.displayList();
		Node middleNode = ll.getMiddleNode();
		middleNode.display();
		deleteMiddleNode(middleNode);
		ll.displayList();

		LinkedList l1 = new LinkedList();
		l1.insertFirst(6);
		l1.insertFirst(1);
		l1.insertFirst(7);
		l1.displayList();
		LinkedList l2 = new LinkedList();
		l2.insertFirst(2);
		l2.insertFirst(9);
		l2.insertFirst(5);
		l2.displayList();

		System.out.println(sum(l1,l2));
	}

}
