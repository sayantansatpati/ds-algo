package com.sayantan.java.misc.ds;


public class LinkedList {

	public Node head;

	public LinkedList() {

	}

	public void insertFirst(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	// head -> 1 -> 2 -> 3 -> null
	public void reverseList() {
		Node prev = head;
		Node curr = prev.next;
		//Following is important for avoiding infinite loops
		prev.next = null;

		while(curr != null) {
			System.out.println(String.format("[Start] Prev: %s, Curr: %s", prev.iData, curr.iData));
			Node tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		//Would point to last element
		head = prev;
	}


	public void displayList() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		int cnt = 0;
		while(current != null) {
			//System.out.println(String.format("%d: %d", cnt, current.iData));
			cnt++;
			if(cnt > 1) {
				sb.append(" --> ");
			}
			sb.append(current.iData);
			current = current.next;
		}
		System.out.println(sb.toString());
	}

	static class Node {
		int iData;
		Node next;

		public Node(int data) {
			this.iData = data;
		}

		public void display() {
			System.out.println("Data: " + iData);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertFirst(10);
		l.insertFirst(20);
		l.insertFirst(30);
		l.insertFirst(40);
		l.insertFirst(50);
		l.displayList();

		l.reverseList();
		l.displayList();
	}

}
