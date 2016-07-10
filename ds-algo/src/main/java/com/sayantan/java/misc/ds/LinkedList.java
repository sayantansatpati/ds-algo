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

	public void addArrayToList(int[] data) {
		Node current = head;
		for(int i=0; i < data.length; i++) {
			Node node = new Node(data[i]);
			if(current == null) {
				head = node;
				current = node;
			} else {
				current.next = node;
				current = current.next;
			}
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

	public Node getMiddleNode() {
		if(head.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		System.out.println(String.format("SLOW: %d, FAST: %d", slow.iData, fast.iData));
		while(fast!= null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println(String.format("SLOW: %d, FAST: %s", slow.iData, fast!=null?String.valueOf(fast.iData):"NULL"));
		}
		return slow;
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

	public static class Node {
		public int iData;
		public Node next;

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
